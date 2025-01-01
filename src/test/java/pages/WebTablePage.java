package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WebTablePage extends BasePage{

    public WebTablePage(String pageUrl) {
        super(pageUrl);
    }

    // "ADD" butonuna tıklama
    public SelenideElement addButton() {
        return $("#addNewRecordButton");
    }

    // Form alanlarına veri girme
    public SelenideElement firstNameInput() {
        return $("#firstName");
    }

    public SelenideElement lastNameInput() {
        return $("#lastName");
    }

    public SelenideElement userEmailInput() {
        return $("#userEmail");
    }

    public SelenideElement ageInput() {
        return $("#age");
    }

    public SelenideElement salaryInput() {
        return $("#salary");
    }

    public SelenideElement departmentInput() {
        return $("#department");
    }

    // "Submit" butonuna tıklama
    public SelenideElement submitButton() {
        return $("#submit");
    }

    // "Edit" butonuna tıklama
    public SelenideElement editButton(int recordId) {
        return $("div > span.mr-2#edit-record-" + recordId);
    }

    // WebTable'da kaydın görünmesini bekleme
    public void waitForRecord(String name) {
        $(".rt-tbody").shouldHave(text(name));
    }

    // Kaydın üzerinde güncelleme yapma
    public void updateFirstName(String newFirstName) {
        firstNameInput().clear();
        firstNameInput().sendKeys(newFirstName);
    }



}
