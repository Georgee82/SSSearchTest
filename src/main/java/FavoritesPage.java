import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class FavoritesPage {

    public SelenideElement favoritesList(){
        return Markup.favoritesList();
    }

    private static class Markup{

        static SelenideElement favoritesList(){
            return Selenide.$(Selectors.byAttribute("id","filter_frm"));
        }
    }
}
