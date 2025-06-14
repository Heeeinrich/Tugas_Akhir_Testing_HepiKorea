package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutPage {
    By shippingAddress = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div");
    By addressBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div/div[3]/a");
    By quantity = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div[1]/div[4]/div/p");
    By reduceQuantity = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div[1]/div[4]/div/div[1]");
    By addQuantity = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div[1]/div[4]/div/div[2]]");
    By productNote = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div[2]/textarea");
    By orderNote = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[1]/textarea");
    By checkoutBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div[3]/button");
    By paymentMethod = new By.ByXPath("//*[@id=\"bca\"]");
    By payBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div/form/button");
    By virtualRek = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div/div/div[3]/div[2]/p[2]");

    //*[@id="app"]/div/div[1]/div[2]/div/div/div/div[3]/div[2]/p[2]

    private WebDriver driver;

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getShippingAddress() {
        driver.findElement(shippingAddress);
    }

    public void chooseAddress() {
        driver.findElement(addressBtn).click();
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

    public void inputProductNote(String productNoteTxt) {
        driver.findElement(productNote).sendKeys(productNoteTxt);
    }

    public void inputOrderNote(String orderNoteTxt) {
        driver.findElement(orderNote).sendKeys(orderNoteTxt);
    }

    public void clickChecoutBtn() {
        driver.findElement(checkoutBtn).click();
    }

    public void choosePaymentMethod() {
        driver.findElement(paymentMethod).click();
    }

    public void clickPayBtn() {
        driver.findElement(payBtn).click();
    }

    public void payProduct() {
        driver.findElement(virtualRek).isDisplayed();
    }
}
