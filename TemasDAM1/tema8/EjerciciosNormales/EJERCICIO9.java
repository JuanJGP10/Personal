package programacion.tema8.EjerciciosNormales;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class EJERCICIO9 {
    public static void main(String[] args) {
        int[][] matriz = new int[8][5];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(0, 4);
                System.out.printf("[%2d]", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println("Linea en las filas: " + lineas(matriz));
    }

    public static ArrayList<Integer> lineas(int matriz[][]) {
        ArrayList<Integer> lista = new ArrayList<>();
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > 0) {
                    contador++;
                }
            }
            if (contador == matriz[i].length) {
                lista.add(i);
            }
            contador = 0;

        }
        return lista;
    }
}
