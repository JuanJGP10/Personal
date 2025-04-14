package programacion.tema8.EjerciciosNormales;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ej18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int array[] = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        Arrays.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
        scanner.close();
    }
}
