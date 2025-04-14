package programacion.tema9.MaratonEjercicios.ej97;

public class Triangulo_v7 extends Figura2D_v7 {
    public String cadena;

    public Triangulo_v7(String cadena, double ancho, double alto) {
        super(ancho, alto);
        this.cadena = cadena;
    }

    public Triangulo_v7(Triangulo_v7 tr) {
        super(tr);
        this.cadena = tr.cadena;
    }

    public Triangulo_v7() {
        super();
        this.cadena = null;
    }

    public Triangulo_v7(double lado) {
        super(lado);
        this.cadena = "IgualBaseAltura";
    }

    public double area() {
        return (getAncho() * getAlto()) / 2;
    }

    public void verEstilo() {
        System.out.println(cadena);
    }
}
