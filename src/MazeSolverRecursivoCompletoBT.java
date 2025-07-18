import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursivoCompletoBT implements MazeSolver {
    private Set<Cell> visited;
    private List<Cell> path;
    private boolean[][] grid;
    private Cell end;

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {

        this.visited = new HashSet<>();
        this.path = new ArrayList<>();
        this.grid = grid;
        this.end = end;
        
        if(grid == null || grid.length == 0)
            return path;

        if(findPath(start)){
            System.out.println("Ruta visitada");
            System.out.println(visited);
            System.out.println();

            System.out.println("Ruta optima");
            Collections.reverse(path);
            System.out.println(path);
            return path;
        }
        
        return new ArrayList<>();
    }

    private boolean findPath(Cell current){
        if(!isInMaze(current)){
            return false;
        }
        if(!isValid(current)){
            return false;
        }

        visited.add(current);

        if (current.equals(end)) {
            path.add(current);
            return true;
        }

        // mueve en cuatro direcciones
        if (findPath(new Cell(current.row, current.col + 1)) ||
            findPath(new Cell(current.row + 1, current.col)) ||
            findPath(new Cell(current.row, current.col - 1)) ||
            findPath(new Cell(current.row - 1, current.col))) {
            path.add(current);
            return true;
        }
        return false;
    }

    private boolean isValid(Cell current){
        int row = current.row;
        int col = current.col;
        if(!grid[row][col]|| visited.contains(current)){
            return false;
        }
        return true;
    }

    private boolean isInMaze(Cell current){
        int row = current.row;
        int col = current.col;
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return false;
        }
        return true;
    }  
}
