package programacion.tema10.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 1. Implementa un programa que pida al usuario un valor entero A utilizando un
 * nextInt() (de Scanner) y luego muestre por pantalla el mensaje “Valor
 * introducido:
 * …”. Se deberá tratar la excepción InputMismatchException que lanza nextInt()
 * cuando no se introduce un entero válido. En tal caso se mostrará el mensaje
 * “Valor
 * introducido incorrecto”
 */
public class Ejercicio1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Dame un valor entero");

        try {
            int valor = sc.nextInt();
            System.out.println("Valor introducido: " + valor);
        } catch (InputMismatchException e) {
            System.err.println("Valor no valido");
            e.printStackTrace();
        }
    }
}
