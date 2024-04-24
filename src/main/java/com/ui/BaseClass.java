package com.ui;

import com.ui.pages.PageFactoryLoader;

import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Step;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import reader.ConfigPropertyReader;
import reporter.UtilLoader;
import utils.helpers.FileUtil;
import org.openqa.selenium.io.FileHandler;


import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;


public class BaseClass {

    public static UtilLoader utilLoader = new UtilLoader();
    public static WebDriver driver;
    public static WebDriver webSession1;
    public static Boolean captureNetworkLogs = false;
    public static PageFactory pageFactory = new PageFactory();
    public static byte[] screenshot;
    public static Scenario cScenario;
    public static PageFactoryLoader pageFactoryLoader = new PageFactoryLoader();
    static final ConfigPropertyReader read = new ConfigPropertyReader();
    public static final HashMap<String, byte[]> screenshotMap = new HashMap<>();
    static FileUtil fileUtil = new FileUtil();


    public static void launchUrl() {
        try {
            if (driver == null) {
                launchBrowser();
            }
            driver.get(System.getProperty("url"));
        } catch (Exception e) {

        }
    }

    public static void launchBrowser() {
        driver = BaseClass.createWebDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void createBrowser(WebDriver webDriver) {

        String browser = getBrowserType();


    }

    public static WebDriver createWebDriver(WebDriver driver) {

        String browser = getBrowserType();
        switch (browser.toUpperCase()) {
            case "CHROME":
                driver = chrome(captureNetworkLogs);
                break;
        }
        return driver;
    }

    public static WebDriver chrome(boolean captureNetworkLogs) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions(true));
        return driver;
    }

    public static ChromeOptions getChromeOptions(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        return options;
    }

    public static String getBrowserType() {
        return System.getProperty("browser").toLowerCase();
    }

    public static void loadProperties() {
        read.loadProperties();
        utilLoader.loadUtilsFactory();

    }

    public static void setScenario(Scenario scenario) {
        cScenario = scenario;
    }



    public static void closeBrowser() {
   //driver.close();
        driver.quit();
        System.out.println("Completed the execution");
    }

    public static void StepTakesScreenshot(Scenario scenario) {
        try {
            String screenshotName = "Screenshot" + System.currentTimeMillis();
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File sourceScreenShot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            fileUtil.createDirectoryAtProjectPath("reportLogs", sourceScreenShot, scenario);
            scenario.attach(screenshot, "image/png", screenshotName);
            screenshotMap.put(scenario.getName() + "_" + screenshotName, screenshot);

        } catch (Exception ignored) {
            System.out.println();
        }
    }


}
