import java.util.List;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nNombre : Kevin Paladines");
        //runEjerciciosPD();
        runMaze();
    }

    private static void runEjerciciosPD(){
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        System.out.println("Valor = 100 ");
        System.out.println("\nFibonnaci recursividad");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonnaci(100);
        long end = System.nanoTime();
        long duracion = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duracion );

        System.out.println("\ngetFibonnaci recursivo Caching");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFibonnaciPD(100);
        end = System.nanoTime();
        duracion = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duracion);
    }

    private static void runMaze(){
        boolean[][] predefinedMaze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}
        };

        //CLASE Maze con variable global
        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);
        
        List<MazeSolver> solvers = Arrays.asList(
            new MazeSolverRecursivo(),
            new MazeSolverRecursivoCompleto()
        );

        MazeSolver solver = solvers.get(0);
        List<Cell> path;
        path = solver.getPath(maze.getGrid(), start, end);
        System.out.println("Recursivo: " + path);

        MazeSolver solver2 = solvers.get(1);
        List<Cell> path2 = solver2.getPath(maze.getGrid(), start, end);
        System.out.println("Recursivo completo: " + path2);
    }
}