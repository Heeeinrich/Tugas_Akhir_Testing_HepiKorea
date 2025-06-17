package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    By selectProduct = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div/div[2]/div/div/input");
    By deleteBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div/div[2]/div/div/button");
    By checkoutBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div/div[2]/form/button");
    By cartTxt = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/h1");

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSelectProduct() {
        driver.findElement(selectProduct).click();
    }

    public void getCartTxt() {
        driver.findElement(cartTxt).isDisplayed();
    }

    public void deleteProduct () {
        driver.findElement(deleteBtn).click();
    }

    public void checkoutProduct() {
        driver.findElement(checkoutBtn).click();
    }
}
