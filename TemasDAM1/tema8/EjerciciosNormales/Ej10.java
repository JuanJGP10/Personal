package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej10 {
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame N");
        int n = scanner.nextInt();
        // Creacion array double con longitud n
        double alturas[] = new double[n];
        // bucle fori para asignar las alturas en el array
        for (int i = 0; i < alturas.length; i++) {
            alturas[i] = scanner.nextDouble();
        }
        // declaracion de variables
        double maximo = alturas[0];
        double minimo = alturas[0];
        double alturaMedia = 0;
        double suma = 0;
        // bucle foreach para leer el array y ver la maxima y minima ademas de calcular
        // la suma
        // de las alturas para hacer la media
        for (double d : alturas) {
            if (d > maximo)
                maximo = d;
            if (d < minimo)
                minimo = d;
            suma += d;
        }
        // output de la altura maxima y minima
        System.out.println("Altura maxima = " + maximo);
        System.out.println("Altura minima = " + minimo);

        // calculo de la media
        alturaMedia = suma / alturas.length;
        // declaracion de variables
        int encimaMedia = 0;
        int abajoMedia = 0;
        // bucle foreach para leer el array y determinar la cantidad de personas por
        // encima y por debajo de la media
        for (double d : alturas) {
            if (d > alturaMedia)
                encimaMedia++;
            if (d < alturaMedia)
                abajoMedia++;
        }
        // output de la altura media y los contadores de personas por debajo/encima de
        // la media
        System.out.println("Media = " + alturaMedia);
        System.out.println("Personas por debajo de la media = " + abajoMedia);
        System.out.println("Personas por encima de la media = " + encimaMedia);

        scanner.close();
    }

}
