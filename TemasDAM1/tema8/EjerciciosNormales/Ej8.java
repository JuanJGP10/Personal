package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej8 {
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);
        // creacion array double con longitud 100
        double numeros[] = new double[100];
        // pedimos por teclado la variable R
        System.out.println("Dame un valor R");
        double valorR = scanner.nextDouble();
        // contador para ver cuantos numeros se pasan de R
        int contador = 0;
        // bucle fori para asignar el math random a cada valor del array
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Math.random();
        }
        // bucle foreach para leer el array e incrementar el contador cada vez que el
        // valor del array sea mayor que R
        for (double d : numeros) {
            if (d > valorR)
                contador++;
        }
        // output del contador
        System.out.println(contador);
        scanner.close();
    }

}
