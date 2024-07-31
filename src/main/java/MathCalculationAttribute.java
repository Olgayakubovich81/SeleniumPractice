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

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathCalculationAttribute {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://suninjuly.github.io/get_attribute.html");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public double funcCalculation(double x) {
        return log(abs(12 * sin(x)));
    }

    @Test
    public void validAnswerTest() {
        WebElement x = driver.findElement(By.id("treasure"));
        double xValue = parseDouble(x.getAttribute("valuex"));
        double result = funcCalculation(xValue);
        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));
//                Check checkbox
//                Choose radio button "Robots rule"
//                Click on submit button
//                 sleep ()
        WebElement checkBox= driver.findElement(By.id("robotCheckbox"));
        checkBox.click();
        WebElement radioButton= driver.findElement(By.id("robotsRule"));
        radioButton.click();
        WebElement submitButton= driver.findElement(By.tagName( "button"));
        submitButton.click();

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //    Congrats, you've passed the task!
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }

}
