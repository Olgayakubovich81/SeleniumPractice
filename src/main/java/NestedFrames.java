import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFrames {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe" );
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/nestedframes");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

 @Test
     public void nestedFramesTest() {
     driver.switchTo().frame("frame1");
     WebElement parentHeader= driver.findElement(By.tagName("body"));
     assertEquals("Parent frame", parentHeader.getText());
     WebElement frameChild= driver.findElement(By.tagName("Iframe"));
     driver.switchTo().frame(frameChild);
     WebElement childHeader= driver.findElement(By.tagName("p"));
     assertEquals("Child Iframe", childHeader.getText());

 }
}




