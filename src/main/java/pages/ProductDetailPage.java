package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    By productImg = By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[1]/div/div[1]/img");
    By quantity = By.xpath("//*[@id=\"product-quantity-view\"]");
    By reduceQuantity = By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]");
    By addQuantity = By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/div[3]/div[2]/div[2]");
    By buyNowBtn = By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/div[4]/form[1]/button");
    By addToCartBtn = By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[1]/div[3]/div[4]/form[2]/button");
    By review = By.xpath("//*[@id=\"success-modal\"]/div/div/div/div/h1");
    By successModal = By.xpath("//*[@id=\"success-modal\"]/div/div/div/div/h1");
    By cart = By.xpath("//*[@id=\"notif-cart-container\"]/a");





    private WebDriver driver;
    private WebDriverWait wait;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isSuccessDisplayed() {
        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(successModal));
            return modal.isDisplayed();
        } catch (Exception e) {
            System.out.println("Modal tidak muncul: " + e.getMessage());
            return false;
        }
    }


    public String getProductImg() {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productImg));
        return nameElement.getText();
    }

    public void increaseQuantity(int times) {
        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(addQuantity));
        for (int i = 0; i < times; i++) {
            plusButton.click();
        }
    }

    public void reduceeQuantity(int times) {
        WebElement minusButton = wait.until(ExpectedConditions.elementToBeClickable(reduceQuantity));
        for (int i = 0; i < times; i++) {
            minusButton.click();
        }
    }

    public int getQuantityValue() {
        WebElement qtyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(quantity));
        String qtyText = qtyElement.getText();
        return Integer.parseInt(qtyText.trim());
    }

    public void clickBuyBtn() {
        WebElement buyBtn = wait.until(ExpectedConditions.elementToBeClickable(buyNowBtn));
        buyBtn.click();
    }

    public void clickAddtoCartBtn() {
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        cartBtn.click();
    }

}
