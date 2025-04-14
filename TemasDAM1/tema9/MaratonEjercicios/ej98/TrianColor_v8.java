package programacion.tema9.MaratonEjercicios.ej98;

public class TrianColor_v8 extends Triangulo_v8 {
    private String color;

    public TrianColor_v8(String cadena, double ancho, double alto, String color, String nombre) {
        super(cadena, ancho, alto, nombre);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
