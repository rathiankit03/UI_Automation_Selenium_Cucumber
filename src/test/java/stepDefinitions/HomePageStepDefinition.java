package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasePage;
import utils.Helper;
import pages.HomePage;
import utils.ScenarioContext;

public class HomePageStepDefinition extends ScenarioContext {

    private HomePage homePage = new HomePage();
    private Helper helper = new Helper();

    @Given("I am on home page with screen size {string}")
    public void i_am_on_home_page_with_screen_size(String screenSize) {
        homePage.openHomePage();
        ScenarioContext.setScreenSize(screenSize);
        new BasePage().setTheScreenSize(screenSize);
        homePage.acceptCookieIfItIsDisplayed();
        String expectedTitleOfHomePage = "Forex & CFD Trading on Stocks";
        Assert.assertTrue("Not landed to home page", helper.getPageTitle().contains(expectedTitleOfHomePage));
    }

    @When("I click Research and Education menu")
    public void i_click_research_and_education_menu() {
        homePage.clickResearchAndEducationMenu(ScenarioContext.getScreenSize());
    }

    @And("I click Economic Calendar link")
    public void i_click_economic_calendar_link() {
        homePage.clickEconomicCalendarLink(ScenarioContext.getScreenSize());
    }

    @And("I click Education Videos link")
    public void i_click_education_videos_link() {
        homePage.clickEducationalVideosLink(ScenarioContext.getScreenSize());
    }
}
