package programacion.tema9.Ejercicio6;

import java.util.ArrayList;

public class ProgramaFiguras {
    public static void main(String[] args) {
        ArrayList<iFigura2D> figuras = new ArrayList<>();

        figuras.add(new Cuadrado(4));
        figuras.add(new Rectangulo(3, 5));
        figuras.add(new Triangulo(4, 6));
        figuras.add(new Circulo(3));

        System.out.println("Figuras originales:");
        for (iFigura2D figura : figuras) {
            figura.imprimir();
        }

        System.out.println("\nEscalando figuras por 2:");
        for (iFigura2D figura : figuras) {
            figura.escalar(2);
            figura.imprimir();
        }

        System.out.println("\nEscalando figuras por 0.3:");
        for (iFigura2D figura : figuras) {
            figura.escalar(0.3);
            figura.imprimir();
        }
    }
}
