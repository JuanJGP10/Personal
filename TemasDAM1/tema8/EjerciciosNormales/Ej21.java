package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrix[][] = new int[5][5];
        int contador = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = contador;
                contador++;
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
