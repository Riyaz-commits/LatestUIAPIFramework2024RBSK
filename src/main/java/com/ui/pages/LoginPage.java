package com.ui.pages;

import com.ui.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.actions.UIUtils;

public class LoginPage  extends BaseClass {


    public LoginPage(WebDriver driver)
    {
        BaseClass.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public  UIUtils utils = new UIUtils(driver);

    @FindBy(xpath="//*[@id='user-name']")
    public WebElement username;

    @FindBy(xpath="//*[@id='password']")
    public WebElement password;

    @FindBy(xpath="//*[@id='login-button']")
    public WebElement loginButton;



    public void loginToPage() throws InterruptedException {
        utils.setValue(username,"standard_user");
        Thread.sleep(3000);
        utils.setValue(password,"secret_sauce");
        utils.click(loginButton);
        StepTakesScreenshot(cScenario);
    }
}
