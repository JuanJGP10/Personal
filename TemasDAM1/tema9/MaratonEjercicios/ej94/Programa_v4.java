package programacion.tema9.MaratonEjercicios.ej94;

public class Programa_v4 {
    public static void main(String[] args) {
        Triangulo_v4 triangulo = new Triangulo_v4("escaleno", 8.9, 5.8);

        System.out.println(triangulo.area());
        triangulo.verEstilo();
        triangulo.verDim();

        // Ahora funciona porque tenemos un constructor de la clase padre para asignar
        // los valores ancho y alto
    }
}
