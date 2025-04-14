package programacion.tema9.MaratonEjercicios.ej95;

public class Triangulo_v5 extends Figura2D_v5 {
    public String cadena;

    public Triangulo_v5(String cadena, double ancho, double alto) {
        super(ancho, alto);
        this.cadena = cadena;
    }

    public Triangulo_v5() {
        super();
        this.cadena = null;
    }

    public Triangulo_v5(double lado) {
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
