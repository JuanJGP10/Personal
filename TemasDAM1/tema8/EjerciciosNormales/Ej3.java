package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej3 {

    /*
     * 3. Crea un programa que pida diez números reales por teclado, los almacene en
     * un
     * array, y luego lo recorra para averiguar el máximo y mínimo y mostrarlos por
     * pantalla.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeros[] = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();
        }
        int maximo = 0;
        int minimo = 0;
        for (int i : numeros) {
            if (i > maximo)
                maximo = i;
            if (i < minimo)
                minimo = i;
        }
        System.out.println(maximo);
        System.out.println(minimo);
    }
}
