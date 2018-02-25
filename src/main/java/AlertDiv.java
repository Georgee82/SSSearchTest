import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;

public class AlertDiv {

    public void clickOk(){
        Markup.okButton().click();
    }

    private static class Markup{

        static SelenideElement okButton(){
            return Selenide.$(byAttribute("id","alert_ok"));
        }
    }
}
