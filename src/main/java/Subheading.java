public enum Subheading {

    SELLING("1");

    private String type;

    Subheading(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
