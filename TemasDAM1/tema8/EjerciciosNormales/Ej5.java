package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numeros[] = new double[20];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();

        }
        double suma = 0;
        for (double d : numeros) {
            suma += d;
        }
        System.out.println(suma / numeros.length);
        scanner.close();
    }
}
