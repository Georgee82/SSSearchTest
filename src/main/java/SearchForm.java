import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class SearchForm {

    public void searchFor(String searchTerm) {
        Markup.searchTermField().setValue(searchTerm);
    }

    public void setPriceRange(String min, String max){
        Markup.priceFrom().setValue(min);
        Markup.priceTo().setValue(max);
    }

    public void selectSubheading(Subheading dealType){
        Markup.subheadingDropDown().selectOptionByValue(dealType.getType());
    }

    private static class Markup {
        static SelenideElement searchTermField() {
            return $(byAttribute("id", "ptxt"));
        }

        static SelenideElement priceFrom(){
            return $(byAttribute("name","topt[8][min]"));
        }

        static SelenideElement priceTo(){
            return $(byAttribute("name","topt[8][max]"));
        }

        static SelenideElement subheadingDropDown(){
            return $(byAttribute("name","sid"));
        }
    }
}
