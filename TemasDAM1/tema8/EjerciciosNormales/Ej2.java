package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej2 {

    /*
     * 2. Crea un programa que pida diez números reales por teclado, los almacene en
     * un
     * array, y luego muestre la suma de todos los valores.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeros[] = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();
        }
        int suma = 0;
        for (int i : numeros) {
            suma += i;
        }
        System.out.println(suma);
        scanner.close();

    }
}
