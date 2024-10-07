package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public static String urlOfXM = "https://www.xm.com/au/";

    @FindBy(xpath = "//*[@id = 'cookieModal']")
    private WebElement cookieModal;

    @FindBy(xpath = "//button[text() = 'ACCEPT ALL']")
    private WebElement acceptAllButtonOnDialog;

    @FindBy(xpath = "//*[@class = 'main_nav_research']")
    private WebElement researchAndEducationMenuLVP;

    @FindBy(xpath = "//button[@class = 'toggleLeftNav']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//*[@aria-controls = 'researchMenu']")
    private WebElement researchAndEducationMenuSVP;

    @FindBy(linkText = "Economic Calendar")
    private WebElement economicCalendarLinkLVP;

    @FindBy(xpath = "//a[span[text()='Economic Calendar']]")
    private WebElement economicCalendarLinkSVP;

    @FindBy(partialLinkText = "Educational Videos")
    private WebElement educationalVideosLinkLVP;

    @FindBy(xpath = "//i[contains(@class,'fa-futbol-o')]//parent::a")
    private WebElement educationalVideosLinkSVP;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get(urlOfXM);
    }

    public void acceptCookieIfItIsDisplayed() {
        wait.waitForElementToBeVisible(cookieModal);
        if (cookieModal.isDisplayed()) {
            acceptAllButtonOnDialog.click();
        }
    }

    public void clickResearchAndEducationMenu(String screenSize) {
        if (screenSize == null) {
            throw new IllegalStateException("Screen size has not been set in the ScenarioContext.");
        }

        if (screenSize.equals("800 x 600")) {
            // For Small View Port
            hamburgerMenu.click();
            wait.waitForElementToBeClickable(researchAndEducationMenuSVP);
            helper.scrollToWebElement(researchAndEducationMenuSVP);
            researchAndEducationMenuSVP.click();
        } else {
            // For Large View port
            wait.waitForElementToBeClickable(researchAndEducationMenuLVP);
            researchAndEducationMenuLVP.click();
        }
    }

    public void clickEconomicCalendarLink(String screenSize) {
        if (screenSize == null) {
            throw new IllegalStateException("Screen size has not been set in the ScenarioContext.");
        }

        if (screenSize.equals("800 x 600")) {
            wait.waitForElementToBeVisible(economicCalendarLinkSVP);
            helper.scrollToWebElement(economicCalendarLinkSVP);
            economicCalendarLinkSVP.click();
        } else {
            // For Large View port
            helper.scrollToWebElement(economicCalendarLinkLVP);
            economicCalendarLinkLVP.click();
        }
    }

    public void clickEducationalVideosLink(String screenSize) {
        if (screenSize == null) {
            throw new IllegalStateException("Screen size has not been set in the ScenarioContext.");
        }

        if (screenSize.equals("800 x 600")) {
            wait.waitForElementToBeVisible(educationalVideosLinkSVP);
            helper.scrollToWebElement(educationalVideosLinkSVP);
            wait.waitForElementToBeClickable(educationalVideosLinkSVP);
            educationalVideosLinkSVP.click();
        } else {
            // For Large View port
            helper.scrollToWebElement(educationalVideosLinkLVP);
            educationalVideosLinkLVP.click();
        }
    }
}
