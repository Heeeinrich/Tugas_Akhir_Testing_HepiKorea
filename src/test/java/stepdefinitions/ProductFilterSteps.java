package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductPage;

public class ProductFilterSteps {

    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;

    @When("user memilih tab Product pada navigation bar melalui homepage")
    public void userClickProductTab() {
        homePage = new HomePage(driver);
        homePage.clickProductTab();
        productPage = new ProductPage(driver);
    }

    @And("user memilih kategori Beauty")
    public void user_memilih_kategori_beauty()  {
        productPage.clickCategory();
        productPage.clickBeautyCategory();
    }

    @And("user memasukan minimum price 100000")
    public void userInputMinPrice() {
        productPage.inputMinPrice("100000");
    }

    @And("user memasukan maximum price 300000")
    public void userInputMaxPrice () {
        productPage.inputMaxPrice("300000");
    }


    @And("user memilih sort by Most Ordered")
    public void userChooseOrderBy() {
        productPage.clickSortBy();
        productPage.clickMostOrderedSortBy();
    }

    @Then("sistem akan menampilkan produk berdasarkan filter")
    public void systemDisplayTheResult() {
        productPage.isProductVisible();
    }

    @And("user memilih kategori Beverage")
    public void userChooseBeverageCategory() {
        productPage.clickCategory();
        productPage.clickBeverageCategory();
    }

    @Then("sistem tidak akan menampilkan produk karena tidak ada")
    public void systemDisplayTheResultBeverage() {
        productPage.isProductNotVisible();
    }
}
