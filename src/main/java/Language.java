public enum Language {

    RUSSIAN("RU"),
    LATVIAN("LV");

    private String language;

    Language(String language){
        this.language = language;
    }

    public String getLanguage(){
        return language;
    }
}
