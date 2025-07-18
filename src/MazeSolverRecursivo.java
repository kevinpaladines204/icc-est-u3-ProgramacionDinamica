import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell>getPath (boolean[][] grid, Cell start, Cell end){
        if (grid== null || grid.length == 0) {
            return new ArrayList<>();
        }

        List<Cell> path = new ArrayList<>();
        if (findPath(grid, start, end, path)){
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        //valido si la celda inicio esta dentro de mi grid
        //si la celda inicio su row esta dentro de mi grid
        //si la celda es transitble ==true
        int row = start.row;
        int col = start.col;

        if (row >=grid.length || col >=grid[0].length || !grid[row][col]) {
            return false;
        }

        //vaidar si es el final
        if(row == end.row && col == end.col) {
            path.add(start);
            return true;
        }
        
        //Derecha
        if(findPath(grid, new Cell(row + 1,col), end, path)){
            path.add( start);
            return true;
        }
        
        
        //
        if(findPath(grid, new Cell(row,col + 1), end, path)){
            path.add(start);
            return true;
        }
        return false;
           
    }
}
