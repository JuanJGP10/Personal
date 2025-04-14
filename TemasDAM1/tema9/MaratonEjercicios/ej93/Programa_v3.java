package programacion.tema9.MaratonEjercicios.ej93;

public class Programa_v3 {
    public static void main(String[] args) {
        Triangulo_v3 triangulo = new Triangulo_v3("escaleno", 8.9, 5.8);

        System.out.println(triangulo.area());
        triangulo.verEstilo();
        triangulo.verDim();
    }
}
