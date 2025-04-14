package programacion.tema9.MaratonEjercicios.ej913;

import java.util.ArrayList;

public class Programa_v9 {
    public static void main(String[] args) {

        ArrayList<Figura2D_v9> figuras = new ArrayList<>();

        figuras.add(new Rectangulo_v9(5.0, 10.0, "Rectángulo 1"));
        figuras.add(new Triangulo_v9("Base", 6.0, 8.0, "Triángulo 1"));
        figuras.add(new TrianColor_v9("Base", 7.0, 9.0, "Rojo", "Triángulo de Color 1"));

        for (Figura2D_v9 figura : figuras) {
            System.out.println("Figura: " + figura.getNombre() + " - Precio: " + figura.precio(10) + " euros");

        }
    }
}
