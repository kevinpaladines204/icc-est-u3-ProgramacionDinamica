import java.util.Set;

public class Maze {
    private boolean[][] maze;

    public Maze(boolean[][] predefinedMaze) {
        this.maze = predefinedMaze;
    }

    public boolean[][] getGrid() {
        return this.maze;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j]) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }

    public void printMaze(Set<Cell> visited, Cell start, Cell end) {
        int rows = maze.length;
        int cols = maze[0].length;
        String[][] displayGrid = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                displayGrid[i][j] = maze[i][j] ? " - " : " * ";
            }
        }

        for (Cell cell : visited) {
            if (cell.row >= 0 && cell.row < rows && cell.col >= 0 && cell.col < cols) {
                displayGrid[cell.row][cell.col] = " > ";
            }
        }

        for (String[] row : displayGrid) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}

