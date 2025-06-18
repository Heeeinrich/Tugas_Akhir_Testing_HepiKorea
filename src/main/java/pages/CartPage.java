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

    // em
    // locator
//    By checkboxProduct = By.xpath("//input[@type='checkbox']");
    By checkboxProduct = By.xpath("//input[@class='w-6 h-6 rounded-sm outline outline-[#3E6E7A] bg-transparent hover:bg-slate-100 checked:bg-[#3E6E7A] hover:checked:bg-[#37626d] focus:outline-[#3E6E7A] active:ring-[#3E6E7A] focus:border-[#3E6E7A]']");
    By buttonSubmmitCheckout = By.xpath("//button[@type='submit']");
    By cartTitlePage = By.xpath("//h1[contains(text,'Cart')]");
    By errorMessage = By.id("errorMessageCheckoutZeroProductSelected");

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

    // em
    // action
    public By getCartTitlePage(){
        return cartTitlePage;
    }

    public void clickCheckBoxProduct(){
//        driver.findElement(checkboxProduct).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement checkBox = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//input[@type='checkbox']")
//        ));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBox);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Tunggu sampai element muncul
        WebElement checkbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(checkboxProduct)
        );

        // Tambah delay manual meskipun element sudah ada
        try {
            Thread.sleep(5000); // tunggu 3 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Klik dengan JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox   );
    }

    public boolean isErrorMessageDisplayed(){
        // return driver.findElement(errorMessage).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );
        return errorElement.isDisplayed();
    }

    public void clickSubmitToCheckout(){
//        driver.findElement(buttonSubmmitCheckout).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement btnSubmit = wait.until(ExpectedConditions.presenceOfElementLocated(buttonSubmmitCheckout));
//        btnSubmit.click();
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(buttonSubmmitCheckout));
        submitButton.click();
    }
}
