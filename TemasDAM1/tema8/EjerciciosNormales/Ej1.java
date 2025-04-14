package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        /*
         * Crea un programa que pida diez números reales por teclado, los almacene en
         * un
         * array, y luego muestre todos sus valores.
         */
        Scanner scanner = new Scanner(System.in);
        int numero[] = new int[10];

        for (int i = 0; i < numero.length; i++) {
            numero[i] = scanner.nextInt();
        }

        for (int numbers : numero) {
            System.out.println(numbers);
        }

        scanner.close();
    }
}
