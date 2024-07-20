package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000;

    }
    @Tag("testbase1")
    @Test
    void fillFormTests() {

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Kul");
        $("#userEmail").setValue("example@example.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8999111663");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("#currentAddress").setValue("First street");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form\n"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name Elena Kul"),
                Condition.text("Student Email example@example.com"),
                Condition.text("Gender Female"),
                Condition.text("Mobile 8999111663"),
                Condition.text("Date of Birth 01 December,1986"),
                Condition.text("Subjects Maths"),
                Condition.text("Hobbies Sports"),
                Condition.text("img.png"),
                Condition.text("Address First street"),
                Condition.text("State and City NCR Delhi")

        );

    }

}
