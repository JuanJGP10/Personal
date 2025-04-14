package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeros[] = new int[20];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();
        }
        int negativos = 0;
        int positivos = 0;
        for (int i : numeros) {
            if (i < 0)
                negativos += i;
            if (i >= 0)
                positivos += i;
        }
        System.out.println(positivos);
        System.out.println(negativos);
        scanner.close();
    }
}
