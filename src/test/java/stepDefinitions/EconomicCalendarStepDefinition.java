package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.Helper;
import pages.EconomicCalendarPage;
import utils.ScenarioContext;
import utils.WaitHelper;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class EconomicCalendarStepDefinition extends ScenarioContext {

    private EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage();
    private Helper helper = new Helper();

    @Then("I navigate to Economic Calendar page")
    public void i_navigate_to_economic_calendar_page() {
        String expectedTitleOfEconomicCalendarPage = "Economic Calendar";
        Assert.assertEquals("Not landed to Economic Calendar page", expectedTitleOfEconomicCalendarPage, helper.getPageTitle());
    }

    @And("I should get correct date as I select today, tomorrow and next week on slider")
    public void i_should_get_correct_date_as_i_select_today_tomorrow_and_next_week_on_slider() {
        String screenSize = ScenarioContext.getScreenSize();
        // Date format for validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");
        // Get today's date
        LocalDate today = LocalDate.now();

        if (screenSize == null) {
            throw new IllegalStateException("Screen size has not been set in the ScenarioContext.");
        }

        economicCalendarPage.switchToIframe();
        if (screenSize.equals("800 x 600")) {
            WaitHelper wait = new WaitHelper();
            economicCalendarPage.clickCalendarButtonSVP();
            helper.scrollToWebElement(economicCalendarPage.getSliderText());
            wait.waitForElementToBeVisible(economicCalendarPage.getSliderText());
        }

        // Validate "Today"
        economicCalendarPage.moveSliderAndValidate("Today", today.format(formatter));

        // Validate "Tomorrow"
        economicCalendarPage.moveSliderAndValidate("Tomorrow", today.plusDays(1).format(formatter));

        // Validate "Next Week"
        economicCalendarPage.moveSliderAndValidate("Next Week", today.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).format(formatter));
    }
}
