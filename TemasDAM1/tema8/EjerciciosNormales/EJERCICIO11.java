package programacion.tema8.EjerciciosNormales;

import java.util.concurrent.ThreadLocalRandom;

public class EJERCICIO11 {
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(0, 2);
                System.out.printf("[%d]", matriz[i][j]);
            }
            System.out.println();
        }

        int contadorLineas0 = contarLineas(matriz, 0);
        System.out.println("Numero de 3 en rayas de 0's = " + contadorLineas0);
        int contadorLineas1 = contarLineas(matriz, 1);
        System.out.println("Numero de 3 en rayas de 1's = " + contadorLineas1);

        if (contadorLineas0 > contadorLineas1)
            System.out.println("Gana 0");
        else if (contadorLineas1 > contadorLineas1)
            System.out.println("Gana 1");
        else
            System.out.println("Empate");

    }

    private static int contarLineas(int[][] matriz, int valor) {
        int contador = 0;
        // Filas
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == valor && matriz[i][1] == valor && matriz[i][2] == valor) {
                contador++;
            }
        }
        // columnas
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[0][i] == valor && matriz[1][i] == valor && matriz[2][i] == valor) {
                contador++;
            }
        }

        // diagonales
        if (matriz[0][0] == valor && matriz[1][1] == valor && matriz[2][2] == valor) {
            contador++;
        }
        if (matriz[2][0] == valor && matriz[1][1] == valor && matriz[0][2] == valor) {
            contador++;
        }
        return contador;
    }
}