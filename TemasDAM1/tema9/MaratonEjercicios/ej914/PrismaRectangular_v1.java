package programacion.tema9.MaratonEjercicios.ej914;

public class PrismaRectangular_v1 extends Figura3D_v1 {
    private double largo, ancho, alto;

    public PrismaRectangular_v1(double largo, double ancho, double alto) {
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double volumen() {
        return largo * ancho * alto;
    }
}
