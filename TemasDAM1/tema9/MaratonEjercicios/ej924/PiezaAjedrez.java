package programacion.tema9.MaratonEjercicios.ej924;

public abstract class PiezaAjedrez {
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
}
