package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("N personas");
        int n = scanner.nextInt();

        int matrix[][] = new int[n][2];

        int salarioMedioHombre = 0;
        int contadorHombres = 0;
        int salarioMedioMujer = 0;
        int contadorMujeres = 0;

        for (int i = 0; i < matrix.length; i++) {

            System.out.println("// Datos persona " + (i + 1) + "//");

            for (int j = 0; j < matrix[i].length; j++) {

                if (j == 0) {
                    do {
                        System.out.println("Genero(0 varon/1 mujer) = ");

                        matrix[i][j] = scanner.nextInt();
                    } while (matrix[i][j] != 1 && matrix[i][j] != 0);

                }

                if (j == 1) {
                    System.out.println("Sueldo = ");
                    matrix[i][j] = scanner.nextInt();
                    if (matrix[i][j - 1] == 1) {
                        salarioMedioMujer += matrix[i][j];
                        contadorMujeres++;
                    } else {
                        salarioMedioHombre += matrix[i][j];
                        contadorHombres++;
                    }

                }

            }

        }

        if (contadorHombres > 0) {
            salarioMedioHombre = salarioMedioHombre / contadorHombres;
        }
        if (contadorMujeres > 0) {
            salarioMedioMujer = salarioMedioMujer / contadorMujeres;
        }

        System.out.println("Media salarial hombres = " + salarioMedioHombre);
        System.out.println("Media salarial mujeres = " + salarioMedioMujer);
        scanner.close();
    }
}
