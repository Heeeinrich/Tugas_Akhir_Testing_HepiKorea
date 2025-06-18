package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductPage;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductDetailSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;

    @And("user memilih produk bernama Ouija")
    public void clickProductOuija() {
        productPage = new ProductPage(driver);
        productPage.clickOuijaProduct();
    }

    @Then("user akan diarahkan ke halaman product detail")
    public void isUserInProductDetailPage() {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.getProductImg();
    }

    @And("user memilih jumlah produk")
    public void userChooseQuantity() {
        productDetailPage.increaseQuantity(2);
    }

    @And("user mengklik tombol Add to Cart")
    public void userClickAddToCartBtn() {
        productDetailPage.clickAddtoCartBtn();
    }

    @Then("user mendapatkan pesan sukses menambahkan")
    public void user_mendapatkan_pesan_sukses_menambahkan() {
        productDetailPage.isSuccessDisplayed();
    }

    @Then("user tidak mendapatkan pesan sukses menambahkan")
    public void user_tidak_mendapatkan_pesan_sukses_menambahkan() {
        productDetailPage.isSuccessDisplayed();
    }
}
