import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    public void filterByPrice() {
        Markup.priceSorter().click();
    }

    public void selectDealType(DealType dealType) {
        Markup.dealTypeDropDown().selectOption(dealType.getIndex());
    }

    public void openExtendedSearch() {
        Markup.extendedSearchLink().click();
    }

    private void saveNumberOfFirstResults(Integer number){
        new SavedElements().set(Markup.allResults().first(number));
    }

    public void selectNumberOfFoundResults(Integer number) {
        saveNumberOfFirstResults(number);
        ElementsCollection collection = new SavedElements().get();
        for(int i=0; i<=number-1;i++){
            collection.get(i).find(Markup.itemsCheckbox()).click();
        }
    }

    public void saveSelectedResultsToFavorites(){
        Markup.addToFavoritesLink().click();
    }

    private static class Markup {
        static SelenideElement priceSorter() {
            return $(byAttribute("class", "a19"));
        }

        private static SelenideElement filterMenu() {
            return $(byAttribute("class", "filter_second_line_dv"));
        }

        static SelenideElement dealTypeDropDown() {
            return filterMenu().$$(byAttribute("class", "filter_sel")).last();
        }

        static SelenideElement extendedSearchLink() {
            return $$(byAttribute("class", "a9a")).filterBy(visible).first();
        }

        static SelenideElement foundItemsTable() {
            return $(byAttribute("id", "page_main"))
                    .$$(byCssSelector("table")).get(1);
        }

        static ElementsCollection allResults(){
            return foundItemsTable().$$(byCssSelector("tr[id^='tr_']"));
        }

        static By itemsCheckbox() {
            return byAttribute("type", "checkbox");
        }

        static SelenideElement addToFavoritesLink(){
            return $(byAttribute("id","a_fav_sel"));
        }
    }
}
