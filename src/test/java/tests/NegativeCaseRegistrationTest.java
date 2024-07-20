package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NegativeCaseRegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void checkValidationTest(){
        registrationPage
                .openPage()
                .closeBanner()
                .submit();

        $("#firstName").shouldNotHave(text("abc"));
        $("#lastName").shouldNotHave(text("abc"));
        $("#genterWrapper").shouldNotHave(text("abc"));
        $("#userNumber").shouldNotHave(text("abc"));

    }
}