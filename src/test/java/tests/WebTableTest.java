package tests;


//import com.codeborne.selenide.Selenide;
import common.PageManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class WebTableTest extends BaseTest{
    PageManager pageManager=new PageManager();

    @BeforeMethod
    public void setUp() {
        pageManager.webTablePage.open();
      

    }

    @Test
    public void testAddAndEditRecord() {

        // Sayfayı açıyoruz
        //Selenide.open("https://demoqa.com/webtables");

        // "ADD" butonuna tıklıyoruz
        pageManager.webTablePage.open();
        pageManager.webTablePage.addButton().click();

        // Yeni kaydın bilgilerini giriyoruz
        pageManager.webTablePage.firstNameInput().sendKeys("Tuba");
        pageManager.webTablePage.lastNameInput().sendKeys("Simsek");
        pageManager.webTablePage.userEmailInput().sendKeys("abcdg@gmail.com");
        pageManager.webTablePage.ageInput().sendKeys("30");
        pageManager.webTablePage.salaryInput().sendKeys("50000");
        pageManager.webTablePage.departmentInput().sendKeys("IT");

        // "Submit" butonuna tıklıyoruz
        pageManager.webTablePage.submitButton().click();

        // Kaydın listede görünmesini bekliyoruz
        pageManager.webTablePage.waitForRecord("Tuba Simsek");

        // Kaydı düzenlemek için düzenleme butonuna tıklıyoruz
        pageManager.webTablePage.editButton(4).click();  // ID'yi belirtmelisiniz (Örneğin, 4. kayıt)

        // Mevcut bilgileri düzenliyoruz
        pageManager.webTablePage.updateFirstName("Adem");

        // "Submit" butonuna tekrar tıklıyoruz
        pageManager.webTablePage.submitButton().click();

        // Güncellenen kaydın görünmesini bekliyoruz
        pageManager.webTablePage.waitForRecord("Adem");

        // Güncellenmiş kaydın görünür olduğunu doğruluyoruz
        Assert.assertTrue($("div.rt-tbody").getText().contains("Adem"), "Updated record with name 'Adem' should be visible.");
    }

    // @AfterMethod
    // public void tearDown() {
    //     Selenide.closeWebDriver();  // Tarayıcıyı kapatıyoruz
    // }
}
