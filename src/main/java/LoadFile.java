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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class  LoadFile {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://suninjuly.github.io/file_input.html");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void upLoadFileTest() throws InterruptedException {
        WebElement inputFirstName= driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        inputFirstName.sendKeys("Mike");
        WebElement inputLastName= driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        inputLastName.sendKeys("Johnson");
        WebElement inputEmail= driver.findElement(By.xpath("//input[@placeholder=\"Enter email\"]"));
        inputEmail.sendKeys("123");
        WebElement inputFile= driver.findElement(By.id("file"));
        inputFile.sendKeys("C:\\Users\\Tel-ran.de\\Desktop\\textfile.txt");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }

}
