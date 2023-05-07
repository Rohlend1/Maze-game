

public class Cell {
    private boolean visited = false;
    private final int x;
    private final int y;
    private boolean leftBorder = true;
    private boolean rightBorder = true;
    private boolean upperBorder = true;
    private boolean bottomBorder = true;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean hasLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(boolean leftBorder) {
        this.leftBorder = leftBorder;
    }

    public boolean hasRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(boolean rightBorder) {
        this.rightBorder = rightBorder;
    }

    public boolean hasUpperBorder() {
        return upperBorder;
    }

    public void setUpperBorder(boolean upperBorder) {
        this.upperBorder = upperBorder;
    }

    public boolean hasBottomBorder() {
        return bottomBorder;
    }

    public void setBottomBorder(boolean bottomBorder) {
        this.bottomBorder = bottomBorder;
    }
}
