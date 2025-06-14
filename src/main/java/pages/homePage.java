package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    By loginBtn = new By.ByXPath("//*[@id=\"login-container\"]");
    By userImg = new By.ByXPath("//*[@id=\"user-profile-container\"]/div/button/img");
    By productHomepage = new By.ByXPath("//*[@id=\"newArrivalContainer\"]/div/div[1]/div[2]/a/button");
    By productTab = new By.ByXPath("//*[@id=\"navlink-container\"]/a[1]");
    By cart = new By.ByXPath("//*[@id=\"notif-cart-container\"]/a");

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

    public void clickProduct() {
        driver.findElement(productHomepage).click();
    }

    public void clickUserImg() {
        driver.findElement(userImg).click();
    }

    public void clickProductTab() {
        driver.findElement(productTab).click();
    }

    public void clickCartTab() {
        driver.findElement(cart).click();
    }

    public void isBackToHomepage() {
        driver.getTitle();
    }
}
