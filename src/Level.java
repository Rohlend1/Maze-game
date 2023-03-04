public enum Level { // перечисление уровней в конструкторе количество клеток на уровне и их ширина
    LEVEL1(10,50),LEVEL2(15,40),LEVEL3(25,30);
//    LEVEL4(40,20);
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
        return ""+(this.ordinal()+1);
    }
}
