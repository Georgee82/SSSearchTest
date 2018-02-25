import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public void openElectronicsDepartment(){
        Markup.electronicsDepartmentTitle().click();
    }

    private static class Markup{
        static SelenideElement electronicsBlock(){
            return $(byAttribute("id","td_6"));
        }

        static SelenideElement electronicsDepartmentTitle(){
            return electronicsBlock().find(byAttribute("class","a1"));
        }
    }
}
