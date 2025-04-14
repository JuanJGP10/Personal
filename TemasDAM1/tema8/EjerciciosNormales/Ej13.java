package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame I(saltos de valores)");
        int I = scanner.nextInt();
        System.out.println("Dame V(valor inicial)");
        int v = scanner.nextInt();
        System.out.println("Dame N(tamaño del array)");
        int n = scanner.nextInt();

        int array[] = new int[n];
        int sumador = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = v + sumador;
            sumador += I;
        }
        for (int j : array) {
            System.out.println(j);
        }
        scanner.close();
    }
}
