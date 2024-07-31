import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Frames {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe" );
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/frames");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void framesTest() {
        driver.switchTo().frame("frame1");
        WebElement header= driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", header.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        WebElement smallHeader= driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", smallHeader.getText());
    }
}
