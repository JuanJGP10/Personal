package programacion.tema9.Ajedrez;

/**
 * Clase Torre que representa la torre de una partida de ajedrez, ademas, hereda
 * de pieza
 * donde podremos crear objetos torre
 */
public class Torre extends Pieza {

    /**
     * Constructor que creara los objetos torre a partir de los siguientes 3
     * parametros:
     * 
     * @param color ColorPieza color de la pieza
     * @param x     Coordenada X donde aparecera la pieza
     * @param y     Coordenada Y donde aparecera la pieza
     */
    public Torre(ColorPieza color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Sobreescribimos el metodo mover para la torre donde tendremos en cuenta que
     * la torre si se mueve en el eje y, no podra hacerlo en el eje x y viceversa
     */
    @Override
    public void mover(int x, int y) {

        if (!comida && comprobarPosicion(x) && comprobarPosicion(y)) {
            // Si se mueve en un eje en el otro no puede
            if (x != posicion.getX()) {
                if (y == posicion.getY()) {
                    posicion.setLocation(x, y);
                }

            } else if (y != posicion.getY()) {
                if (x == posicion.getX()) {
                    posicion.setLocation(x, y);
                }
            }
        }

    }

}
