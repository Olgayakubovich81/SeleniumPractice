import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hover2 {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/tool-tips");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }



    @Test
    public void hoverMeToSeeToolTip() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toolTipButton")));
        //Hover over "Hover me to see" button
        WebElement hoverMeToSeeButton= driver.findElement(By.id("toolTipButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMeToSeeButton).perform();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("tooltip-inner")));
        //Check that tooltip has text "You hovered over the Button"
        WebElement toolTip= driver.findElement(By.className(".tooltip-inner"));
        assertEquals("Hover me to see", toolTip.getText());




        }
    }