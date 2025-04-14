package programacion.tema8.EjerciciosNormales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Distribucion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Defino arraylist para guardar los 10000 numeros
        ArrayList<Integer> listaAleatorios = new ArrayList<>();
        int random = 0;
        // Bucle for para ir generando los numeros aleatorios entre el 1 y el 6
        // Y metiendolos al arraylist
        for (int i = 0; i <= 10000; i++) {

            random = ThreadLocalRandom.current().nextInt(1, 7);
            listaAleatorios.add(i, random);
        }
        // Bucle for que me va diciendo cuantas veces aparece cada numero con el
        // Collections.frequency
        for (int i = 1; i < 7; i++) {
            System.out.println(
                    "Numero " + i + " aparece estas veces = " + Collections.frequency(listaAleatorios, i));

        }
        // Arraylist que guardara el numero total de veces que sale cada numero
        ArrayList<Integer> frecuencias = new ArrayList<>();
        // Bucle for que ira recogiendo los valores de las veces que sale cada numero y
        // guardandolo en el arraylist
        for (int i = 1; i < 7; i++) {
            int frecuencia = Collections.frequency(listaAleatorios, i);
            frecuencias.add(frecuencia);
        }

        // Sacamos el indices para decir por pantalla que numero sale tantas veces
        int indiceNumeroMax = frecuencias.indexOf(Collections.max(frecuencias));
        int indiceNumeroMin = frecuencias.indexOf(Collections.min(frecuencias));

        // Le sumo 1 para que empiece por 1 y no por 0
        System.out.println("El numero que mas aparece es el " + (indiceNumeroMax + 1)
                + ", aparece un total de " + Collections.max(frecuencias) + " veces");

        System.out.println("El numero que menos aparece es el " + (indiceNumeroMin + 1)
                + ", aparece un total de " + Collections.min(frecuencias) + " veces");
        // Diferencia
        System.out.println(
                "La diferencia es de " + (Collections.max(frecuencias) - Collections.min(frecuencias)) + " veces");

        scanner.close();
    }
}