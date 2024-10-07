package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.EducationVideoPage;
import utils.Helper;
import utils.ScenarioContext;

public class EducationVideoStepDefinition extends ScenarioContext {

    private EducationVideoPage educationVideoPage = new EducationVideoPage();
    private Helper helper = new Helper();

    @And("I click Lesson 1.1 video")
    public void i_click_lesson_1_1_video() {
        String screenSize = ScenarioContext.getScreenSize();
        educationVideoPage.clickEducationVideoByTitle(screenSize);
    }

    @Then("Educational video should play for a minimum of 5 seconds")
    public void education_video_should_play_for_a_minimum_of_5seconds() throws InterruptedException {
        String screenSize = ScenarioContext.getScreenSize();
        educationVideoPage.playVideoAndValidateIfItPlaysFor5Seconds(screenSize);
    }
}
