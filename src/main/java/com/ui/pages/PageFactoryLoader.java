package com.ui.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryLoader {

    public static LoginPage loginPage;
    public static ProductPage productPage;
    public void loadPageFactory(WebDriver driver)
    {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }


}
