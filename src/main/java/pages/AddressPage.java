package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage {
    WebDriver driver;

    public AddressPage(WebDriver driver){
        this.driver = driver;
    }

    // locator
    By radioButtonAddress2 = By.xpath("(//input[@type='radio'])[2]");
    By backButton = By.xpath("(//button//p[contains(text(), 'Back')])");
    By addButtonAddress = By.xpath("//img[contains(@src,'/img/assets/icon/icon_faq_plus.svg')]");
    By inputFullName = By.xpath("//input[@placeholder='Full Name']");
    By inputPhoneNumber = By.xpath("//input[@placeholder='Phone Number']");
    By inputProvince = By.xpath("//input[@placeholder='Province']");
    By inputCity = By.xpath("//input[@placeholder='City']");
    By inputAddress = By.xpath("//textarea[@placeholder='Your Address']");
    By inputPostalCode = By.xpath("//input[@placeholder='Postal Code']");
    By buttonSaveAddress = By.xpath("//button[@class='bg-[#3E6E7A] hover:bg-[#37626d] active:bg-[#325862] text-white text-xs lg:text-base font-semibold mx-auto mt-1 md:mt-3 lg:mt-3 mb-3 w-1/4 h-7 lg:h-10 rounded-lg lg:rounded-xl']");


    // action
    public void clickSecondRadioButton(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1500));
//        WebElement radio = wait.until(ExpectedConditions.presenceOfElementLocated(radioButtonAddress2));
//        radio.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Tunggu sampai element muncul
        WebElement radio = wait.until(
                ExpectedConditions.presenceOfElementLocated(radioButtonAddress2)
        );

        // Tambah delay manual meskipun element sudah ada
        try {
            Thread.sleep(5000); // tunggu 3 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Klik dengan JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
    }

    public void clickAddAddress(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnAdd = wait.until(ExpectedConditions.presenceOfElementLocated(addButtonAddress));
        btnAdd.click();
    }


    public void fillFullname(String query){
        driver.findElement(inputFullName).sendKeys(query);
    }
    public void fillPhoneNumber(String query){
        driver.findElement(inputPhoneNumber).sendKeys(query);
    }
    public void fillProvince(String query){
        driver.findElement(inputProvince).sendKeys(query);
    }
    public void fillCity(String query){
        driver.findElement(inputCity).sendKeys(query);
    }
    public void fillAddress(String query){
        driver.findElement(inputAddress).sendKeys(query);
    }
    public void fillPostalCode(String query){
        driver.findElement(inputPostalCode).sendKeys(query);
    }
    public void clickButtonSaveAddress(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btnSave = wait.until(ExpectedConditions.presenceOfElementLocated(
                buttonSaveAddress)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSave);
    }



    public void clickBackButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement backBtn = wait.until(ExpectedConditions.elementToBeClickable(backButton));
        backBtn.click();
    }
}

