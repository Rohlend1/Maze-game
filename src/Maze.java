
import java.awt.*;
import java.util.ArrayList;


public class Maze { // класс управляющий лабиринтом
    private static Level currentLevel = Level.LEVEL1;
    private static final Level level1 = Level.LEVEL1;
    private static final Level level2 = Level.LEVEL2;
    private static final Level level3 = Level.LEVEL3;
//    private static final Level level4 = Level.LEVEL4;
    private static int levelId = 0;
    private static final ArrayList<ArrayList<Cell>> cells = new ArrayList<>();
    private static final int startX = 10;
    private static final int startY = 10;
    private static Cell enterCell = null;
    private static Cell exitCell = null;


    public static ArrayList<ArrayList<Cell>> getCells(){
        return cells;
    }
    public static void nextLevel(){ // переход на следующий уровень, если уровень последний то заканчиваем игру
        cells.clear();
        Hero.getInstance().setX(Maze.getStartX()+Maze.getCurrentLevel().getCellWidthHeight()/4);
        Hero.getInstance().setY(Maze.getStartY()+Maze.getCurrentLevel().getCellWidthHeight()/4);

        if(levelId < Level.values().length) levelId++;
        if(levelId == Level.values().length) MainPanel.setFlag(true);
        else currentLevel = Level.values()[levelId];


    }
    public static Level getCurrentLevel(){
        return currentLevel;
    }
    public static void setLevelId(int levelId){
        Maze.levelId = levelId;
    }

    public static void setCurrentLevel(Level currentLevel) {
        Maze.currentLevel = currentLevel;
    }

    public static void draw(Graphics g){
        switch (currentLevel){
            case LEVEL1 -> getLevel(g, level1);
            case LEVEL2 -> getLevel(g, level2);
            case LEVEL3 -> getLevel(g, level3);
//            case LEVEL4 -> getLevel(g, level4);
        }
    }
    public static void fillCells(int level){ // заполнение списка клетками если он пустой
        cells.clear();

        for(int i = 0; i < level;i++){
            ArrayList<Cell> tempCells = new ArrayList<>();
            for(int j = 0;j < level;j++){
                tempCells.add(new Cell(startX+ currentLevel.getCellWidthHeight()*j,startY+i* currentLevel.getCellWidthHeight()));
            }
            cells.add(tempCells);
        }
    }
    public static int getStartX(){
        return startX;
    }
    public static int getStartY(){
        return startY;
    }
    public static void getLevel(Graphics g, Level level){ // содание уровня если он еще не создан и его отрисовка
        if(cells.size() == 0) {
            fillCells(level.getCellCount());
            MazeCreater.createMaze(cells);
            enterCell = cells.get(0).get(0);
            exitCell = cells.get(currentLevel.getCellCount()-1).get(currentLevel.getCellCount()-1);
        }
        enterCell.setLeftBorder(false);
        exitCell.setRightBorder(false);
        g.setColor(Color.GREEN);
        g.fillRect(enterCell.getX(),enterCell.getY(), currentLevel.getCellWidthHeight(), currentLevel.getCellWidthHeight()); //рисуем квадратики зеленая это старт, а красная финиш
        g.setColor(Color.RED);
        g.fillRect(exitCell.getX(),exitCell.getY(), currentLevel.getCellWidthHeight(), currentLevel.getCellWidthHeight());
        g.setColor(Color.BLACK);
        int cellWidthHeight = currentLevel.getCellWidthHeight();
        for(var arr: cells){
            g.setColor(Color.BLACK);
            for(var cell : arr){
                if(cell.hasBottomBorder()) g.drawLine(cell.getX(),cell.getY()+ cellWidthHeight,cell.getX() + cellWidthHeight,cell.getY()+ cellWidthHeight); // отрисовка граней нижней, верхней, левой и правой соответственно
                if(cell.hasUpperBorder()) g.drawLine(cell.getX(),cell.getY(),cell.getX()+ cellWidthHeight,cell.getY());
                if(cell.hasLeftBorder()) g.drawLine(cell.getX(),cell.getY(),cell.getX(),cell.getY()+ cellWidthHeight);
                if(cell.hasRightBorder()) g.drawLine(cell.getX()+ cellWidthHeight,cell.getY(),cell.getX()+cellWidthHeight,cell.getY()+ cellWidthHeight);
            }
        }
    }
}
