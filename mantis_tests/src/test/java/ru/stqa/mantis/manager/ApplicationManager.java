package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {
    private static WebDriver driver;
    private Properties properties;
    private String browser;
    private SessionHelper sessionHelper;

    public void init(String browser, Properties properties){
        this.properties = properties;
        this.browser = browser;

    }

    public WebDriver driver(){
        if (driver == null){ if ("firefox".equals(browser)){
            driver = new FirefoxDriver();
        } else if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else {
            throw  new IllegalArgumentException(String.format("Unkown browser %s", browser));
        }
            //закрыть браузер после всех тестов-->@After удаляется
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1500, 1240));

        }


        return driver;
    }

    public SessionHelper session(){
        if (sessionHelper == null){
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }

}
