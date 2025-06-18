package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // === Locators ===
    By searchBar = By.xpath("(//*[@id='searchbar-container']/form/div/input)[2]");
    By category = By.xpath("//*[@id=\"dropdownCategoryButton\"]");
    By beautyCategory = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[1]/ul/li[2]/a");
    By beverageCategory = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/li[3]/a");
    By sortBy = By.xpath("//*[@id=\"dropdownSortByButton\"]");
    By mostOrderedSortBy = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/li[4]/a");
    By minPrice = By.xpath("//*[@id='app']/div/div[1]/div[2]/div[1]/input[1]");
    By maxPrice = By.xpath("//*[@id='app']/div/div[1]/div[2]/div[1]/input[2]");
    By productName = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[1]/a/h1");
    By OuijaProduct = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[4]/a");

    // === Actions ===

    public void clickCategory() {
        WebElement categoryDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(category));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", categoryDropdown);
    }

    public void clickBeautyCategory() {
        WebElement beautyOption = wait.until(ExpectedConditions.presenceOfElementLocated(beautyCategory));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", beautyOption);
    }

    public void clickBeverageCategory() {
        WebElement beverageOption = wait.until(ExpectedConditions.presenceOfElementLocated(beverageCategory));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", beverageOption);
    }

    public void clickSortBy() {
        WebElement sortByDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(sortBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortByDropdown);
    }

    public void clickMostOrderedSortBy() {
        WebElement mostOrderedOption = wait.until(ExpectedConditions.presenceOfElementLocated(mostOrderedSortBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mostOrderedOption);
    }

    public void inputMinPrice(String min) {
        WebElement minField = wait.until(ExpectedConditions.elementToBeClickable(minPrice));
        minField.clear();
        if (!min.isEmpty()) {
            minField.sendKeys(min);
        }
    }

    public void inputMaxPrice(String max) {
        WebElement maxField = wait.until(ExpectedConditions.elementToBeClickable(maxPrice));
        maxField.clear();
        if (!max.isEmpty()) {
            maxField.sendKeys(max);
        }
    }
//
//    public void clickProduct() {
//        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(productName));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
//    }
//
//    public String getProductName() {
//        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
//        return nameElement.getText();
//    }
//
//    public boolean isProductDisplayed() {
//        try {
//            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
//            return modal.isDisplayed();
//        } catch (Exception e) {
//            System.out.println("Modal tidak muncul: " + e.getMessage());
//            return false;
//        }
//    }

    public void inputKeyword(String keyword) {
        WebElement minField = wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        minField.clear();
        if (!keyword.isEmpty()) {
            minField.sendKeys(keyword);
            minField.sendKeys(Keys.ENTER);
        }
    }

    public void clickOuijaProduct() {
        WebElement ouija =  wait.until(ExpectedConditions.presenceOfElementLocated(OuijaProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ouija);
    }

    public void isProductVisible() {
        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(productName));
        wait.until(ExpectedConditions.visibilityOf(product));

        // Validasi dengan assert
        if (!product.isDisplayed()) {
            throw new AssertionError("Product element is not visible.");
        }
    }

    public void isProductNotVisible() {
        // Cari elemen dengan teks yang mengandung "telor" (case-insensitive jika perlu)
        List<WebElement> products = driver.findElements(By.xpath("//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), " +
                "'telor') or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'rolex')]\n"));

        if (products.isEmpty()) {
            System.out.println("Produk tidak dapat ditemukan.");
        }
    }


}
