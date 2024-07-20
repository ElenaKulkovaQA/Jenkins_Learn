package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class NegativeCaseRegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Tag("regression")
    @Test
    void checkValidationTest() {

        registrationPage.openPage();
        sleep(3000);

        registrationPage
                .closeBanner()
                .submit();

        $("#firstName").shouldNotHave(text("abc"));
        $("#lastName").shouldNotHave(text("abc"));
        $("#genterWrapper").shouldNotHave(text("abc"));
        $("#userNumber").shouldNotHave(text("abc"));

    }
}