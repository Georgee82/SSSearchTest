import com.codeborne.selenide.ElementsCollection;

public class SavedElements {

    private static ElementsCollection savedElements;

    public void set(ElementsCollection elementsToSave){
        savedElements = elementsToSave;
    }

    public ElementsCollection get() {
        return savedElements;
    }
}
