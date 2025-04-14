package programacion.tema9.MaratonEjercicios.ej915;

public class Esfera_v2 extends Figura3D_v2 {
    private double radio;

    public Esfera_v2(double radio) {
        this.radio = radio;
    }

    @Override
    public double volumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double superficie() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
}
