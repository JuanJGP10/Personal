package programacion.tema9.MaratonEjercicios.ej94;

public class Triangulo_v4 extends Figura2D_v4 {
    public String cadena;

    public Triangulo_v4(String cadena, double ancho, double alto) {
        super(ancho, alto);
        this.cadena = cadena;
    }

    public double area() {
        return (getAncho() * getAlto()) / 2;
    }

    public void verEstilo() {
        System.out.println(cadena);
    }
}
