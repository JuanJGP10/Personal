package programacion.tema9.MaratonEjercicios.ej915;

public class PrismaRectangular_v2 extends Figura3D_v2 {
    private double largo, ancho, alto;

    public PrismaRectangular_v2(double largo, double ancho, double alto) {
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double volumen() {
        return largo * ancho * alto;
    }

    @Override
    public double superficie() {
        return 2 * (largo * ancho + largo * alto + ancho * alto);
    }
}
