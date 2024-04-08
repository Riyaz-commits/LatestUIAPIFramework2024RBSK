package runner.webRunner.IgnorePractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ActionsSession {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.id("newTabsBtn")).click();
        System.out.println(driver.getTitle());

        String parentWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {

            if (!parentWindow.equalsIgnoreCase(windowHandle)) {
                driver.switchTo().window(windowHandle);

                if (driver.getTitle().contains("Basic Controls -")) {

                    String basicContorlPage = driver.findElement(By.xpath("//*[@itemprop='name' and contains(text(),'Basic Control')]")).getText();

                    if (basicContorlPage.equalsIgnoreCase("Basic Controls")) {

                        System.out.println("Successfully Switched to Basic control page");

                        driver.quit();

                    }
                }

            }

        }

        System.out.println("Child window title is " + driver.getTitle());
        driver.switchTo().window(parentWindow);
        System.out.println("parent window title is " + driver.getTitle());
    }
}
