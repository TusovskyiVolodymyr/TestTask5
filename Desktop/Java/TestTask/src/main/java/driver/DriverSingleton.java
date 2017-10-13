package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverSingleton() {
    }
    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        WebDriver instance;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        instance = new ChromeDriver();
        webDriverThreadLocal.set(instance);
        return webDriverThreadLocal.get();
    }
    public static void quit() {
        try {
            webDriverThreadLocal.get().quit();
        } finally {
            webDriverThreadLocal.remove();
        }
    }
}

