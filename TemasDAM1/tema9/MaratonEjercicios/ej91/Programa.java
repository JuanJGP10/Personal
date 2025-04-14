package programacion.tema9.MaratonEjercicios.ej91;

public class Programa {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo();
        triangulo.alto = 5.6;
        triangulo.ancho = 8.9;
        triangulo.cadena = "escaleno";
        System.out.println(triangulo.area());
        triangulo.verEstilo();
        triangulo.verDim();
    }
}
