package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.loginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginEmailSteps {

    static WebDriver driver;
    homePage homepage;
    loginPage loginpage;

    @BeforeAll
    public static void setUp() {
        if (driver == null) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Given("user membuka platform HepiKorea")
    public void openHepiKorea() {
        driver.get("https://hepikorea.pad19.me/");
        homepage = new homePage(driver);
        loginpage = new loginPage(driver);
    }

    @When("user mengklik tombol login di halaman homepage")
    public void clickLoginBtn() {
        homepage.clickLoginBtn();
    }

    @Then("user diarahkan ke dalam halaman login")
    public void getLoginPageTitle() {
        String title = driver.getTitle();
        assertTrue(title.toLowerCase().contains("login"));
    }

    @When("user memasukan email {string}")
    public void inputEmail(String email) {
        loginpage.inputEmail(email);
    }

    @And("user memasukan password {string}")
    public void inputPassword(String password) {
        loginpage.inputPassword(password);
    }

    @And("user mengklik tombol login di dalam halaman login")
    public void clickLoginBtnLoginPage() {
        loginpage.clickLoginBtn();
    }

    @Then("user mendapatkan respon {string}")
    public void verifyLoginResult(String expectedResult) {
        if (expectedResult.contains("dashboard admin")) {
            assertTrue(driver.getCurrentUrl().contains("/admin/dashboard"));
        } else if (expectedResult.contains("halaman homepage")) {
            assertTrue(driver.getCurrentUrl().contains("/home"));
        } else if (expectedResult.contains("pesan error")) {
            assertTrue(driver.getPageSource().contains(expectedResult.split("\"")[1]));
        }
    }
}
