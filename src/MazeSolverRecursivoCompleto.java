import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursivoCompleto implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();

        if (findPath(grid, start, end, path, visited)) {
            Collections.reverse(path);
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, Set<Cell> visited) {
        int row = current.row;
        int col = current.col;

        // Validaciones
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return false;
        if (!grid[row][col]) return false; // No transitable
        if (visited.contains(current)) return false;
        visited.add(current);
        if (current.equals(end)) {
            path.add(current);
            return true;
        }

        // Mover en las 4 direcciones
        Cell[] directions = {
            new Cell(row + 1, col),
            new Cell(row - 1, col),
            new Cell(row, col + 1),
            new Cell(row, col - 1)
        };

        for (Cell next : directions) {
            if (findPath(grid, next, end, path, visited)) {
                path.add(current);
                return true;
            }
        }

        return false;
    }
}