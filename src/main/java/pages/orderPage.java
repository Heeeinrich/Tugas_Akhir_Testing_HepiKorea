package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderPage {
    By orderSection = new By.ByXPath("//*[@id=\"app\"]/div/div/ul/li[1]/button");

    private WebDriver driver;

    public orderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderSection() {
        driver.findElement(orderSection).click();
    }
}
