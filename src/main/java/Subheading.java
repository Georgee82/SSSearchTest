public enum Subheading {

    SELLING("1"),
    BUYING("2"),
    DIFFERENT("5");

    private String type;

    private Subheading(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
