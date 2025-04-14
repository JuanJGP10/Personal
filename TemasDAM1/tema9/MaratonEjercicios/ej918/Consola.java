package programacion.tema9.MaratonEjercicios.ej918;

import java.util.Scanner;

public class Consola {
    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        int numero = scanner.nextInt();
        return numero;
    }

    public static int leerEntero() {
        int numero = scanner.nextInt();
        return numero;
    }

    public static int leerEntero(String mensaje, int rango1, int rango2) {
        int numero = 0;
        System.out.println(mensaje);
        do {
            numero = scanner.nextInt();
            if (numero < rango1 || numero > rango2) {
                System.out.println("Error: el número debe estar entre " + rango1 + " y " + rango2);
            }
        } while (numero < rango1 || numero > rango2);
        return numero;
    }

    public static int leerEntero(int rango1, int rango2) {
        int numero = 0;
        do {
            numero = scanner.nextInt();
            if (numero < rango1 || numero > rango2) {
                System.out.println("Error: el número debe estar entre " + rango1 + " y " + rango2);
            }
        } while (numero < rango1 || numero > rango2);
        return numero;

    }
}
