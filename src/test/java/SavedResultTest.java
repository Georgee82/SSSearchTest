import com.codeborne.selenide.*;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.open;

public class SavedResultTest {

    private TopMenu topMenu = new TopMenu();
    private MainPage mainPage = new MainPage();
    private SearchForm searchForm = new SearchForm();
    private SearchResultPage searchResultPage = new SearchResultPage();
    private AlertDiv alert = new AlertDiv();
    private FavoritesPage favoritesPage = new FavoritesPage();

    @BeforeClass
    public static void testSetUp() {
        open("https://www.ss.com");
    }

    @Test
    public void favoritesAreSaved() {
        topMenu.selectLanguage(Language.RUSSIAN);
        mainPage.openElectronicsDepartment();
        topMenu.openSearchForm();
        searchForm.setPriceRange("100", "1500");
        searchForm.selectSubheading(Subheading.SELLING);
        searchForm.searchFor("Компьютер");
        searchForm.pressEnter();
        searchResultPage.filterByPrice();
        searchResultPage.selectDealType(DealType.SELL);
        searchResultPage.openExtendedSearch();
        searchForm.setPriceRange("0", "300");
        searchForm.pressEnter();
        searchResultPage.selectNumberOfFoundResults(3);
        searchResultPage.saveSelectedResultsToFavorites();
        alert.clickOk();
        topMenu.openFavoritesPage();
        ElementsCollection selectedResultsList = new SavedElements().get();
        for (int i = 0; i <= selectedResultsList.size()-1; i++) {
            //TODO Found a bug in this assert.(Random stale element exception). Need save only "id" , not the whole element
            favoritesPage.favoritesList().find(byAttribute("id",selectedResultsList.get(i).getAttribute("id"))).shouldBe(Condition.visible);
        }
    }
}
