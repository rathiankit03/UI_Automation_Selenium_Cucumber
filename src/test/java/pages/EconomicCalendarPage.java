package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EconomicCalendarPage extends BasePage {

    @FindBy(xpath = "//iframe[contains(@id , 'iFrameResizer')]")
    private WebElement iframe;

    @FindBy(xpath = "//*[@class = 'mat-slider-thumb']")
    private WebElement sliderPointer;

    @FindBy(xpath = "//*[contains(@class,'tc-calendar-button')]")
    private WebElement calendarButtonSVP;

    @FindBy(xpath = "//*[contains(@class, 'c-economic-calendar-item-header-left-title')]")
    private WebElement dateDisplayedOnCalendar;

    @FindBy(xpath = "//*[@class = 'tc-timeframe']//*[@class = 'ng-star-inserted']")
    private WebElement sliderText;

    public EconomicCalendarPage() {
        PageFactory.initElements(driver, this);
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    // Method to move the slider, validate the label and the corresponding date
    public void moveSliderAndValidate(String expectedLabel, String expectedDate) {
        Actions actions = new Actions(driver);

        // Loop through each slider position to check the label
        for (int i = 0; i <= 5; i++) {
            wait.waitForElementToBeClickable(sliderPointer);
            sliderPointer.click();
            actions.sendKeys(Keys.ARROW_RIGHT).perform();

            // Get the label text that appears after moving the slider
            try {
                // Perform some action
                wait.waitForElementToBeVisible(sliderText);
            } catch (StaleElementReferenceException e) {
                wait.waitForElementToBeVisible(sliderText);
            }

            String actualLabel = sliderText.getText();
            if (actualLabel.contains(expectedLabel)) {
                System.out.println("Slider moved to: " + actualLabel);

                // Validate the date
                wait.waitForElementToBeVisible(dateDisplayedOnCalendar);
                String actualDateDisplayedOnCalendarValue = dateDisplayedOnCalendar.getText().trim();

                Assert.assertEquals("Date not matched", expectedDate, actualDateDisplayedOnCalendarValue);
                break;
            }
        }
    }

    public void clickCalendarButtonSVP() {
        calendarButtonSVP.click();
    }

    public WebElement getSliderText() {
        return sliderText;
    }

}
