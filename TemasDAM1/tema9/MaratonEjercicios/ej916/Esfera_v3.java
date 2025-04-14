package programacion.tema9.MaratonEjercicios.ej916;

public class Esfera_v3 implements Figura3D_v3 {
    private double radio;

    public Esfera_v3(double radio) {
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
