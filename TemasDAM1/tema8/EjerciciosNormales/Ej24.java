package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int notas[][] = new int[4][5];
        int notaMaxima = Integer.MIN_VALUE;
        int notaMinima = Integer.MAX_VALUE;
        int media = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.println("//Notas alumno " + (i + 1) + "//");

            for (int j = 0; j < notas[i].length; j++) {
                System.out.println("Nota Asignatura " + (j + 1) + " = ");

                notas[i][j] = scanner.nextInt();

                if (notaMaxima < notas[i][j])
                    notaMaxima = notas[i][j];
                if (notaMinima > notas[i][j])
                    notaMinima = notas[i][j];
                media += notas[i][j];
            }

            media = media / 5;
            System.out.println("Nota maxima del alumno " + (i + 1) + " = " + notaMaxima);
            System.out.println("Nota minima del alumno " + (i + 1) + " = " + notaMinima);
            System.out.println("Nota media del alumno " + (i + 1) + " = " + media);
            notaMaxima = Integer.MIN_VALUE;
            notaMinima = Integer.MAX_VALUE;
            media = 0;

        }

        scanner.close();
    }
}
