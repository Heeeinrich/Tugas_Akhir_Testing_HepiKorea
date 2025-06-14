package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class productPage {
    By searchBar = new By.ByXPath("//*[@id=\"searchbar-container\"]/form/div/input");
    By category = new By.ByXPath("//*[@id=\"dropdownCategoryButton\"]");
    By minPrice = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/input[1]");
    By maxPrice = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/input[2]");
    By sortBy = new By.ByXPath("//*[@id=\"dropdownSortByButton\"]");
    By product = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[4]/a/button");

    private WebDriver driver;

    public productPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchKeyword(String keyword) {
        driver.findElement(searchBar).sendKeys(keyword + Keys.ENTER);
    }

    public void selectCategory(String cat) {
        new Select(driver.findElement(category)).selectByVisibleText(cat);
    }

    public void selectSortBy(String sort) {
        new Select(driver.findElement(sortBy)).selectByVisibleText(sort);
    }

    public void inputMinPrice(String min) {
        driver.findElement(minPrice).sendKeys(min);
    }

    public void inputMaxPrice(String max) {
        driver.findElement(maxPrice).sendKeys(max);
    }

    public void clickProduct() {
        driver.findElement(product).click();
    }
}
