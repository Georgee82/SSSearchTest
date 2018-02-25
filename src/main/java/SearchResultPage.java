import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byXpath;
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

    public void selectNumberOfFoundResults(Integer number) {
        for (int i = 0; i <= 3; i++) {
            Markup.itemsSelectCheckbox(i).click();
        }
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

        static ElementsCollection foundItems() {
            return $$(byAttribute("style", "cursor: pointer; background-color: rgb(255, 255, 255);"));
        }

        static SelenideElement itemsSelectCheckbox(int index) {
            return foundItems().get(index).find(byAttribute("type", "checkbox"));
        }
    }
}
