package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductPage;

public class ProductSearchSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;
    ProductPage productPage;

    @When("user memilih tab Product pada navigation bar")
    public void userMemilihTabProductPadaNavigationBar() {
        homePage = new HomePage(driver); // Inisialisasi di sini jika tidak di constructor
        homePage.clickProductTab();
        System.out.println("Step: User memilih tab Product.");
    }

    @And("user memasukan kata kunci produk {string} di halaman produk")
    public void userMemasukanKataKunciProdukDiHalamanProduk(String keyword) {
        productPage = new ProductPage(driver); // Inisialisasi di sini jika tidak di constructor
        productPage.inputKeyword(keyword);
        System.out.println("Step: User memasukkan kata kunci produk: " + keyword);
    }

    @Then("sistem menampilkan hasil pencarian produk")
    public void sistemMenampilkanHasilPencarianProduk() {
        productPage.isProductVisible();
        System.out.println("Step: Sistem menampilkan hasil pencarian produk.");
    }

    // Perbaikan: Anotasi @And dan nama parameter yang sesuai
    // Mengubah "ser" menjadi "user" dan "{String}" menjadi "{string}"
    @And("user memasukan kata kunci produk tidak valid {string} di halaman produk")
    public void userMemasukanKataKunciProdukTidakValidDiHalamanProduk(String keywordTidakValid) {
        productPage = new ProductPage(driver); // Inisialisasi di sini jika tidak di constructor
        productPage.inputKeyword(keywordTidakValid);
        System.out.println("Step: User memasukkan kata kunci produk tidak valid: " + keywordTidakValid);
    }

    // Perbaikan: Nama metode agar lebih jelas dan konsisten
    @Then("sistem tidak menampilkan hasil pencarian produk")
    public void sistemTidakMenampilkanHasilPencarianProduk() {
        productPage.isProductNotVisible();
        System.out.println("Step: Sistem tidak menampilkan hasil pencarian produk.");
    }
}


