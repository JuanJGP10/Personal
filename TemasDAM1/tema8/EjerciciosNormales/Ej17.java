package programacion.tema8.EjerciciosNormales;

import java.util.Arrays;
import java.util.Scanner;

public class Ej17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[10];
        int array2[] = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            array2[i] = scanner.nextInt();
        }

        if (Arrays.equals(array, array2)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
        scanner.close();
    }
}
