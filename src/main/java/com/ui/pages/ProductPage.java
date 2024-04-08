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

    @FindBy(xpath="//*[@id='add-to-cart-sauce-labs-backpack' or @name='add-to-cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@data-test='shopping-cart-link']")
    public WebElement cart;

    @FindBy(xpath = "//*[@id='checkout']")
    public WebElement checkOut;

    @FindBy(xpath = "//*[@placeholder='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@placeholder='Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@placeholder='Zip/Postal Code']")
    public WebElement zipCode;



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


    public void fillCheckoutDetails() throws InterruptedException {
        utils.setValue(firstName,"Captain");
        Thread.sleep(3000);
        utils.setValue(lastName,"America");
        utils.setValue(zipCode,"934533");
        StepTakesScreenshot(cScenario);
    }
}
