package programacion.tema9.MaratonEjercicios.ej97;

public class Figura2D_v7 {
    private double ancho;
    private double alto;

    public Figura2D_v7(Figura2D_v7 figura) {
        this.ancho = figura.ancho;
        this.alto = figura.alto;
    }

    public Figura2D_v7(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public Figura2D_v7() {
        this.ancho = 0;
        this.alto = 0;
    }

    public Figura2D_v7(double lado) {
        this.ancho = lado;
        this.alto = lado;
    }

    public void verDim() {
        System.out.printf("Ancho: %.2f  -  Alto: %.2f \n", ancho, alto);
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
