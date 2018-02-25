import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    public void filterByPrice(){
        Markup.priceSorter().click();
    }

    public void selectDealType(DealType dealType){
        Markup.dealTypeDropDown().selectOption(dealType.getIndex());
    }

    private static class Markup{
        static SelenideElement priceSorter(){
            return $(byAttribute("class","a19"));
        }

        private static SelenideElement filterMenu(){
            return $(byAttribute("class","filter_second_line_dv"));
        }

        static SelenideElement dealTypeDropDown(){
            return filterMenu().$$(byAttribute("class","filter_sel")).last();
        }
    }
}
