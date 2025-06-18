package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    // em
    //    By submitCheckoutButton = By.xpath("//button[contains(text,'Checkout')]");
    By submitCheckoutButton = By.xpath("//button[@class='w-fit bg-[#3E6E7A] hover:bg-[#37626d] active:bg-[#325862] text-white text-[8px] md:text-xs lg:text-2xl font-semibold rounded-xl lg:rounded-2xl py-1 md:py-1.5 lg:py-2 px-3 md:px-6 lg:px-9 md:mt-3 lg:mt-2 ml-auto']");
    By plusQuantityButton = By.xpath("//div[contains(text(), '+')]");
    By minusQuantityButton = By.xpath("//div[contains(text(), '-')]");
    //    By buttonGoToAddressPage = By.xpath("img[@src='/img/assets/icon/icon_checkout_arrow_down.svg']");
    By buttonGoToAddressPage = By.xpath("//img[contains(@src,'/img/assets/icon/icon_checkout_arrow_down.svg')]");

    // ini di modal pilih metode
    By radioButtonOptionBri = By.xpath("//input[@id='bri']");;
    By radioButtonOptionMandiri = By.xpath("//input[@id='mandiri']");;
    By radioButtonOptionQris = By.xpath("//input[@id='qris']");;
    By submitButtonModalMethodPay = By.xpath("//button[contains(text(),'Pay')]");

    // ini di modal payment
    By textPaymentHeader = By.xpath("//h1[contains(text(),'Payment')]");
    // By CrossButtonModal = By.xpath("//p[contains(text(),'X')]");

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

    // em
    public void clickButtonToAddressPage(){
//        driver.findElement(buttonGoToAddressPage).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement ButtonToAddress = wait.until(ExpectedConditions.presenceOfElementLocated(
//                buttonGoToAddressPage)
//        );
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ButtonToAddress);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Tunggu sampai element muncul
        WebElement ButtonToAddress = wait.until(
                ExpectedConditions.presenceOfElementLocated(buttonGoToAddressPage)
        );

        // Tambah delay manual meskipun element sudah ada
        try {
            Thread.sleep(5000); // tunggu 3 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Klik dengan JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ButtonToAddress);
    }

    public void clickPlusQuantity(){
//        driver.findElement(plusQuantityButton).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement plusQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(plusQuantityButton));
//        plusQuantity.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement plusQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(
                plusQuantityButton)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusQuantity);
    }

    public void clickMinusQuantity(){
        driver.findElement(minusQuantityButton).click();
    }

    public void clickSubmitCheckoutButton(){ //ini nanti muncul modal
        // driver.findElement(submitCheckoutButton).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250)", "");
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(submitCheckoutButton));
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement checkoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(
//                submitCheckoutButton)
//        );
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement checkoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(submitCheckoutButton));

        // Scroll ke elemen
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkoutButton);

        // Tambahkan sedikit delay agar scroll selesai
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tunggu sampai bisa diklik
        wait.until(ExpectedConditions.elementToBeClickable(submitCheckoutButton));

        // Klik dengan JS
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutButton);
    }

    // action in modal
    public void clickRadioButtonMethodPay(){
        driver.findElement(radioButtonOptionMandiri).click();

    }

    public void clickSubmitButtonMethodPay(){
        driver.findElement(submitButtonModalMethodPay).click();
    }

    //    public Boolean getPaymentModalTitleIsDisplayed(){
//        return driver.findElement(textPaymentHeader).isDisplayed();
//    }
    public Boolean getPaymentModalTitleIsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement paymentHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(textPaymentHeader));
            return paymentHeader.isDisplayed();
        } catch (TimeoutException e) {
            return false; // elemen tidak muncul dalam 10 detik
        }
    }

    // Validation
    public boolean isAtCheckoutPage() {
        return driver.getCurrentUrl().contains("/checkout");
    }
}