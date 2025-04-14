package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ej20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 100);

        }
        System.out.println("Dame el valor N y te dire si aparece en el array y cuantas veces");
        int n = scanner.nextInt();

        boolean aparece = false;

        int contador = 0;
        for (int i : array) {
            if (i == n) {
                aparece = true;
                contador++;
            }

        }
        System.out.println("El valor n aparece? = " + aparece + " -- Aparece esta catidad de veces = " + contador);
        scanner.close();
    }
}
