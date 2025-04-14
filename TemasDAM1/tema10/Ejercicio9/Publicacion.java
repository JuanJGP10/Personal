package programacion.tema10.Ejercicio9;

public abstract class Publicacion implements Comparable<Publicacion> {
    final int id;

    // Private para q no se acceda desde otro lado
    // public static int contador = 0;

    private static int contador = 0;

    public Publicacion() {
        this.id = contador;
        contador++;
    }

    public abstract void mostrarEnLinea();

}
