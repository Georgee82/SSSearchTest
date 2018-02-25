import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class TopMenu {

    public void selectLanguage(Language language){
        if(Markup.languageSelector().getText().equals(language.getLanguage())){
            Markup.languageSelector().click();
        }
    };

    public void openSearchForm(){
        Markup.searchLink().click();
    }

    private static class Markup{

        private static SelenideElement topMenuTable(){
            return $(byAttribute("id", "main_table"));
        }

        static SelenideElement languageSelector(){
            return topMenuTable().$$(byAttribute("class","a_menu")).last();
        }

        static SelenideElement searchLink(){
            return topMenuTable().$$(byAttribute("class","a_menu")).get(2);
        }


    }
}
