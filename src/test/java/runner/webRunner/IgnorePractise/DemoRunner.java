package runner.webRunner.IgnorePractise;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class DemoRunner {

    public static void main(String[] args) throws InterruptedException, IOException {


        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

driver.findElement(By.name("username")).sendKeys("Admin");
driver.findElement(By.name("password")).sendKeys("admin123");
driver.findElement(By.xpath("//*[@type='submit']")).click();
WebElement hyperLink =driver.findElement(By.xpath("//*[contains(text(),'OrangeHRM, Inc')]"));



JavascriptExecutor js = (JavascriptExecutor) driver;

 /*js.executeScript("window.scrollBy(0,1500);");

        System.out.println("Scroled");
*/

        js.executeScript("arguments[0].style.border = '2px solid red';arguments[0].style.backgroundColor = 'yellow';",hyperLink);
        System.out.println("color added");
        js.executeScript("arguments[0].click();",hyperLink);

    }

}
