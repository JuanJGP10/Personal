package programacion.tema9.MaratonEjercicios.ej913;

public class TrianColor_v9 extends Triangulo_v9 {
    private String color;

    public TrianColor_v9(String cadena, double ancho, double alto, String color, String nombre) {
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
