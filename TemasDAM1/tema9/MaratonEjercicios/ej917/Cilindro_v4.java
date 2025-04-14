package programacion.tema9.MaratonEjercicios.ej917;

public class Cilindro_v4 implements Figura3D_v4 {
    private double radio;
    private double altura;

    public Cilindro_v4(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double volumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public double superficie() {
        return 2 * Math.PI * radio * (radio * altura);
    }
}
