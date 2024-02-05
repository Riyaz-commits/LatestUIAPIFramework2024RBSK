package runner.webRunner;

import static com.ui.BaseClass.loadProperties;

import com.ui.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


@CucumberOptions(
        features = "src/test/resources/features",
        glue={"stepDefinitions/ui","stepDefinitions/support/ui"},
        plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@Login"
)

public class TestUIRunner extends AbstractTestNGCucumberTests {

    String cucumberTag;
    @BeforeSuite
   public void setUp()
   {
       loadProperties();
       System.out.println("Launching Browser");
       BaseClass.launchBrowser();
   }

   @AfterSuite
    public void tearDown(){
      //  BaseClass.closeBrowser();
   }

}
