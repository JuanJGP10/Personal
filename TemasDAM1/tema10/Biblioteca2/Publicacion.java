package programacion.tema10.Biblioteca2;

public abstract class Publicacion implements Comparable<Publicacion> {
    final int id;

    private static int contador = 0;

    public Publicacion() {
        this.id = contador++;
    }

    public int getId() {
        return id;
    }

    public abstract void mostrarEnLinea();
}
