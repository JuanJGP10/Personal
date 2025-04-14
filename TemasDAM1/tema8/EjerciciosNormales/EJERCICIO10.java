package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class EJERCICIO10 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (!args[0].matches("\\d+") || !args[1].matches("\\d+") || args.length != 2) {
            System.out.println("Parametros inadecuados");
        }
        int[][] matriz = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(1, 21);
                System.out.printf("[%3d]", matriz[i][j]);
            }
            System.out.println();
        }
        int contadorFila = 0;
        System.out.println("Dame el valor V donde te dire cuantos numero de la matriz son multiplos de este valor");
        int v = scanner.nextInt();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % v == 0) {
                    contadorFila++;
                }
            }
            System.out.println("Fila " + i + ": " + contadorFila);
            contadorFila = 0;
        }

    }
}
