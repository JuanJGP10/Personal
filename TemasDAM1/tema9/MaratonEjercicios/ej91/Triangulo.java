package programacion.tema9.MaratonEjercicios.ej91;

public class Triangulo extends Figura2D {
    public String cadena;

    public double area() {
        return (ancho * alto) / 2;
    }

    public void verEstilo() {
        System.out.println(cadena);
    }
}
