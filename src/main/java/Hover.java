import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hover {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html#");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//li[@class=\"dropdown\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        sleep(2000);
        WebElement secondaryMenu = driver.findElement(By.xpath("//li[@class=\"secondary-dropdown\"]"));
        actions.moveToElement(secondaryMenu).perform();
        sleep(5000);
        //Click on Secondary action
        WebElement secondaryActionButton = driver.findElement(By.xpath("//a[@onclick=\"handleSecondaryAction()\"]"));
        secondaryActionButton.click();
        //Check that header has text "Secondary Page"
//        WebElement secondaryHeader = driver.findElement(By.cssSelector(".secondary-clicked h1"));
//        assertEquals("Secondary Page", secondaryHeader.getText());
        WebElement secondaryHeader = driver.findElement(By.cssSelector(".secondary-clicked h1"));
//        assertEquals("Secondary Page", secondaryHeader.getText());

    }
}




