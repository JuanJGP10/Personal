package programacion.tema10.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /**
         * 3. Implementa un programa que cree un vector tipo double de tamaño 5 y luego,
         * utilizando un bucle, pida cinco valores por teclado y los introduzca en el
         * vector.
         * Tendrás que manejar la/las posibles excepciones y seguir pidiendo valores
         * hasta
         * rellenar completamente el vector.
         */

        Scanner scanner = new Scanner(System.in);
        double[] vector = new double[5];
        int indice = 0;
        System.out.println("Introduce 5 valores de tipo double:");

        while (indice < vector.length) {

            try {
                System.out.println("Valor " + indice + " : ");
                vector[indice] = scanner.nextDouble();
                indice++;
            } catch (InputMismatchException e) {
                System.err.println("Formato invalido");
                scanner.next();

            }

        }

        scanner.close();

        System.out.println("Valores introducidos en el vector:");
        for (double num : vector) {
            System.out.println(num);
        }
    }
}
