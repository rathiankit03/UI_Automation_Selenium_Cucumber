package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import utils.*;

public class BasePage extends BrowserDriver {

    protected WaitHelper wait;
    protected Helper helper;

    public BasePage() {
        this.wait = new WaitHelper();
        this.helper = new Helper();
        PageFactory.initElements(driver, this);
    }

    public void setTheScreenSize(String screenSize) {
        switch (screenSize.toLowerCase()) {
            case "max":
                driver.manage().window().maximize();
                break;
            case "1024 x 768":
                driver.manage().window().setSize(new Dimension(1024, 768));
                break;
            case "800 x 600":
                driver.manage().window().setSize(new Dimension(800, 600));
                break;
            default:
                throw new IllegalArgumentException("Invalid screen size: " + screenSize);
        }
    }
}