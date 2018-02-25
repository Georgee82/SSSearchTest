import com.codeborne.selenide.Selenide;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class SavedResultTest {

    private TopMenu topMenu = new TopMenu();
    private MainPage mainPage = new MainPage();
    private SearchForm searchForm = new SearchForm();

    @BeforeClass
    public static void testSetUp(){
        open("https://www.ss.com");
    }

    @Test
    public void favoritesAreSaved(){
        topMenu.selectLanguage(Language.RUSSIAN);
        mainPage.openElectronicsDepartment();
        topMenu.openSearchForm();
        searchForm.searchFor("Компьютер");
        searchForm.setPriceRange("100","1500");
        searchForm.selectSubheading(Subheading.SELLING);
        Selenide.sleep(10000);
    }
}
