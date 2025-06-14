package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    By email = new By.ByXPath("//*[@id=\"app\"]/main/div/form/div[1]/input");
    By password = new By.ByXPath("//*[@id=\"password\"]");
    By loginBtn = new By.ByXPath("//*[@id=\"password\"]");
    By googleBtn = new By.ByXPath("//*[@id=\"password\"]");
    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String emailtxt) {
        driver.findElement(email).sendKeys(emailtxt);
    }

    public void inputPassword(String passtxt) {
        driver.findElement(password).sendKeys(passtxt);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void clickGoogleBtn() {
        driver.findElement(googleBtn).click();
    }

    public void loginTitle() {
        driver.getTitle();
    }
}
