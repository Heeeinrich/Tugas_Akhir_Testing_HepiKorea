package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddressPage;
import pages.CartPage;
import pages.CheckoutPage;

import java.time.Duration;

import static org.junit.Assert.*;

public class CheckoutSteps {
    WebDriver driver = BaseSteps.driver;

    //    HomePage homePage;
//    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    AddressPage addressPage;

//    @Given("user telah melakukan login sebagai customer")
//    public void user_login_customer() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//
//        // Tunggu dan klik tombol Login
////        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='login-container']"))).click();
//
//        WebElement el = driver.findElement(By.id("login-container"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
//
//        // Tunggu field email, lalu isi
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")))
//                .sendKeys("testuser@example.com");
//
//        // Tunggu field password, lalu isi
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")))
//                .sendKeys("testpassword");
//
//        // Tunggu dan klik tombol Login
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Login')]"))).click();
//    }


    @When("user memilih tab Cart pada navigation bar")
    public void user_memilih_tab_cart_pada_navigation_bar() {
//        homePage.clickCartTab();
//        driver.findElement(By.xpath("//div[@id='notif-cart-container']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//img[@src='/img/assets/icon/icon_dashboard_order.svg']/parent::a")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartIcon);

        cartPage = new CartPage(driver);
    }

    @Then("user akan diarahkan ke dalam halaman keranjang")
    public void user_di_halaman_keranjang() {
        // Tambahkan validasi bila perlu, misalnya periksa URL atau elemen tertentu
        // Assertions.assertTrue(driver.getCurrentUrl().contains("/cart"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/cart"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/cart"));
    }

    @Then("user memilih produk yang ingin dibayar")
    public void user_memilih_produk_yang_ingin_dibayar() {
        cartPage.clickCheckBoxProduct();
    }

    @Then("user mengklik tombol Checkout")
    public void user_mengklik_tombol_checkout() {
        cartPage.clickSubmitToCheckout();
    }

    @Then("user diarahkan ke halaman Checkout")
    public void user_akan_diarahkan_ke_checkout() {
        checkoutPage = new CheckoutPage(driver);
//        Assertions.assertTrue(driver.getCurrentUrl().contains("checkout"));
    }

    @Then("user memilih alamat pengiriman")
    public void user_memilih_alamat_pengiriman() {
        checkoutPage.clickButtonToAddressPage();
        addressPage = new AddressPage(driver);

        addressPage.clickAddAddress();
        addressPage.fillFullname("Gustavo Shockbreaker");
        addressPage.fillPhoneNumber("14045");
        addressPage.fillProvince("Jawa Timur");
        addressPage.fillCity("Night City");
        addressPage.fillAddress("Jl. jalanan keren, rt 9, rw 11, Jawa, jawa");
        addressPage.fillPostalCode("119");
        addressPage.clickButtonSaveAddress();

        addressPage.clickSecondRadioButton();
        addressPage.clickBackButton();
    }

    @Then("user memilih jumlah produk di halaman Checkout")
    public void user_memilih_jumlah_produk_di_halaman_checkout() {
        checkoutPage.clickPlusQuantity(); // Bisa diganti dengan beberapa kali klik jika perlu
    }

    @Then("user mengklik tombol Checkout untuk melanjutkan")
    public void user_mengklik_tombol_checkout_untuk_melanjutkan() {
        checkoutPage.clickSubmitCheckoutButton(); // tombol checkout untuk buka modal metode pembayaran
    }

    @Then("user memilih metode pembayaran")
    public void user_memilih_metode_pembayaran() {
        checkoutPage.clickRadioButtonMethodPay();
    }

    @Then("user mengklik tombol Pay")
    public void user_mengklik_tombol_pay() {
        checkoutPage.clickSubmitButtonMethodPay();
    }

    @Then("user diarahkan ke halaman Pembayaran")
    public void user_diarahkan_ke_halaman_pembayaran() {
        // Bisa validasi keberadaan elemen atau URL
        Assertions.assertTrue(checkoutPage.getPaymentModalTitleIsDisplayed());
    }

    @Then("user akan mendapatkan error message checkout")
    public void user_akan_mendapatkan_error_message_checkout(){
        Assertions.assertTrue(cartPage.isErrorMessageDisplayed());
    }


}
