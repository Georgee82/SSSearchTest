public enum DealType {

    SELL(1);

    private int index;

    private DealType(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
