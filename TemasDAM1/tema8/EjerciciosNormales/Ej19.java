package programacion.tema8.EjerciciosNormales;

import java.util.Arrays;
import java.util.Scanner;

public class Ej19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[8];

        for (int i = 0; i < array.length; i++) {
            do {
                array[i] = scanner.nextInt();
            } while (array[i] < 999 && array[i] > 2801);
        }
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
        scanner.close();
    }
}
