package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Helper extends BrowserDriver {

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void scrollToWebElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
