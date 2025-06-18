package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RatingPage {
    WebDriver driver;
    public RatingPage(WebDriver driver) { this.driver = driver; }

    By finishTab = By.id("tab-finish");
    By finishButton = By.id("btn-finish");
    By ratingStars = By.name("rating");
    By reviewTextArea = By.name("review");
    By submitButton = By.id("btn-submit-review");

    // em
    // locator
    By finishedTab = By.xpath("//button[contains(text(),'Finished')]");
    By buttonReview = By.xpath("//button[contains(text(),'Review')]"); // ini muncul di salah satu list product finisheedd
    By rating4Star = By.xpath("(//img[@src='/img/assets/icon/icon_review_star.svg'])[4]");
    By inputReviewText = By.xpath("//textarea[@placeholder='Add Comment...']");
    By buttonSaveReview = By.xpath("//button[contains(text(), 'Save')]"); // ini save yang ada di modal
    By errorMessageReview = By.id("reviewErrorMessage");

    public void clickFinishTab() { driver.findElement(finishTab).click(); }
    public void clickFinishButton() { driver.findElement(finishButton).click(); }
    public void giveRating() { driver.findElement(ratingStars).click(); }
    public void writeReview(String review) { driver.findElement(reviewTextArea).sendKeys(review); }
    public void clickSubmit() { driver.findElement(submitButton).click(); }


    //em
    // action
    public void clickFinishedTab(){
//        driver.findElement(finishedTab).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishTab = wait.until(ExpectedConditions.elementToBeClickable(finishedTab));
        finishTab.click();
    }

    public void clickButtonReview(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnReview = wait.until(ExpectedConditions.presenceOfElementLocated(
                buttonReview)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnReview);
    }

    public void give4StarRating(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement star = wait.until(ExpectedConditions.presenceOfElementLocated(
                rating4Star)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", star);
    }

    public void fillReviewInput(String query){
        driver.findElement(inputReviewText).sendKeys(query);
    }

    public void clickButtonSaveReview(){
        driver.findElement(buttonSaveReview).click();
    }

    public Boolean isErrorMessageDisplayed(){
//        return driver.findElement(errorMessageReview).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageReview));
        return errorElement.isDisplayed();
    }
}