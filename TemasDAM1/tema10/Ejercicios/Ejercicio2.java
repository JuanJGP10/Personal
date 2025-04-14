package programacion.tema10.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 2. Implementa un programa que pida dos valores int A y B utilizando un
 * nextInt() (de
 * Scanner), calcule A/B y muestre el resultado por pantalla. Se deberán tratar
 * de
 * forma independiente las dos posibles excepciones, InputMismatchException y
 * ArithmeticException, mostrando en cada caso un mensaje de error diferente.
 * 
 */
public class Ejercicio2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce A y B");
        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int div = a / b;
            System.out.println("Division = " + div);

        } catch (InputMismatchException miss) {
            System.err.println("Variable no valida");
            miss.printStackTrace();
        } catch (ArithmeticException art) {
            System.err.println("No se puede dividir entre 0");
            art.printStackTrace();
        }

    }
}
