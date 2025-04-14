package programacion.tema9.MaratonEjercicios.ej92;

public class Programa_v2 {
    public static void main(String[] args) {
        Triangulo_v2 triangulo = new Triangulo_v2();
        triangulo.setAncho(8.9);
        triangulo.setAlto(5.6);
        triangulo.cadena = "escaleno";
        System.out.println(triangulo.area());
        triangulo.verEstilo();
        triangulo.verDim();
    }
}
