package programacion.tema9.MaratonEjercicios.ej93;

public class Triangulo_v3 extends Figura2D_v3 {
    public String cadena;

    public Triangulo_v3(String cadena, double ancho, double alto) {
        super();
        this.cadena = cadena;
    }

    public double area() {
        return (getAncho() * getAlto()) / 2;
    }

    public void verEstilo() {
        System.out.println(cadena);
    }
}
