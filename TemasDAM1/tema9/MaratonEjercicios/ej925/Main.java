package programacion.tema9.MaratonEjercicios.ej925;

import java.util.Scanner;

import programacion.nomeacuerdo.nomeacuerdo;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PiezaAjedrez[][] tablero = new PiezaAjedrez[8][8];
        int columna = 0;

        System.out.println("Alfil o torre");
        String clase = scanner.nextLine();
        clase.toLowerCase();

        if (clase.contains("alfil")) {
            PiezaAlfil b = new PiezaAlfil(1, 1);

            do {
                mostrarTablero(tablero, b);
                System.out.println("A donde quieres mover tu pieza elegida");
                System.out.println("Fila: [1-8]");
                int fila = scanner.nextInt();
                System.out.println("Columna: [A-H]");
                columna = nomeacuerdo.pedirInt();
                b.mover(fila, columna);

            } while (columna != -1);

        } else {
            PiezaTorre k = new PiezaTorre(1, 1);
            do {
                mostrarTablero(tablero, k);
                System.out.println("A donde quieres mover tu pieza elegida");
                System.out.println("Fila: [1-8]");
                int fila = scanner.nextInt();
                System.out.println("Columna: [A-H]");
                columna = nomeacuerdo.pedirInt();
                k.mover(fila, columna);

            } while (columna != -1);

        }

    }

    private static void mostrarTablero(PiezaAjedrez[][] tablero, PiezaAjedrez pa) {
        PiezaAjedrez[][] piezas = new PiezaAjedrez[8][8];
        for (int i = 0; i < piezas.length; i++) {
            for (int j = 0; j < piezas.length; j++) {
                piezas[pa.fila - 1][pa.columna - 1] = pa;
                if (piezas[i][j] == pa) {
                    System.out.print("[P ]");
                } else {
                    System.out.printf("[  ]");
                }
            }
            System.out.println();
        }

    }
}
