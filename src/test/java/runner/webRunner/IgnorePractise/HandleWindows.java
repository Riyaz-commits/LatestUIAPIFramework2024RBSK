package runner.webRunner.IgnorePractise;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import utils.helpers.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HandleWindows {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\RIYAZ BASHA SHAIK\\Projects\\UI_API_Automation_Framework\\src\\main\\resources\\properties\\config.properties");
        prop.load(fileInputStream);

        driver.get(prop.getProperty("orangeHrmUrl"));

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        driver.close();


    }


    public static void captureScreenshot(WebDriver driver) throws IOException {
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try{
            Random r = new Random();
           int dynamic= r.nextInt();
            FileUtils.copyFile(screenShotFile, new File("C:\\Users\\RIYAZ BASHA SHAIK\\Projects\\UI_API_Automation_Framework\\ProofScreenshot"+dynamic+".png"));
            System.out.println("Screenshot tooks successfully");
        }
        catch (IOException e){
            System.out.println("Sorry Screenshot is not captured");
        }



    }
}
