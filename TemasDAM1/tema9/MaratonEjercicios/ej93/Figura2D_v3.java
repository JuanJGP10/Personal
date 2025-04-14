package programacion.tema9.MaratonEjercicios.ej93;

public class Figura2D_v3 {
    private double ancho;
    private double alto;

    public void verDim() {
        System.out.printf("Ancho: %.2f  -  Alto: %.2f", ancho, alto);
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

}
