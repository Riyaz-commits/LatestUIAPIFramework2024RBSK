package runner.webRunner.IgnorePractise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PractiseSession {

   public static WebDriver driver;



    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Suucessfully Launched the browser");

    }

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        return new Object[][]{
                {"Admin", "admin123"},
                {"invlid", "invalidadmin123"},
                {"inrvlid", "invrisidadmin123"},
        };
    }

    @Test(dataProvider = "credentials")
    public void login(String userName, String password) {
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        System.out.println("Suucessfully Executed the test case 1 ");

    }


    @Test (invocationCount = 5)
    public void loginvalidateLinkAtBottom() {

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        WebElement hyperLink = driver.findElement(By.xpath("//*[contains(text(),'OrangeHRM, Inc')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500);");

        System.out.println("Scroled");


        js.executeScript("arguments[0].style.border = '2px solid red';arguments[0].style.backgroundColor = 'yellow';", hyperLink);
        System.out.println("color added");
        js.executeScript("arguments[0].click();", hyperLink);
        System.out.println("Suucessfully Executed the test case 2 ");


    }

   /* @AfterMethod
    public void tearDown() {
        System.out.println("Closing the browser");
        driver.quit();
    }*/


}
