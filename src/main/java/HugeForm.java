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
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HugeForm {

    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://suninjuly.github.io/huge_form.html");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void hugeForm() throws InterruptedException {
        List<WebElement> inputFields= driver.findElements(By.tagName("input"));

        //Enter "Hello" to each input field from the inputFields collections
//        inputFields.forEach(inputField -> inputField.sendKeys("Hello"));
        for (WebElement input: inputFields) {
            input.sendKeys("Hello");
        }
         WebElement submitButton= driver.findElement(By.tagName("button"));
         submitButton.click();
//         sleep(20000);

         WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
         Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //    Congrats, you've passed the task!
         assertTrue(alert.getText().contains("Congrats, you've passed the task!"));


    }

}
