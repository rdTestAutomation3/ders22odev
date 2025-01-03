package tests;

import common.PageManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class ButtonTest extends BaseTest{
    PageManager pageManager=new PageManager();

    @BeforeMethod
    public  void before() {

        pageManager.buttonPage.open();
    }

    @Test
    public void testButtonClick() {
        // DemoQA sayfasını açıyoruz
        open("https://demoqa.com/elements");

        // Sayfada işlem yapıyoruz
        pageManager.buttonPage.clickButtonAndCheckMessage();

        // Mesajın doğru şekilde göründüğünü kontrol ediyoruz
        assertTrue(pageManager.buttonPage.isMessageDisplayed(), "Mesaj doğru gelmedi!");
    }
}
