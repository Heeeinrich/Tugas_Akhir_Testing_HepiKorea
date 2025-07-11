package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By addressDropdown = By.id("address");
    By productQty = By.name("qty");
    By checkoutButton = By.id("btn-checkout-final");
    By paymentMethod = By.name("paymentMethod");
    By payButton = By.id("btn-pay");

    // Actions
    public void selectAddress() {
        driver.findElement(addressDropdown).click();
    }

    public void enterQuantity(String qty) {
        WebElement qtyField = driver.findElement(productQty);
        qtyField.clear();
        qtyField.sendKeys(qty);
    }

    public void clickFinalCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void selectPaymentMethod() {
        driver.findElement(paymentMethod).click();
    }

    public void clickPay() {
        driver.findElement(payButton).click();
    }

    // Validation
    public boolean isAtCheckoutPage() {
        return driver.getCurrentUrl().contains("/checkout");
    }
}