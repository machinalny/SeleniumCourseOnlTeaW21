package pl.coderslab.seleniumcourse.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static pl.coderslab.seleniumcourse.Tools.*;

public class RegisterUserPageObjectedTest {
    private WebDriver driver;
    MainHotelTestlabPage mainPage;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.mainPage = new MainHotelTestlabPage(driver);
    }

    @Test
    public void shouldFillRegisterUserForm() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        mainPage.clickSignIn();

        WebElement emailInput = driver.findElement(By.cssSelector("#email_create"));
        assertDisplayedAndEnabled(emailInput);
        fillInput(emailInput, generateRandomEmail());
        WebElement createAnAccountButton = driver.findElement(By.cssSelector("#SubmitCreate"));
        assertDisplayedAndEnabled(createAnAccountButton);
        createAnAccountButton.click();

        WebElement customerFirstnameInput = driver.findElement(By.id("customer_firstname"));
        assertDisplayedAndEnabled(customerFirstnameInput);
        fillInput(customerFirstnameInput, "ala");
        WebElement customerLastnameInput = driver.findElement(By.id("customer_lastname"));
        assertDisplayedAndEnabled(customerLastnameInput);
        fillInput(customerLastnameInput, "makota");
        WebElement customerEmailInput = driver.findElement(By.id("email"));
        assertDisplayedAndEnabled(customerEmailInput);
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        assertDisplayedAndEnabled(passwordInput);
        fillInput(passwordInput, "supertajnehaslo");

        WebElement submitButton = driver.findElement(By.id("submitAccount"));
        assertDisplayedAndEnabled(submitButton);
        submitButton.click();
        //driver.quit();
    }
}
