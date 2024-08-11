package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            stateWrapper = $("#state"),
            cityWrapper = $("#city"),
            submitButton = $("#submit");

    private CalendarComponent
            calendarComponent = new CalendarComponent();

@Step("Открываем главную страницу и проверяем, что она содержит заголовок_Student Registration Form_")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Закрываем всплывающий банер")
    public RegistrationPage closeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Заполняем поле _FirstName_")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Заполняем поле _LastName_")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Заполняем поле _Email_")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    @Step("Заполняем поле _Gender_")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Заполняем поле _MobileNumber_")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    @Step("Заполняем поле _Subjects_")
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    @Step("Выбираем чек-бокс _Hobbies_")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Загружаем фото")

    public RegistrationPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);

        return this;
    }
    @Step("Заполняем поле _CurrentAddress_")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }
    @Step("Выбираем значение из списка для  _State_")
    public RegistrationPage setState(String value) {
        stateWrapper.click();
        $(byText(value)).click();

        return this;
    }
    @Step("Выбираем значение из списка для  _City_")
    public RegistrationPage setCity(String value) {
        cityWrapper.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Заполняем дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {

        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    @Step("Нажимаем _Submit_")

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }


}

