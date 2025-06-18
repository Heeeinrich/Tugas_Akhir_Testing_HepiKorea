package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By navbar = By.xpath("//*[@id=\"app\"]/div/nav/div"); // Navbar
    private final By loginButton = By.xpath("//*[@id='login-container']"); // Tombol Login
    private final By productTab = By.xpath("//nav//a[normalize-space()='Product']");
    private final By searchBar = By.xpath("//*[@id=\"searchbar-container\"]/form/div/input");
    private final By searchButton = By.id("btn-search");
    private final By cartTab = By.xpath("//*[@id=\"notif-cart-container\"]/a");
    private final By historyTab = By.xpath("//a[normalize-space()='History']");
    private final By ouijaProduct = By.xpath("//*[@id=\"newArrivalContainer\"]/div/div[1]/div[2]/a/button");

    By userImg = By.xpath("//*[@id='user-profile-container']/div/button/img");
    By historyBtn = By.xpath("//a[@class='flex flex-row items-center px-4 py-2 text-lg font-semibold text-[#B7B7B7] hover:bg-gray-100 group']//img[contains(@src,'/img/assets/icon/icon_history.svg')]");

    // Profile navigation
    private final By profilePicTab = By.xpath("//*[@id=\"user-profile-container\"]/div/button");
    private final By logoutButton = By.xpath("//*[@id=\"user-profile-container\"]/div/div/ul/li[2]/a");

    // Logout modal
    private final By confirmLogoutButton = By.xpath("//button[normalize-space()='Yes, Logout']");
    private final By cancelLogoutButton = By.xpath("//button[normalize-space()='Cancel']");

    // Search results
    private final By productCard = By.cssSelector(".product-card");
    private final By notFoundMessage = By.xpath("//*[contains(text(),'not found') or contains(text(),'tidak ditemukan')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Navigation
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void clickProductTab() {
        WebElement producttab = wait.until(ExpectedConditions.presenceOfElementLocated(productTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", producttab);
    }

    public void clickCartTab() {
        WebElement elementCart = wait.until(ExpectedConditions.presenceOfElementLocated(cartTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementCart);
    }

    public void clickOuijaProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(ouijaProduct)).click();
    }

    public void clickHistoryTab() {
        wait.until(ExpectedConditions.elementToBeClickable(historyTab)).click();
    }

    // Search
    public void enterSearchKeyword(String keyword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).clear();
        driver.findElement(searchBar).sendKeys(keyword);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isSearchResultDisplayed() {
        return !driver.findElements(productCard).isEmpty();
    }

    public boolean isEmptySearchResultDisplayed() {
        return !driver.findElements(notFoundMessage).isEmpty();
    }

    // Profile & Logout
    // Profile & Logout
    public void clickProfileTab() {
        WebElement profleTab = wait.until(ExpectedConditions.presenceOfElementLocated(profilePicTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", profleTab);
    }

    public void clickLogoutBtn() {
        WebElement elementLogout = wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementLogout);
    }



    public void confirmLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutButton)).click();
    }

    public void cancelLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelLogoutButton)).click();
    }

    public void clickUserImg() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(userImg));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickHistoryBtn() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(historyBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Verification
    public boolean isNavbarVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(navbar)).isDisplayed();
    }

    public boolean isLoginButtonVisible() {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.display='block'; arguments[0].style.visibility='visible';", element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isProfilePictureVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profilePicTab)).isDisplayed();
    }
}