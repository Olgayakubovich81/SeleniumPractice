import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe" );
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://crossbrowsertesting.github.io/login-form.html");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

       @Test
       public void validDateTest() throws InterruptedException {

           WebElement userNameInputField = driver.findElement(By.id("username"));
           userNameInputField.sendKeys("tester@crossbrowsertesting.com");

           WebElement passwordInputField = driver.findElement(By.id("password"));
           passwordInputField.sendKeys("test123");

           WebElement loginButton = driver.findElement(By.tagName("button"));
           loginButton.click();


           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
           wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("logged-in-message"))));
           WebElement successfulLoggedIn = driver.findElement(By.id("logged-in-message"));
           assertTrue(successfulLoggedIn.getText().contains("You are now logged in!"));

                }

    @Test
    public void invalidDateTest() throws InterruptedException {

        WebElement userNameInputField = driver.findElement(By.id("username"));
        userNameInputField.sendKeys("olgale4@gmail.com");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("test321");

        WebElement loginButton= driver.findElement(By.tagName("button"));
        loginButton.click();



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-danger")));
        WebElement unsuccessfulLoggedIn = driver.findElement(By.className("alert-danger"));
        assertEquals("Username or password is incorrect", unsuccessfulLoggedIn.getText());
    }

}




