package programacion.estudiarExamenTema11_15.biblioteca;

public abstract class Publicacion {
    final int identificador;
    private static int contador = 0;

    public Publicacion() {
        this.identificador = contador++;

    }

    abstract void mostrarEnLinea();
}
