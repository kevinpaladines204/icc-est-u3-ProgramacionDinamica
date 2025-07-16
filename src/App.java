

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nNombre : Kevin Paladines");
        runEjerciciosPD();
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
}
