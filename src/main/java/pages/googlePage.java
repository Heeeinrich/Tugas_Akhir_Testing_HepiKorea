package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class googlePage {
    By googleAccount = new By.ByXPath("//*[@id=\"yDmH0d\"]/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div[1]/form/span/section/div/div/div/div/ul/li[1]/div");
    By chooseAccTxt = new By.ByXPath("//*[@id=\"headingText\"]/span");

    private WebDriver driver;

    public googlePage (WebDriver driver) {
        this.driver = driver;
    }

    public void getChooseTxt() {
        driver.findElement(chooseAccTxt);
    }

    public void clickGoogleAccount() {
        driver.findElement(googleAccount).click();
    }

}
