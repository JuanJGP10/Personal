package programacion.tema10.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vector = new int[ThreadLocalRandom.current().nextInt(1, 101)];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = ThreadLocalRandom.current().nextInt(11);
        }

        int number = 0;
        while (true) { // Con while (true) creo un bucle infinito
            try {
                System.out.println("Valor para ver: ");
                number = scanner.nextInt();
                if (number < 0)
                    break; // Break para salir del bucle si el indice del vector es negativo
                System.out.println("Valor correspondiente: " + vector[number]);
            } catch (InputMismatchException e) {
                System.err.println("Formato de indice invalido");
                scanner.next(); // Si no limpias el buffer lee el caracter infinitamente
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.err.println("Error: Índice fuera del rango válido (0 - " + (vector.length - 1) + ").");
                // No hace falta limpiar el buffer
                exc.printStackTrace();
            }
        }
    }
}
