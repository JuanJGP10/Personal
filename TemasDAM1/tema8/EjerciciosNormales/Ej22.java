package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrix[][] = new int[10][10];
        scanner.close();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
