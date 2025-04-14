package programacion.tema9.MaratonEjercicios.ej924;

public class PiezaAlfil extends PiezaAjedrez {
    public PiezaAlfil(int fila, int columna) {
        super(fila, columna);
    }

    @Override
    public boolean mover(int fila, int columna) {

        if (comprobarPosicion(fila) && comprobarPosicion(columna)) {
            if (Math.abs(fila - this.fila) == Math.abs(columna - this.columna)) {
                this.fila = fila;
                this.columna = columna;
                return true;
            }
        }
        return false;
    }
}
