package programacion.tema10.Ejercicios.Ejercicio8;

public class Movimientos {
    private String tipo;
    private double cuantia;

    public Movimientos(String tipo, double cuantia) {
        this.tipo = tipo;
        this.cuantia = cuantia;
    }

    @Override
    public String toString() {
        return "Tipo de movimiento: " + tipo + "|| Cuantia: " + cuantia;
    }

}