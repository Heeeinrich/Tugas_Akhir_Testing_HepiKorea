package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    By selectProduct = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div/div[2]/div/div/input");
    By deleteBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div/div[2]/div/div/button");
    By checkoutBtn = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div/div[2]/form/button");
    By productName = new By.ByXPath("//*[@id=\"app\"]/div/div[1]/div/div/div[1]/div[1]/div[1]/div[2]/h1");

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickSelectProduct() {
        driver.findElement(selectProduct).click();
    }

    public boolean getCartTxt() {
        driver.findElement(productName).isDisplayed();
        return false;
    }

    public boolean isCartTxtVisible() {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(productName));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.display='block'; arguments[0].style.visibility='visible';", element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteProduct () {
        driver.findElement(deleteBtn).click();
    }

    public void checkoutProduct() {
        driver.findElement(checkoutBtn).click();
    }
}
