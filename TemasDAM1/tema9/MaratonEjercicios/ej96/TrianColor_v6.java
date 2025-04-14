package programacion.tema9.MaratonEjercicios.ej96;

public class TrianColor_v6 extends Triangulo_v6 {
    private String color;

    public TrianColor_v6(String cadena, double ancho, double alto, String color) {
        super(cadena, ancho, alto);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
