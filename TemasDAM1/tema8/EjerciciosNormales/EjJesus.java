package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class EjJesus {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int array1[] = new int[1];
        boolean cero = false;
        int cont = 0;

        while (!cero) {
            // Introduccion de valor
            array1[cont] = scanner.nextInt();
            // Controla si el valor introducido es 0 sale del bucle
            if (array1[cont] == 0) {
                cero = true;
                break;
            }
            // Creacion del segundo array que en cada iteracion sera una posicion mas grande
            // que la anterior
            int array2[] = new int[array1.length + 1];
            // Bucle for para copiar el array1 en el array2
            for (int i = 0; i < array1.length; i++) {
                array2[i] = array1[i];
            }
            // Igualamos el array1 al array2, de esta manera el array1 sera igual que antes
            // pero una posicion mas grande
            // Esto nos permitira crear un nuevo array2 con mas capacidad en cada iteracion
            array1 = array2;
            // Incrementamos contador que señala el indice del array
            cont++;
        }

        System.out.println("-----------------------------------------");
        // Imprimimos el array
        for (int i : array1) {
            System.out.println(i);
        }

        scanner.close();
    }
}
