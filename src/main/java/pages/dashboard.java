package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboard {
    By dashboardTxt = new By.ByXPath("//*[@id=\"app\"]/div/div/h1");
    By orderTab = new By.ByXPath("//*[@id=\"default-sidebar\"]/div/ul[1]/li[3]/a");
    By logout = new By.ByXPath("//*[@id=\"default-sidebar\"]/div/ul[2]/li/a");


    private WebDriver driver;

    public dashboard(WebDriver driver) {
        this.driver = driver;
    }

    public void isUserLoggedIn() {
        driver.findElement(dashboardTxt).isDisplayed();
    }

    public void clickOrderTab() {
        driver.findElement(orderTab).click();
    }

    public void clickLogoutBtn() {
        driver.findElement(logout).click();
    }
}

