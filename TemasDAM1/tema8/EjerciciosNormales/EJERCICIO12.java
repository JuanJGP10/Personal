package programacion.tema8.EjerciciosNormales;

import java.util.concurrent.ThreadLocalRandom;

public class EJERCICIO12 {
    public static void main(String[] args) {
        int[][] matriz = crearTablero(4, 4, 7);
        tirada(matriz, 1, 1);
        mostrarMatriz(matriz, true);
        rellenarMatriz(matriz);
        mostrarMatriz(matriz, true);
        mostrarMatriz(matriz, false);

    }

    public static int[][] crearTablero(int filas, int columnas, int minas) {

        if (filas <= 0 || columnas <= 0 || minas > filas * columnas)
            return null;

        int[][] matriz = new int[filas][columnas];
        int minasPuestas = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }

        while (minasPuestas < minas) {
            int minaFila = ThreadLocalRandom.current().nextInt(0, filas);
            int minaColumna = ThreadLocalRandom.current().nextInt(0, columnas);

            if (matriz[minaFila][minaColumna] != -1) {
                matriz[minaFila][minaColumna] = -1;
                minasPuestas++;
            }

        }

        return matriz;
    }

    public static boolean tirada(int[][] matriz, int fila, int columna) {
        if (matriz[fila][columna] == 0)
            return true;
        else if (matriz[fila][columna] == -1) {
            matriz[fila][columna] = -2;
            return false;
        } else {
            return false;
        }

    }

    public static void mostrarMatriz(int[][] matriz, boolean completa) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (completa) {
                    System.out.printf("[%3d] ", matriz[i][j]);
                } else {
                    if (matriz[i][j] == -2)
                        System.out.printf("[ X ]");
                    else
                        System.out.printf("[   ]");
                }

            }
            System.out.println();
        }
        System.out.println("_________________________________________________________");

    }

    public static void rellenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    // ARRIBA
                    if (i - 1 >= 0 && j - 1 >= 0 && matriz[i - 1][j - 1] == -1)
                        matriz[i][j]++;
                    if (i - 1 >= 0 && matriz[i - 1][j] == -1)
                        matriz[i][j]++;
                    if (i - 1 >= 0 && j + 1 < matriz.length && matriz[i - 1][j + 1] == -1)
                        matriz[i][j]++;
                    // LADOS
                    if (j - 1 >= 0 && matriz[i][j - 1] == -1)
                        matriz[i][j]++;
                    if (j + 1 < matriz.length && matriz[i][j + 1] == -1)
                        matriz[i][j]++;
                    // ABAJO
                    if (i + 1 < matriz.length && j - 1 >= 0 && matriz[i + 1][j - 1] == -1)
                        matriz[i][j]++;
                    if (i + 1 < matriz.length && matriz[i + 1][j] == -1)
                        matriz[i][j]++;
                    if (i + 1 < matriz.length && j + 1 < matriz.length && matriz[i + 1][j + 1] == -1)
                        matriz[i][j]++;
                }
            }
        }
    }
}
