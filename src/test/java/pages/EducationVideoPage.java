package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EducationVideoPage extends BasePage{

    @FindBy(xpath = "//*[@id = 'js-videoPlaylist']//*[@data-target = '#js-collapse-trd-s1']")
    private WebElement introToMarketsButton;

    @FindBy(xpath = "//*[@id = 'js-videoPlaylist']//*[@data-target = '#js-collapse-trd-s0']")
    private WebElement collapseButtonAboutTheVideoSeries;

    @FindBy(xpath = "//*[@id = 'js-collapse-trd-s1']//a[@data-video = 'trd-s1|d49ddcb31d1be2c35c']")
    private WebElement lesson_1_1_video;

    @FindBy(xpath = "//*[@id = 'js-videoPlaylist']")
    private WebElement videoPlaylist;

    @FindBy(xpath = "//div[@class = 'player-big-play-button']")
    private WebElement playButton;

    @FindBy(xpath = "//*[@role = 'main' and contains(@class, 'playing')]")
    private WebElement videoPlaying;

    @FindBy(xpath = "//*[@class = 'xm-videos__player']")
    private WebElement videoPlayer;

    private String videoIframeCssLocator = "iframe.sproutvideo-player";

    public EducationVideoPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickCollapseButtonIntroToMarkets(String screenSize) {
        //Scroll to About video series section on video playlist when screen size is not max
        if(!screenSize.equals("max")){
            helper.scrollToWebElement(collapseButtonAboutTheVideoSeries);
        }
        wait.waitForElementToBeVisible(videoPlaylist);
        wait.waitForElementToBeClickable(introToMarketsButton);
        introToMarketsButton.click();
    }

    public void clickEducationVideoByTitle(String screenSize) {
        clickCollapseButtonIntroToMarkets(screenSize);
        //Some time above click function is not expanding the Intro to market
        if(! lesson_1_1_video.isDisplayed()) {
            wait.waitForElementToBeClickable(introToMarketsButton);
            introToMarketsButton.click();
        }
        wait.waitForElementToBeClickable(lesson_1_1_video);
        lesson_1_1_video.click();
        wait.waitForElementToBeClickable(videoPlayer);
    }

    public void playVideoAndValidateIfItPlaysFor5Seconds(String screenSize) throws InterruptedException {
        wait.waitFrameToBeAvailableAndSwitchToIt(By.cssSelector(videoIframeCssLocator));
        if(screenSize.equals("800 x 600")){
            helper.scrollToWebElement(playButton);
        }
        wait.waitForElementToBeClickable(playButton);
        playButton.click();
        wait.waitForElementToBeVisible(videoPlaying);
        if(videoPlaying.isDisplayed()) {
            Thread.sleep(5000);
        }
        Assert.assertTrue("Video is not playing for min 5 seconds", videoPlaying.isDisplayed());
    }
}
