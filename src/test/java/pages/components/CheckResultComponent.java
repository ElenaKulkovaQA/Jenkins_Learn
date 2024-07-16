package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckResultComponent {

    private SelenideElement

            dialogWindow = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg");


    public CheckResultComponent  apperWindow() {
        dialogWindow.should(appear);
        return this;
    }

    public CheckResultComponent setModalTitle(String value) {
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }


    public CheckResultComponent checkResult(String resultName, String resultValue) {

        String locator = "//*[contains(text(),'" + resultName + "')]/../td[2]";

        $x(locator).shouldHave(Condition.text(resultValue));

        return this;
    }


}



