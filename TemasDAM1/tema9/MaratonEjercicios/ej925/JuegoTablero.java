package programacion.tema9.MaratonEjercicios.ej925;

/**
 * Interfaz que define los metodos para pasar de indices a coordenadas de un
 * ajedrez real y viceversa
 */
public interface JuegoTablero {
    char indiceAPosicion(int indice);

    int indiceAPosicionN(int indice);

    int posicionAIndice(char posicion);

    int posicionAlIndice(int posicion);
}
