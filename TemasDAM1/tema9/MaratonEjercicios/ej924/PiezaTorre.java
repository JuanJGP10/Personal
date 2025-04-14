package programacion.tema9.MaratonEjercicios.ej924;

public class PiezaTorre extends PiezaAjedrez {
    public PiezaTorre(int fila, int columna) {
        super(fila, columna);
    }

    @Override
    public boolean mover(int fila, int columna) {
        if (comprobarPosicion(columna) && comprobarPosicion(fila)) {
            if (this.fila != fila && this.columna == columna) {
                this.fila = fila;
                this.columna = columna;
                return true;
            } else if (this.fila == fila && this.columna != columna) {
                this.fila = fila;
                this.columna = columna;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
