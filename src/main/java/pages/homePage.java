package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    By loginBtn = new By.ByXPath("//*[@id=\"login-container\"]");
    By userImg = new By.ByXPath("//*[@id=\"user-profile-container\"]/div/button/img");
    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void isUserLoggedIn() {
        driver.findElement(userImg).isDisplayed();
    }

    public void isBackToHomepage() {
        driver.getTitle();
    }
}
