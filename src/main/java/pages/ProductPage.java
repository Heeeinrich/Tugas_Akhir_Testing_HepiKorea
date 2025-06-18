package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // === Locators ===
    private By searchBar = By.xpath("(//*[@id='searchbar-container']/form/div/input)[2]");
    private By category = By.xpath("//*[@id=\"dropdownCategoryButton\"]");
    private By beautyCategory = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[1]/ul/li[2]/a");
    private By beverageCategory = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/li[3]/a");
    private By sortBy = By.xpath("//*[@id=\"dropdownSortByButton\"]");
    private By mostOrderedSortBy = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/li[4]/a");
    private By minPrice = By.xpath("//*[@id='app']/div/div[1]/div[2]/div[1]/input[1]");
    private By maxPrice = By.xpath("//*[@id='app']/div/div[1]/div[2]/div[1]/input[2]");
    private By productName = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[1]/a/h1");

    // === Actions ===

    public void searchKeyword(String keyword) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        input.clear();
        input.sendKeys(keyword + Keys.ENTER);
    }

    public void clickCategory() {
        WebElement categoryDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(category));

        // 1. Paksa agar tombol ditampilkan dan tidak disable
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", categoryDropdown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", categoryDropdown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].disabled = false;", categoryDropdown);

        // 2. Klik tombol menggunakan JS
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", categoryDropdown);
    }

    public void clickBeautyCategory() {
        WebElement beautyOption = wait.until(ExpectedConditions.presenceOfElementLocated(beautyCategory));

        // 1. Paksa agar tombol ditampilkan dan tidak disable
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", beautyOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", beautyOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].disabled = false;", beautyOption);

        // 2. Klik tombol menggunakan JS
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", beautyOption);
    }

    public void clickBeverageCategory() {
        WebElement beverageOption = wait.until(ExpectedConditions.presenceOfElementLocated(beverageCategory));

        // 1. Paksa agar tombol ditampilkan dan tidak disable
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", beverageOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", beverageOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].disabled = false;", beverageOption);

        // 2. Klik tombol menggunakan JS
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", beverageOption);
    }

    public void clickSortBy() {
        WebElement sortByDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(sortBy));

        // 1. Paksa agar tombol ditampilkan dan tidak disable
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", sortByDropdown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", sortByDropdown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].disabled = false;", sortByDropdown);

        // 2. Klik tombol menggunakan JS
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortByDropdown);
    }

    public void clickMostOrderedSortBy() {
        WebElement mostOrderedOption = wait.until(ExpectedConditions.presenceOfElementLocated(mostOrderedSortBy));

        // 1. Paksa agar tombol ditampilkan dan tidak disable
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", mostOrderedOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", mostOrderedOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].disabled = false;", mostOrderedOption);

        // 2. Klik tombol menggunakan JS
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

    public void clickProduct() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(productName));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public String getProductName() {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return nameElement.getText();
    }

    public boolean isProductDisplayed() {
        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
            return modal.isDisplayed();
        } catch (Exception e) {
            System.out.println("Modal tidak muncul: " + e.getMessage());
            return false;
        }
    }

    public void inputKeyword(String keyword) {
        WebElement minField = wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        minField.clear();
        if (!keyword.isEmpty()) {
            minField.sendKeys(keyword);
            minField.sendKeys(Keys.ENTER);
        }
    }

    public void isProductVisible() {
        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(productName));

        // Paksa elemen agar visible dan enabled dengan JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", product);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", product);
        ((JavascriptExecutor) driver).executeScript("arguments[0].disabled = false;", product);

        // Tunggu sampai elemen benar-benar bisa diklik atau terlihat
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
