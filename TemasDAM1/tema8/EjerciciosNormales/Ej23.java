package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tamaño matriz = ");
        System.out.println("N(Filas)");
        int n = scanner.nextInt();
        System.out.println("M(Columanas)");
        int m = scanner.nextInt();

        int matrix[][] = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int contador = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0)
                    contador++;
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Valores mayores que cero en la amtriz = " + contador);
        scanner.close();
    }
}
