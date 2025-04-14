package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame N(tamaño array)");
        int n = scanner.nextInt();
        System.out.println("Dame M(valores del array)");
        int m = scanner.nextInt();

        int numeros[] = new int[n];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = m;
        }

        for (int i : numeros) {
            System.out.println(i);
        }
        scanner.close();
    }

}
