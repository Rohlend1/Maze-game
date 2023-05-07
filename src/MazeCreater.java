import java.util.ArrayList;

public class MazeCreater {
    public static void createMaze(ArrayList<ArrayList<Cell>> cells){
        int i = (int)(Math.random()*cells.size());
        int j = (int)(Math.random()*cells.size());
        Cell currentCell = cells.get(i).get(j);
        int visitedCells = cells.size()*cells.size();
        currentCell.setVisited(true);
        visitedCells-=1;
        while(visitedCells != 0){
            if((int)(Math.random()*10)>=5){
                if((int)(Math.random()*10)>=5){
                    if(j+1 < cells.size()) {
                        j++;
                        if(cells.get(i).get(j).isVisited()){
                            currentCell = cells.get(i).get(j);
                            continue;
                        }
                        currentCell.setRightBorder(false);
                        currentCell = cells.get(i).get(j);
                        currentCell.setLeftBorder(false);
                    }
                    else {

                        j--;
                        if(cells.get(i).get(j).isVisited()){
                            currentCell = cells.get(i).get(j);
                            continue;
                        }
                        currentCell.setLeftBorder(false);
                        currentCell = cells.get(i).get(j);
                        currentCell.setRightBorder(false);
                    }
                }
                else {
                    if(j-1 < 0) {

                        j++;
                        if(cells.get(i).get(j).isVisited()){
                            currentCell = cells.get(i).get(j);
                            continue;
                        }
                        currentCell.setRightBorder(false);
                        currentCell = cells.get(i).get(j);
                        currentCell.setLeftBorder(false);
                    }
                    else {

                        j--;
                        if(cells.get(i).get(j).isVisited()){
                            currentCell = cells.get(i).get(j);
                            continue;
                        }
                    currentCell.setLeftBorder(false);
                    currentCell = cells.get(i).get(j);
                    currentCell.setRightBorder(false);
                    }
                }
            }
            else{
                if((int)(Math.random()*10)>=5){
                    if(i+1 < cells.size()) {

                        i++;
                        if(cells.get(i).get(j).isVisited()){
                            currentCell = cells.get(i).get(j);
                            continue;
                        }
                        currentCell.setBottomBorder(false);
                        currentCell = cells.get(i).get(j);
                        currentCell.setUpperBorder(false);
                    }
                    else {

                        i--;
                        if(cells.get(i).get(j).isVisited()){
                            currentCell = cells.get(i).get(j);
                            continue;
                        }
                        currentCell.setUpperBorder(false);
                        currentCell = cells.get(i).get(j);
                        currentCell.setBottomBorder(false);
                    }
                }
                else {
                    if(i - 1 < 0){

                        i++;
                        if(cells.get(i).get(j).isVisited()){
                            currentCell = cells.get(i).get(j);
                            continue;
                        }
                        currentCell.setBottomBorder(false);
                        currentCell = cells.get(i).get(j);
                        currentCell.setUpperBorder(false);
                    }
                    else{

                        i--;
                        if(cells.get(i).get(j).isVisited()){
                            currentCell = cells.get(i).get(j);
                            continue;
                        }
                    currentCell.setUpperBorder(false);
                    currentCell = cells.get(i).get(j);
                    currentCell.setBottomBorder(false);
                    }
                }
            }
            currentCell.setVisited(true);
            visitedCells-=1;
        }
    }
}
