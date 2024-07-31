import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookingHouse {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://suninjuly.github.io/explicit_wait2.html");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }

    public double funcCalculation(double x) {
        return log(abs(12 * sin(x)));
    }

    @Test
    public void bookingHouseOptimalPrice() throws InterruptedException {

        WebElement price= driver.findElement(By.id("price"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElement(price,"$100"));
        WebElement bookButton = driver.findElement(By.id("book"));
        bookButton.click();

        WebElement x = driver.findElement(By.id("input_value"));
        double xValue = parseDouble(x.getText());
        double result = funcCalculation(xValue);
        WebElement resultInput = driver.findElement(By.id("answer"));
        resultInput.sendKeys(String.valueOf(result));
        WebElement submitCalcResult = driver.findElement(By.id("solve"));
        submitCalcResult.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }


}




