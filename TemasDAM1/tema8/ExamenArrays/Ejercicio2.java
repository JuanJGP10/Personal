package programacion.tema8.ExamenArrays;

import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio2 {
    public static void main(String[] args) {

        // creamos tablero
        int[][] matriz = crearTablero(3, 3);
        int lineas0 = numeroLineas(matriz, 0);
        int lineas1 = numeroLineas(matriz, 1);

        System.out.printf("""
                Lineas 0: %d  Lineas 1: %d

                """, lineas0, lineas1);

        if (lineas0 > lineas1)
            System.out.print("Lineas ganador 0");
        else if (lineas1 > lineas0)
            System.out.print("Lineas ganador 1");
        else
            System.out.print("Empate");

        System.out.println();

        mostrarMatriz(matriz);
    }

    // se rellena la matriz de numeros aleatorios entre 0 y 1
    public static int[][] crearTablero(int n, int m) {

        int[][] matriz = new int[n][m];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(0, 2);
            }
        }

        return matriz;
    }

    // Se muestra la matriz por pantalla
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("[%3d]", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
    }

    // [0,0][0,1][0,2]
    // [1,0][1,1][1,2]
    // [2,0][2,1][2,2]
    // Metodo que calcula el numero de lineas que hay en el tablero

    public static int numeroLineas(int[][] matriz, int numero) {

        if (matriz.length != matriz[0].length)
            return 0;

        int contadorRaya = 0;
        int contador = 0;
        int contadorJ = 0;
        // Lineas horizontales

        for (int i = 0; i < matriz.length; i++) {

            while (contadorJ < matriz.length) {
                if (matriz[i][contadorJ] == numero) {
                    contadorRaya++;
                    if (contadorRaya == matriz.length) {
                        contador++;
                    }
                }
                contadorJ++;
            }

            contadorJ = 0;
            contadorRaya = 0;
        }

        // Lineas verticales
        // [0,0][0,1][0,2][0,3]
        // [1,0][1,1][1,2][1,3]
        // [2,0][2,1][2,2][2,3]
        // [3,0][3,1][3,2][3,3]
        int contadorI = 0;
        for (int i = 0; i < matriz.length; i++) {
            while (contadorI < matriz.length) {
                if (matriz[contadorI][i] == numero) {
                    contadorRaya++;
                    if (contadorRaya == matriz.length) {
                        contador++;
                    }
                }
                contadorI++;
            }
            contadorRaya = 0;
            contadorI = 0;
        }
        // Diagonal principal
        int contadorDiagonalX = 0;
        int contadorDiagonalY = 0;

        while (contadorDiagonalX < matriz.length) {
            if (matriz[contadorDiagonalX][contadorDiagonalY] == numero) {
                contadorRaya++;
            }

            if (contadorRaya == matriz.length) {
                contador++;
            }
            contadorDiagonalX++;
            contadorDiagonalY++;
        }
        contadorRaya = 0;

        // Diagonal secundaria
        // [0,0][0,1][0,2][0,3]
        // [1,0][1,1][1,2][1,3]
        // [2,0][2,1][2,2][2,3]
        // [3,0][3,1][3,2][3,3]
        int contadorDiagonalSecundariaX = matriz.length - 1;
        int contadorDiagonalSecundariaY = 0;

        while (contadorDiagonalSecundariaY < matriz.length) {
            if (matriz[contadorDiagonalSecundariaX][contadorDiagonalSecundariaY] == numero) {
                contadorRaya++;
            }

            if (contadorRaya == matriz.length) {
                contador++;
            }
            contadorDiagonalSecundariaX--;
            contadorDiagonalSecundariaY++;
        }

        contadorRaya = 0;
        return contador;
    }
}
