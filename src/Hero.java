import java.awt.*;
import java.util.ArrayList;

public class Hero {
    private static Hero instance;
    private int x;
    private int y;


    private Hero(int x, int y){
        this.x = x;
        this.y = y;
    }
    public static Hero getInstance(){
        if(instance == null) {
            instance = new Hero(Maze.getStartX()+Maze.getCurrentLevel().getCellWidthHeight()/4,
                    Maze.getStartY()+Maze.getCurrentLevel().getCellWidthHeight()/4);
        }
        return instance;
    }

    public void moveDown(){
        int dy = Maze.getCurrentLevel().getCellWidthHeight()/3;
        checkContactWithBorder(0,dy);
        if(checkEnd()){
            Maze.nextLevel();
        }
    }
    public void moveUp(){
        int dy = Maze.getCurrentLevel().getCellWidthHeight()/3;
        checkContactWithBorder(0,-dy);
        if(checkEnd()){
            Maze.nextLevel();
        }
    }
    public void moveRight(){
        int dx = Maze.getCurrentLevel().getCellWidthHeight()/3;
        checkContactWithBorder(dx,0);
        if(checkEnd()){
            Maze.nextLevel();
        }
    }
    public void moveLeft(){
        int dx = Maze.getCurrentLevel().getCellWidthHeight()/3;
        checkContactWithBorder(-dx,0);
        if(checkEnd()){
            Maze.nextLevel();
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    private void checkContactWithBorder(int dx,int dy){
        if(dy == 0 && dx != 0){
            if(x + dx > Maze.getStartX() && x + getWidth() + dx < Maze.getStartX()+(Maze.getCurrentLevel().getCellCount()) * Maze.getCurrentLevel().getCellWidthHeight()){
                Cell curCell = findCell(Maze.getCells());
                if(curCell!=null) {
                    if(dx < 0) {
                        if (curCell.hasLeftBorder() && x + dx < curCell.getX()) x = curCell.getX();
                        else x+=dx;
                    }
                    else { // тут проверка правого края аналогично у
                            if (curCell.hasRightBorder() && x + getWidth() + dx > curCell.getX()+getWidth()*2) x = curCell.getX()+getWidth();
                            else x+=dx;
                        }
                }
                else x+=dx;
            }
            else if(x + dx <= Maze.getStartX()){
                x = Maze.getStartX();
            }
            else if(x + getWidth() + dx >= Maze.getStartX()+(Maze.getCurrentLevel().getCellCount()) * Maze.getCurrentLevel().getCellWidthHeight()){
                x = Maze.getStartX()+(Maze.getCurrentLevel().getCellCount()) * Maze.getCurrentLevel().getCellWidthHeight() - getWidth();
            }
        }
        else if (dx == 0 && dy!=0){
            if(y + dy > Maze.getStartY() && y + getWidth() + dy < Maze.getStartY()+(Maze.getCurrentLevel().getCellCount()) * Maze.getCurrentLevel().getCellWidthHeight()){
                Cell curCell = findCell(Maze.getCells());
                if(curCell!=null) {
                    if(dy < 0) {
                        if (curCell.hasUpperBorder() && y + dy < curCell.getY()) y = curCell.getY();
                        else y+=dy;
                    }
                    else {
                        if (curCell.hasBottomBorder() && y + getWidth() + dy > curCell.getY()+getWidth()*2) y = curCell.getY()+getWidth();
                        else y+=dy;
                    }
                }
                else y+=dy;
            }
            else if(y + dy <= Maze.getStartY()){
                y = Maze.getStartY();
            }
            else if(y + getWidth() + dy >= Maze.getStartY()+(Maze.getCurrentLevel().getCellCount()) * Maze.getCurrentLevel().getCellWidthHeight()){
                y = Maze.getStartY()+(Maze.getCurrentLevel().getCellCount()) * Maze.getCurrentLevel().getCellWidthHeight() - getWidth();
            }
        }

    }
    private Cell findCell(ArrayList<ArrayList<Cell>> cells){
        for(var arr: cells){
            for(var cell : arr){
                if(((x+getWidth()/2 >= cell.getX() && x+getWidth()/2 <= cell.getX() + Maze.getCurrentLevel().getCellWidthHeight())) &&
                    ((y+getWidth()/2 >= cell.getY() && y+getWidth()/2 <= cell.getY() + Maze.getCurrentLevel().getCellWidthHeight()))) {
                    return cell;
                }
            }
        }
        return null;
    }

    public boolean checkEnd() {
        int finishX = Maze.getStartX() + (Maze.getCurrentLevel().getCellCount()-1) * Maze.getCurrentLevel().getCellWidthHeight();
        int finishY = Maze.getStartY() + (Maze.getCurrentLevel().getCellCount()-1) * Maze.getCurrentLevel().getCellWidthHeight();
        return ((x+getWidth()/2 >= finishX && x+getWidth()/2 <= finishX + Maze.getCurrentLevel().getCellWidthHeight())) &&
                ((y+getWidth()/2 >= finishY && y+getWidth()/2 <= finishY + Maze.getCurrentLevel().getCellWidthHeight()));
    }

    public void drawHero(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x,y,Maze.getCurrentLevel().getCellWidthHeight()/2,Maze.getCurrentLevel().getCellWidthHeight()/2);
    }
    private int getWidth(){
        return Maze.getCurrentLevel().getCellWidthHeight()/2;
    }
}
