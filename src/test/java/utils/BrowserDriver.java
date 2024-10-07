package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserDriver {

    public static WebDriver driver;

    public BrowserDriver() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "/src/test/resources/driver/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "/src/test/resources/driver/chromedriver");
        } else if (os.contains("nix") || os.contains("nux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                    "/src/test/resources/driver/chromedriver_linux");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        if (driver == null) {
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
    };

    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
