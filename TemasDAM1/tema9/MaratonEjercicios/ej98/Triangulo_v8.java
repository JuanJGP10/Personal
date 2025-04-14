package programacion.tema9.MaratonEjercicios.ej98;

public class Triangulo_v8 extends Figura2D_v8 {
    public String cadena;

    public Triangulo_v8(String cadena, double ancho, double alto, String nombre) {
        super(ancho, alto, nombre);
        this.cadena = cadena;
    }

    public Triangulo_v8(Triangulo_v8 tr) {
        super(tr);
        this.cadena = tr.cadena;
    }

    public Triangulo_v8() {
        super();
        this.cadena = null;
    }

    public Triangulo_v8(double lado, String nombre) {
        super(lado, nombre);
        this.cadena = "IgualBaseAltura";
    }

    public double area() {
        return (getAncho() * getAlto()) / 2;
    }

    public void verEstilo() {
        System.out.println(cadena);
    }
}
