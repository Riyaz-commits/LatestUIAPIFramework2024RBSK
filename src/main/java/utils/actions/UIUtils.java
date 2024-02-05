package utils.actions;

import com.ui.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIUtils extends BaseClass {
    public UIUtils(WebDriver driver) {
       BaseClass.driver= driver;
    }

    final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public void click(WebElement element){
        waitForElementTobeClickable(element);
    }

    public void waitForElementTobeClickable(WebElement element)
    {
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);

        wait.until(driver1 -> element.isEnabled());
        element.click();
    }

    public void setValue(WebElement element, String value)
    {
        waitForElementForSeconds(element,80);
        element.sendKeys(value);
    }

    public  void waitForElementForSeconds(WebElement element, int timeout){
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait1.until(ExpectedConditions.visibilityOf(element));
    }
}
