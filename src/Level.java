public enum Level {
    LEVEL1(10,50),LEVEL2(15,40),LEVEL3(25,30);

    private final int cellCount;
    private final int cellWidthHeight;
    Level(int cellCount, int cellWidthHeight){
        this.cellCount = cellCount;
        this.cellWidthHeight = cellWidthHeight;
    }

    public int getCellCount() {
        return cellCount;
    }

    public int getCellWidthHeight() {
        return cellWidthHeight;
    }

    @Override
    public String toString() {
        return String.valueOf(this.ordinal() + 1);
    }
}
