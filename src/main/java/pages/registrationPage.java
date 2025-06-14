package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registrationPage {
    By fullname = new By.ByXPath("//*[@id=\"app\"]/main/div/form/div[1]/input");
    By email = new By.ByXPath("//*[@id=\"app\"]/main/div/form/div[2]/input");
    By password = new By.ByXPath("//*[@id=\"password\"]");
    By confirmPassword = new By.ByXPath("//*[@id=\"confirmPassword\"]t");
    By registerBtn = new By.ByXPath("//*[@id=\"app\"]/main/div/form/button");
    By loginLink = new By.ByXPath("//*[@id=\"app\"]/main/div/p/a");

    private WebDriver driver;

    public registrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFullname(String fullnametxt) {
        driver.findElement(fullname).sendKeys(fullnametxt);
    }

    public void inputEmail(String emailtxt) {
        driver.findElement(email).sendKeys(emailtxt);
    }

    public void inputPassword(String passtxt) {
        driver.findElement(password).sendKeys(passtxt);
    }

    public void inputConfirmPassword(String confirm_passtxt) {
        driver.findElement(confirmPassword).sendKeys(confirm_passtxt);
    }

    public void clickRegisterBtn() {
        driver.findElement(registerBtn).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void registerTitle() {
        driver.getTitle();
    }
}
