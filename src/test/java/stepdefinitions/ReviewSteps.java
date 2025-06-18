package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.RatingPage;

import java.time.Duration;

import static org.junit.Assert.*;

public class ReviewSteps {

    WebDriver driver = BaseSteps.driver;

    pages.RatingPage ratingPage;
    pages.HomePage homePage;

    @When("user memilih tab Profile Picture pada navigation bar")
    public void user_memilih_tab_profile_picture_pada_navigation_bar() {
        homePage = new HomePage(driver);
        homePage.clickUserImg();
    }

    @When("user memilih tab History pada dropdown Profile")
    public void user_memilih_tab_history_pada_dropdown_profile() {
        homePage.clickHistoryBtn();
    }

    @Then("user akan diarahkan ke dalam halaman Riwayat Pemesanan")
    public void user_akan_diarahkan_ke_dalam_halaman_riwayat_pemesanan() {
//        assertTrue(historyPage.isOnHistoryPage());
        ratingPage = new RatingPage(driver);
    }

    @Then("user memilih section Finish")
    public void user_memilih_section_finish() {
//        ratingPage = new RatingPage(driver);
        ratingPage.clickFinishedTab();
    }

    @Then("user mengklik tombol Review")
    public void user_mengklik_tombol_review() {
        ratingPage.clickButtonReview();
    }

    @Then("user memilih rating produk")
    public void user_memilih_rating_produk() {
        ratingPage.give4StarRating();
    }

    @Then("user menulis review produk")
    public void user_menulis_review_produk() {
        ratingPage.fillReviewInput("cihuy");
    }

    @Then("user mengklik tombol Submit")
    public void user_mengklik_tombol_submit() {
        ratingPage.clickButtonSaveReview();
    }

    @Then("rating dan review akan ditampilkan dalam produk detail produk tersebut")
    public void rating_dan_review_akan_ditampilkan_dalam_produk_detail_produk_tersebut() {
//        assertTrue(historyPage.isReviewDisplayed());
    }

    @Then("user akan mendapatkan pesan error review")
    public void user_mendapatkan_pesan_error_review() {
        Assertions.assertTrue(ratingPage.isErrorMessageDisplayed());
    }
}
