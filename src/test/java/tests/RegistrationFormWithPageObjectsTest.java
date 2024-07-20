package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v115.page.model.FrameAttached;
import pages.components.CheckResultComponent;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultComponent results = new CheckResultComponent();

    @Tags({
            @Tag("regression"),
            @Tag("smoke")
    })
    @Test
    void successfulRegistrationTest() {

        registrationPage
                .openPage()
                .closeBanner()

                .setFirstName("Elena")
                .setLastName("Ku")
                .setEmail("example@example.com")
                .setGender("Female")
                .setUserNumber("8999111663")
                .setDateOfBirth("30", "December", "1986")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .uploadPicture("img.png")
                .setAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .submit();

        results
                .checkResult("Student Name", "Elena Ku")
                .checkResult("Student Email", "example@example.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8999111663")
                .checkResult("Date of Birth", "30 December,1986")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "img.png")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");

    }

}

