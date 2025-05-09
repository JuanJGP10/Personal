package programacion.tema9.MaratonEjercicios.ej95;

public class Figura2D_v5 {
    private double ancho;
    private double alto;

    public Figura2D_v5(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public Figura2D_v5() {
        this.ancho = 0;
        this.alto = 0;
    }

    public Figura2D_v5(double lado) {
        this.ancho = lado;
        this.alto = lado;
    }

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
