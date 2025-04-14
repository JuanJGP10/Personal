package programacion.tema9.MaratonEjercicios.ej96;

public class Triangulo_v6 extends Figura2D_v6 {
    public String cadena;

    public Triangulo_v6(String cadena, double ancho, double alto) {
        super(ancho, alto);
        this.cadena = cadena;
    }

    public Triangulo_v6() {
        super();
        this.cadena = null;
    }

    public Triangulo_v6(double lado) {
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
