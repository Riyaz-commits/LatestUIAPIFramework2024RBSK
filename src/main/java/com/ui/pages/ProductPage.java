package com.ui.pages;

import com.ui.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.actions.UIUtils;

public class ProductPage extends BaseClass {
    public ProductPage(WebDriver driver)
    {
        BaseClass.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public UIUtils utils = new UIUtils(driver);
    @FindBy(xpath="//*[contains(text(),'Sauce Labs Backpack')]")
    public WebElement backPackClick;

    @FindBy(xpath="//*[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@id='shopping_cart_container']")
    public WebElement cart;

    @FindBy(xpath = "//*[@id='checkout']")
    public WebElement checkOut;

    public void clickProduct() throws InterruptedException {

        utils.click(backPackClick);
        StepTakesScreenshot(cScenario);
        utils.click(addToCart);
        utils.click(cart);
        StepTakesScreenshot(cScenario);
        Thread.sleep(3000);
        utils.click(checkOut);
        StepTakesScreenshot(cScenario);
    }
}
