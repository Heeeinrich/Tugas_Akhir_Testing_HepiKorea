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
    ProductDetailPage productDetailPage;

    @When("user memilih produk bernama Ouija")
    public void clickProductOuija() {
        homePage = new HomePage(driver);
        homePage.clickOuijaProduct();
        productDetailPage = new ProductDetailPage(driver);
    }

    @Then("user akan diarahkan ke halaman product detail")
    public void isUserInProductDetailPage() {
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
