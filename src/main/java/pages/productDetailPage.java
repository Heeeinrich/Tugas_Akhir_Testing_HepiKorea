package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class productDetailPage {
    By productName = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/h1[1]");
    By quantity = new By.ByXPath("//*[@id=\"product-quantity-view\"]");
    By reduceQuantity = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]");
    By addQuantity = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/div[3]/div[2]/div[2]");
    By buyNowBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/div[4]/form[1]/button");
    By addToCartBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/div[4]/form[2]/button");
    By review = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/h1");

    private WebDriver driver;

    public productDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getProductName() {
        driver.findElement(productName);
    }

    public void increaseQuantity(int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(addQuantity).click();
        }
    }

    public void reduceeQuantity(int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(reduceQuantity).click();
        }
    }

    public int getQuantityValue() {
        String qtyText = driver.findElement(quantity).getText();
        return Integer.parseInt(qtyText.trim());
    }

    public void clickBuyBtn() {
        driver.findElement(buyNowBtn).click();
    }

    public void clickAddtoCartBtn() {
        driver.findElement(addToCartBtn).click();
    }

    public void getReview() {
        driver.findElement(review);
    }

}
