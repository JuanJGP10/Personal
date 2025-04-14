package programacion.tema9.Ajedrez;

import java.awt.Point;

/**
 * Clase pieza que sera abstracta y nos servira como plantilla para crear las
 * piezas de un tablero de ajedrez
 * 
 */
public abstract class Pieza implements JuegoTablero {

    protected ColorPieza color;
    protected Point posicion;
    protected boolean comida;

    /**
     * Constructor que le pasaremos como parametros:
     * 
     * @param color color de una clase enumeraciones llamada ColorPieza
     * @param x     Coordenada x para saber donde estara la pieza en el eje x
     * @param y     Coordenada y para saber donde estara la pieza en el eje y
     */
    public Pieza(ColorPieza color, int x, int y) {
        this.color = color;
        this.posicion = new Point(x, y);
        if (!comprobarPosicion(x) || !comprobarPosicion(y)) {
            comida = true;
        } else
            comida = false;
    }

    /**
     * Constructor pieza sin parametros que llamaremos al constructor anterior de 3
     * parametros pero poniendo unos valores por defecto
     */
    public Pieza() {
        this(ColorPieza.BLANCO, 10, 10);
    }

    /**
     * Constructor pieza que nos servira para crear una copia de una pieza que le
     * pasemos como parametro
     * 
     * @param pieza Pieza ya exitente
     */
    public Pieza(Pieza pieza) {
        this(pieza.color, pieza.getPosicion().x, pieza.getPosicion().y);
    }

    /**
     * Metodo abstracto que tendran que sobreescribir las subclases de esta clase.
     * Es un metodo que usaremos para mover la pieza en el tablero
     * 
     * @param x Coordenada x para saber donde estara la pieza en el eje x
     * @param y Coordenada y para saber donde estara la pieza en el eje y
     */
    public abstract void mover(int x, int y);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + (comida ? 1231 : 1237);
        return result;
    }

    /**
     * Metodo equals para comprobar si un objeto es igual que otro segun si es el
     * mismo tipo de pieza, del mismo color y se encuentra en la misma posición.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pieza other = (Pieza) obj;
        if (color != other.color)
            return false;
        if (comida != other.comida)
            return false;
        return true;
    }

    /**
     * Metodo para comprobar que la pieza este dentro del tablero
     * 
     * @param p posicion X o Y, dependiendo de cual estemos introduciendo por
     *          parametros
     * @return devuelve false si esta fuera del tablero y true si esta dentro
     */
    protected static boolean comprobarPosicion(int p) {
        if (p > 7 || p < 0)
            return false;
        else
            return true;
    }

    // Getters y setters
    public ColorPieza getColor() {
        return color;
    }

    public void setColor(ColorPieza color) {
        this.color = color;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    // Estos metodos de la interfaz seran para para convertir las coordenadas de un
    // tablero de ajedrez, donde las filas van de 1 a 8 y las columnas de A a H, a
    // los indices de un array, que en este caso van de 0 a 7:

    // Al desarrollarlos aqui los heredan las clases hijas asi no repito codigo

    /**
     * Metodo para pasar de indice [0,7] a posicion [A-H]
     * Importante, si se introducen valores que estarian fuera del tablero, se
     * asignara automaticamente a 0 o a Z
     * 
     * @param indice [0,7]
     * @return [A-H] segun el indice
     */
    @Override
    public char indiceAPosicion(int indice) {
        if (indice >= 0 && indice <= 7)
            return "ABCDEFGH".charAt(indice);
        else
            return 'Z';
    }

    /**
     * Metodo para pasar de indice [0,7] a posicion [1-8]
     * 
     * @param indice [0,7]
     * @return [1,8]
     */
    @Override
    public int indiceAPosicionN(int indice) {
        if (indice >= 0 && indice <= 7)
            return indice + 1;
        else
            return 0;
    }

    /**
     * Metodo para pasar de [A-H] a [0-7]
     * 
     * @param posicion [A-H]
     * @return [0-7]
     */
    @Override
    public int posicionAIndice(char posicion) {
        if ("ABCDEFGH".indexOf(posicion) != -1)
            return "ABCDEFGH".indexOf(posicion);
        else
            return 0;
    }

    /**
     * Metodo para pasar de [1-8] a [0-7]
     * 
     * @param posicion [1-8]
     * @return [0-7]
     */
    @Override
    public int posicionAlIndice(int posicion) {
        if (posicion >= 1 && posicion <= 8)
            return posicion - 1;
        else
            return 0;
    }

}
