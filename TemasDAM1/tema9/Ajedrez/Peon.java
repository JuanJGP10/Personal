package programacion.tema9.Ajedrez;

/**
 * Clase peon que representa la pieza peon de una partida de ajedrez, ademas,
 * hereda de pieza
 */
public class Peon extends Pieza {
    /**
     * Constructor de objetos peones que los creara a partir de los siguientes 3
     * parametros:
     * 
     * @param color ColorPieza color de la pieza
     * @param x     Coordenada X donde aparecera la pieza
     * @param y     Coordenada Y donde aparecera la pieza
     */
    public Peon(ColorPieza color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Sobreescribimos el metodo mover para el peon donde tendremos en cuenta que
     * el peon no se podra mover en el eje X, solo se podra mover dos posiciones en
     * el eje Y si esta en y = 2, y por ultimo que solo se podra mover una posicion
     * del eje Y, y siempre hacia adelante.
     * 
     * Como este juego esta pensado para que el usuario sea blancas, mis peones se
     * moveran hacia arriba, y las piezas negras del rival que sean peones se
     * moveran hacia abajo ya que es desde mi punto de vista
     */
    @Override
    public void mover(int x, int y) {

        if (!comida) {
            if (comprobarPosicion(x) && comprobarPosicion(y)) {
                // no se pueda mover en X
                if (color.equals(ColorPieza.BLANCO) && x == posicion.getX()) {
                    // pueda moverse dos casillas si esta en y = 1, en tablero seria y = 2
                    if (posicion.getY() == 1 && y == posicion.getY() + 2) {
                        posicion.setLocation(x, y);
                    } else {
                        // pueda moverse 1 casilla
                        if (posicion.getY() + 1 == y) {
                            posicion.setLocation(x, y);
                        }
                    }
                }

                if (color.equals(ColorPieza.NEGRO) && x == posicion.getX()) {
                    // pueda moverse dos casillas si esta en y = 1, en tablero seria y = 2
                    if (posicion.getY() == 6 && y == posicion.getY() - 2) {
                        posicion.setLocation(x, y);
                    } else {
                        // pueda moverse 1 casilla
                        if (posicion.getY() - 1 == y) {
                            posicion.setLocation(x, y);
                        }
                    }
                }
            }
        }

    }

}