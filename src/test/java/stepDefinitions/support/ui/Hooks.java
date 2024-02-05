package stepDefinitions.support.ui;

import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import utils.helpers.FileUtil;


import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.ui.BaseClass.*;

public class Hooks {
    public static  Scenario cScenario;
    private static HashMap<Integer,String> scenarios;
    PickleStepTestStep currentStep;
    private int counter = 0;
FileUtil fileUtil = new FileUtil();
    public Hooks() {
        if(scenarios == null)
            scenarios = new HashMap<Integer,String>();
    }

    @Before()
    public static void initialization(Scenario scenario)
    {
        cScenario = scenario;
        Collection<String> tags = cScenario.getSourceTagNames();
        setScenario(scenario);
        launchUrl();
        pageFactoryLoader.loadPageFactory(driver);
        setScenario(scenario);
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario){
       // fileUtil.createDirectoryAtProjectPath("reportLogs");
        driver.manage().deleteAllCookies();


    }
}
