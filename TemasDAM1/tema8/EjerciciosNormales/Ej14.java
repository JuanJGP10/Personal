package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej14 {
    public static void main(String[] args) {
        int array[] = new int[55];
        Scanner scanner = new Scanner(System.in);
        int contador = 1;
        int contadorC = 0;

        for (int i = 0; i < array.length; i++) {
            if (contador == 11)
                break;
            array[i] = contador;
            contadorC++;
            if (contadorC == contador) {
                contadorC = 0;
                contador++;
            }

        }

        // int contador = 0;
        // for (int i = 1; i <= 10; i++) {
        // for (int j = 0; j < i; j++) {
        // array[contador] = i;
        // contador++;
        // }
        // }

        for (int i : array) {
            System.out.println(i);
        }
        scanner.close();
    }
}
