package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.components.CheckResultComponent;
import pages.RegistrationPage;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class RegistrationFormWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultComponent results = new CheckResultComponent();

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Tags({
            @Tag("regression"),
            @Tag("smoke")
    })
    @Test
    void successfulRegistrationTest() {

        step("Открываем главную страницу и ожидаем появление баннера",() -> {
        registrationPage.openPage();
        sleep(3000);
        })
        ;

        step("Закрываем баннер",() -> {
        registrationPage
                .closeBanner();
        })
        ;
        step("Заполняем поле Имя",() -> {
            registrationPage
                .setFirstName("Elena");
        })
        ;
        step("Заполняем поле Фамилия",() -> {
             registrationPage.setLastName("Ku");
        })
        ;
        step("Заполняем поле Почта",() -> {
            registrationPage
               .setEmail("example@example.com");
        })
        ;
        step("Выбираем значение Пол",() -> {
            registrationPage
              .setGender("Female");
        })
        ;
        step("Выбираем значение Номер телефона",() -> {
            registrationPage
                    .setUserNumber("8999111663");
        })
        ;
        step("Выбираем Дату рождения",() -> {
            registrationPage
                    .setDateOfBirth("30", "December", "1986");
        })
        ;
        step("Выбираем Предмет",() -> {
            registrationPage
                    .setSubjects("Maths");
        })
        ;
        step("Выбираем Хобби",() -> {
            registrationPage
                    .setHobbies("Sports");
        })
        ;
        step("Загружаем картинку",() -> {
            registrationPage
                    .uploadPicture("img.png");
        })
        ;
        step("Заполняем адрес",() -> {
            registrationPage
                    .setAddress("Some address 1");
        })
        ;
        step("Выбираем штат",() -> {
            registrationPage
                    .setState("NCR");
        })
        ;
        step("Выбираем город",() -> {
            registrationPage
                    .setCity("Delhi");
        })
        ;
        step("Нажимаем submit",() -> {
            registrationPage
                    .submit();
        })
        ;

        step("Проверяем результат по полю имя студента",() -> {
        results
                .checkResult("Student Name", "Elena Ku");
        })
        ;
        step("Проверяем результат по полю почта студента",() -> {
            results
                    .checkResult("Student Email", "example@example.com");
        })
        ;
        step("Проверяем результат по полю Пол студента",() -> {
            results
                    .checkResult("Gender", "Female");
        })
        ;
        step("Проверяем результат по полю Номер телефона студента",() -> {
            results
                    .checkResult("Mobile", "8999111663");
        })
        ;
        step("Проверяем результат по полю Дата рождения телефона студента",() -> {
            results
                    .checkResult("Date of Birth", "30 December,1986");
        })
        ;
        step("Проверяем результат по полю Предмет студента",() -> {
            results
                    .checkResult("Subjects", "Maths");
        })
        ;
        step("Проверяем результат по полю Хобби студента",() -> {
            results
                    .checkResult("Hobbies", "Sports");
        })
        ;
        step("Проверяем результат по полю загруженная картинка студента",() -> {
            results
                    .checkResult("Picture", "img.png");
        })
        ;
        step("Проверяем результат по полю Адрес студента",() -> {
            results
                    .checkResult("Address", "Some address 1");
        })
        ;
        step("Проверяем результат по полю Штат и Город студента",() -> {
            results
                    .checkResult("State and City", "NCR Delhi");
        })
        ;

    }

}

