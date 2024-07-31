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

import static java.lang.Integer.parseInt;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDown {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe" );
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://suninjuly.github.io/selects1.html");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validAnswerTest() throws InterruptedException {
        WebElement num1= driver.findElement(By.id("num1"));
        WebElement num2= driver.findElement(By.id("num2"));
       int sum= parseInt(num1.getText())+ parseInt(num2.getText());
        System.out.println(sum);

       //Click on dropdown
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        dropDown.click();

        //Choose corresponding option
        //Locator for option with value equals to the sum
        WebElement answerOption=driver.findElement(By.cssSelector("[value='" + sum+ "']"));
        //[value="17"]
        answerOption.click();
        sleep(3000);


        //Click on Submit button
        WebElement submitButton= driver.findElement(By.tagName("button"));
        submitButton.click();

        //Check that alert contains text "Congratulations!"
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }
}
