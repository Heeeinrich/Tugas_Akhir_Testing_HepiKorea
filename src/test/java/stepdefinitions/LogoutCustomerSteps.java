package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class LogoutCustomerSteps {
    WebDriver driver = BaseSteps.driver;
    HomePage homePage;

    @When("user memilih tab profile picture pada navigation bar melalui homepage")
    public void userClickProfileImage() {
        homePage = new HomePage(driver);
        homePage.clickProfileTab(); // pastikan method ini ada di HomePage
    }

    @And("user memilih tab logout pada dropdown profile")
    public void userClickLogoutButton() {
        homePage.clickLogoutBtn(); // pastikan method ini ada di HomePage
    }

    @Then("user akan kembali ke homepage dan menampilkan tombol login pada navigation bar")
    public void userLoggedOut() {
        homePage.isLoginButtonVisible(); // pastikan method ini ada di HomePage
    }
}
