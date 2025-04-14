package programacion.tema8.ExamenArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class NumerosLoto {

    public static void main(String[] args) {

        // Se declara array
        int[] combinacion = new int[6];

        combinacion = generarCombinacion();

        // Se muestra el array
        for (int i = 0; i < combinacion.length; i++) {
            System.out.printf("[%3d]", combinacion[i]);
        }

    }

    public static int[] generarCombinacion() {

        int[] combinacion = new int[6];
        // Lista aleatorios donde se guardan los 5 millones de numero aleatorios
        ArrayList<Integer> aleatorios = new ArrayList<>();

        // Lista de frecuencias donde se almacenaran las frecuencias de cada numero
        ArrayList<Integer> frecuencias = new ArrayList<>();

        // Bucle for para guardar los 5 millones de numero en la lista
        for (int i = 0; i < 5000000; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 50);
            aleatorios.add(random);
        }

        // bucle for para almacenar las frecuencias de cada numero en orden
        for (int i = 0; i < 50; i++) {
            int frecuencia = Collections.frequency(aleatorios, i);
            frecuencias.add(frecuencia);
        }
        // bucle for para seleccionar los 6 numeros que mas aparecen (hay q tener en
        // cuenta q la ista empieza por 0 y no por 1, entonces al indice hay q sumarle
        // 1)
        for (int i = 0; i < 6; i++) {
            int indiceMaximo = frecuencias.indexOf(Collections.max(frecuencias));
            combinacion[i] = indiceMaximo + 1;
            // Establecemos el indice maximo a -1 para 1 no vuelva a aparecer
            frecuencias.set(indiceMaximo, -1);
        }

        // Ordenamos de menor a mayor
        Arrays.sort(combinacion);

        // Devolvemos combinacion
        return combinacion;
    }

}
