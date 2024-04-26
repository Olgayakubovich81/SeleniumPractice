import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatsTest {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "\\C:\\Users\\Tel-ran.de\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/cats.html");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void headerTest() {
        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Cat memes", header.getText());
    }

    @Test
    public void firstCardName() {
        WebElement firstCardName = driver.findElement(By.cssSelector(".col-sm-4:nth-child(1) .card-text"));
        assertEquals("Bullet cat", firstCardName.getText());
    }

    @Test
    public void catsAlbumTextTest() {
        WebElement albumName = driver.findElement(By.tagName("strong"));
        assertEquals("Cats album", albumName.getText());

    }

    @Test
    public void subHeaderContainsText() {
        WebElement subHeader = driver.findElement(By.id("moto"));
//        assertEquals("cat memes", subHeader.getText());
        assertTrue(subHeader.getText().contains("cat memes"));

    }

    @Test
    public void firstCardIsDisplayed() {
        WebElement firstCard = driver.findElement(By.cssSelector(".col-sm-4:nth-child(1)"));
        assertTrue(firstCard.isDisplayed());

    }

    @Test
    public void thirdCardEditButtonIsDisplayed() {

        WebElement thirdCard = driver.findElement(By.xpath("//div[@class='col-sm-4'][3]//button[2]"));
//       WebElement thirdCard= driver.findElement(By.cssSelector(".col-sm-4:nth-child(3) button:nth-child(2)"));
        assertTrue(thirdCard.isDisplayed());
    }

    //1. Check that View button of 5rd card is displayed
    @Test
    public void fifthCardViewButtonIsDisplayed() {
        WebElement fifthCardViewButton = driver.findElement(By.cssSelector(".col-sm-4:nth-child(5) button:nth-child(2)"));
        assertTrue(fifthCardViewButton.isDisplayed());
    }
//2. Name of 6th card is "I love you so much"

    @Test
    public void cardSixNameTest() {
        //        WebElement cardSixNameTest = driver.findElement(By.cssSelector(".col-sm-4:nth-child(6) .card-text"));
        WebElement cardSixNameTest = driver.findElement(By.xpath("//div[@class='col-sm-4'][6]//p[@class='card-text']"));
        assertEquals("I love you so much", cardSixNameTest.getText());

    }

    //Check that there are 6 cards
    @Test
    public void checkCardQuantityTest() {

        List<WebElement> cards = driver.findElements(By.className("col-sm-4"));
        assertEquals(6, cards.size());
    }

    //Check that there are 6 images on the page
    @Test
    public void checkImgQuantityTest() {

        List<WebElement> images = driver.findElements(By.tagName("img"));
        assertEquals(6, images.size());

    }

    @Test
    public void checkAllCardsAreDisplayed() {

        List<WebElement> cards =
                driver.findElements(By.className("col-sm-4"));
//                for (int i=0; i<cards.size(); i++ ) {
//                   assertTrue(cards.get(i).isDisplayed());

//        for (WebElement card:cards) {
//            assertTrue(card.isDisplayed());
        cards.forEach(card -> assertTrue(card.isDisplayed()));
    }

    //1. Все картинки с котиками отображаются на странице
    @Test
    public void checkAllImagesAreDisplayed() {

        List<WebElement> images =
                driver.findElements(By.tagName("img"));
        for (WebElement img : images) {
            assertTrue(img.isDisplayed());

        }
    }

    //2. Все кнопки "View" и "Edit" отбражаются на странице

    @Test
    public void checkAllViewButtonsAreDisplayed() {

        List<WebElement> viewButtons =
                driver.findElements(By.cssSelector(".col-sm-4 button:nth-child(1)"));
        for (WebElement viewBtn : viewButtons) {
            assertTrue(viewBtn.isDisplayed());

        }
    }
    @Test
    public void checkAllEditButtonsAreDisplayed() {

        List<WebElement> editButtons =
                driver.findElements(By.cssSelector(".col-sm-4 button:nth-child(2)"));
        for (WebElement editBtn : editButtons) {
            assertTrue(editBtn.isDisplayed());

        }
    }
}




