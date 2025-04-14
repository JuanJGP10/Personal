package programacion.tema9.MaratonEjercicios.ej98;

public class Figura2D_v8 {
    private String nombre;
    private double ancho;
    private double alto;

    public Figura2D_v8(Figura2D_v8 figura) {
        this.ancho = figura.ancho;
        this.alto = figura.alto;
        this.nombre = figura.nombre;
    }

    public Figura2D_v8(double ancho, double alto, String nombre) {
        this.ancho = ancho;
        this.alto = alto;
        this.nombre = nombre;
    }

    public Figura2D_v8() {
        this.ancho = 0;
        this.alto = 0;
        this.nombre = null;
    }

    public Figura2D_v8(double lado, String nombre) {
        this.ancho = lado;
        this.alto = lado;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
