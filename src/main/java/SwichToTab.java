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
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwichToTab {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://suninjuly.github.io/redirect_accept.html");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public double funcCalculation(double x) {
        return log(abs(12 * sin(x)));
    }
    @Test
    public void swichToTabTest() throws InterruptedException {

        WebElement redirectButton = driver.findElement(By.tagName("button"));
        redirectButton.click();
        sleep(2000);
//
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement x = driver.findElement(By.id("input_value"));
        System.out.println(x.getText());
        double xValue = parseDouble(x.getText());
        double result = funcCalculation(xValue);
            WebElement answerInputField = driver.findElement(By.id("answer"));
            answerInputField.sendKeys(String.valueOf(result));

           WebElement submitButton= driver.findElement(By.tagName( "button"));
            submitButton.click();

            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
        }

    }


