package programacion.tema8.EjerciciosNormales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class combinacionMilagrosa {
    public static void main(String[] args) {
        int[] combinacion = new int[5];
        combinacion = combinacionMilagro();
        System.out.println("Combinacion milagrosa:");
        for (int i = 0; i < combinacion.length; i++) {
            System.out.printf("[%3d]", combinacion[i]);
        }
    }

    public static int[] combinacionMilagro() {
        int[] combinacion = new int[5];
        ArrayList<Integer> aleatorios = new ArrayList<>();
        ArrayList<Integer> frecuencias = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 50);
            aleatorios.add(random);
        }

        for (int i = 1; i <= 49; i++) {
            int frecuencia = Collections.frequency(aleatorios, i);
            frecuencias.add(frecuencia);

        }

        for (int i = 0; i < 5; i++) {

            int indiceMAximo = frecuencias.indexOf(Collections.max(frecuencias));
            combinacion[i] = indiceMAximo + 1;
            frecuencias.set(indiceMAximo, -1);
        }

        Arrays.sort(combinacion);
        return combinacion;
    }
}
