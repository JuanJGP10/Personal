package programacion.tema9.MaratonEjercicios.ej914;

public class Esfera_v1 extends Figura3D_v1 {
    private double radio;

    public Esfera_v1(double radio) {
        this.radio = radio;
    }

    @Override
    public double volumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }
}
