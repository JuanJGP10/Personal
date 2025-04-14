package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame P(desde)");
        int p = scanner.nextInt();
        System.out.println("Dame Q(hasta)");
        int q = scanner.nextInt();
        int numeros[] = new int[q - p];
        int contador = p;
        for (int i = 0; i < q - p; i++) {
            numeros[i] = contador;
            contador++;
        }

        for (int i : numeros) {
            System.out.println(i);
        }
        scanner.close();
    }

}
