package stepDefinitions.support.ui;

import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import utils.helpers.FileUtil;
import com.cucumber.listener.Reporter;

import java.io.File;
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

    @Before(order =0)
    public static void initialization(Scenario scenario)
    {
        cScenario = scenario;
        Collection<String> tags = cScenario.getSourceTagNames();
        setScenario(scenario);
        launchUrl();
        pageFactoryLoader.loadPageFactory(driver);
        setScenario(scenario);
    }

    @Before(order = 1)
    public void login(){

       /* System.out.println("It is pre step took from @Before Hook ");
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();*/

    }
    @After(order = 0)
    public void afterScenario(Scenario scenario){
       // fileUtil.createDirectoryAtProjectPath("reportLogs");
        driver.manage().deleteAllCookies();
       // driver.quit();

    }


}
