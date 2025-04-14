package programacion.tema9.MaratonEjercicios.ej92;

public class Triangulo_v2 extends Figura2D_v2 {
    public String cadena;

    public double area() {
        return (getAncho() * getAlto()) / 2;
    }

    public void verEstilo() {
        System.out.println(cadena);
    }
}
