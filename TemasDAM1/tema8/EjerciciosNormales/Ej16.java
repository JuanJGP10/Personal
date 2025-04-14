package programacion.tema8.EjerciciosNormales;

import java.util.Arrays;

public class Ej16 {
    public static void main(String[] args) {
        int array[] = new int[55];
        int posiArray = 0;
        for (int i = 0; i <= 10; i++) {
            // desde la posicion del array en la que estamos hasta la posicion del array + i
            // (por ejemplo posicion 5 (pues habra que meter 5 cincos) posi = 5, i = 5)
            // (RANGO 5 hasta 5+5) y
            // con el ultimo argumento introducira el valor 5
            Arrays.fill(array, posiArray, posiArray + i, i);
            posiArray += i;
        }

        for (int i : array) {
            System.out.println(i);
        }

    }
}
