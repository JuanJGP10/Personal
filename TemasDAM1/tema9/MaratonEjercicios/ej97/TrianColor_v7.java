package programacion.tema9.MaratonEjercicios.ej97;

public class TrianColor_v7 extends Triangulo_v7 {
    private String color;

    public TrianColor_v7(String cadena, double ancho, double alto, String color) {
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
