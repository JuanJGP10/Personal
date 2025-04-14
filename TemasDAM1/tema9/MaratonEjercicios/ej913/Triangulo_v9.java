package programacion.tema9.MaratonEjercicios.ej913;

public class Triangulo_v9 extends Figura2D_v9 {
    public String cadena;

    public Triangulo_v9(String cadena, double ancho, double alto, String nombre) {
        super(ancho, alto, nombre);
        this.cadena = cadena;
    }

    public Triangulo_v9(Triangulo_v9 tr) {
        super(tr);
        this.cadena = tr.cadena;
    }

    public Triangulo_v9() {
        super();
        this.cadena = null;
    }

    public Triangulo_v9(double lado, String nombre) {
        super(lado, nombre);
        this.cadena = "IgualBaseAltura";
    }

    @Override
    public double area() {
        return (getAncho() * getAlto()) / 2;

    }

    public void verEstilo() {
        System.out.println(cadena);
    }

    @Override
    public double precio(float precioMetroCuadrado) {
        return area() * precioMetroCuadrado;
    }
}
