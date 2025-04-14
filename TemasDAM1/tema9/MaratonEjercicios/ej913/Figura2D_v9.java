package programacion.tema9.MaratonEjercicios.ej913;

public abstract class Figura2D_v9 {
    private String nombre;
    private double ancho;
    private double alto;

    public Figura2D_v9(Figura2D_v9 figura) {
        this.ancho = figura.ancho;
        this.alto = figura.alto;
        this.nombre = figura.nombre;
    }

    public Figura2D_v9(double ancho, double alto, String nombre) {
        this.ancho = ancho;
        this.alto = alto;
        this.nombre = nombre;
    }

    public Figura2D_v9() {
        this.ancho = 0;
        this.alto = 0;
        this.nombre = null;
    }

    public Figura2D_v9(double lado, String nombre) {
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

    public abstract double area();

    public abstract double precio(float precioMetroCuadrado);
}
