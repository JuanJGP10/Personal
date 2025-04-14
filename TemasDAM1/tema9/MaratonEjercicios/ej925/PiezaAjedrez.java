package programacion.tema9.MaratonEjercicios.ej925;

public abstract class PiezaAjedrez implements JuegoTablero {
    protected int fila;
    protected int columna;

    public PiezaAjedrez(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public abstract boolean mover(int fila, int columna);

    protected boolean comprobarPosicion(int x) {
        if (x >= 1 && x <= 8) {
            return true;
        } else {
            return false;
        }
    }

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
