import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Registration {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/registration1.html");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successRegistrationWithRequiredFields() throws InterruptedException {
        WebElement firstNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");

        WebElement lastNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Black");

        WebElement emailInputField =
                driver.findElement(By.cssSelector("[class=\"form-control third\"]"));
        emailInputField.sendKeys("jblack@gmail.com");

        WebElement submitButton =
                driver.findElement(By.className("btn-default"));
        submitButton.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",
                header.getText());
    }

    @Test
    public void successRegistrationWithAllFields() {

        WebElement firstNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");

        WebElement lastNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Black");

        WebElement emailInputField =
                driver.findElement(By.cssSelector("[class=\"form-control third\"]"));
        emailInputField.sendKeys("jblack@gmail.com");

        WebElement phoneInputField = driver.findElement(By.xpath("//input[@placeholder='Input your phone:']"));
        phoneInputField.sendKeys("1232354");

        WebElement addressInputField = driver.findElement(By.xpath("//input[@placeholder='Input your address:']"));
        addressInputField.sendKeys("Baker Street, 65");

        WebElement submitButton =
                driver.findElement(By.className("btn-default"));
        submitButton.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",
                header.getText());

    }
    @Test
    public void withoutFirstName() {
        WebElement lastNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Black");
        WebElement emailInputField =
                driver.findElement(By.cssSelector("[class=\"form-control third\"]"));
        emailInputField.sendKeys("jblack@gmail.com");
        WebElement submitButton =
                driver.findElement(By.className("btn-default"));
        submitButton.click();
        //CHeck that error message is "Please fill in this field."
        WebElement firstNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
        assertEquals("Please fill in this field.",
                firstNameInputField.getAttribute("validationMessage"));

    }
    @Test
    public void withoutLastName() {
        WebElement firstNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
        firstNameInputField.sendKeys("Tom");
        WebElement emailInputField =
                driver.findElement(By.cssSelector("[class=\"form-control third\"]"));
        emailInputField.sendKeys("jblack@gmail.com");
        WebElement submitButton =
                driver.findElement(By.className("btn-default"));
        submitButton.click();
        //CHeck that error message is "Please fill in this field."
        WebElement lastNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
        assertEquals("Please fill in this field.",
                lastNameInputField.getAttribute("validationMessage"));

    }
    @Test
    public void withoutEmail() {
        WebElement firstNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your first name']"));
        firstNameInputField.sendKeys("Tom");
        WebElement lastNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Black");
        WebElement submitButton =
                driver.findElement(By.className("btn-default"));
        submitButton.click();
        //CHeck that error message is "Please fill in this field."
        WebElement emailInputField =
                driver.findElement(By.cssSelector("[class=\"form-control third\"]"));
        assertEquals("Please fill in this field.",
                emailInputField.getAttribute("validationMessage"));
    }
}


