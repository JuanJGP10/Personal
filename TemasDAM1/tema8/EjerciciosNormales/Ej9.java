package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej9 {
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);
        // Creacion del array int longitud 100
        int numeros[] = new int[100];
        // Pedimos el valor N
        System.out.println("Dame un valor N");
        int valorN = scanner.nextInt();
        // bucle fori para asignar a cada valor del array un numero aleatorio entre el 1
        // y el 10
        for (int i = 0; i < numeros.length; i++) {
            int random = (int) (1 + Math.random() * 10);
            numeros[i] = random;
        }
        // declaramos contador
        int contador = 0;
        // bucle foreach que nos servira para saber cuantas veces el numero aleatorio de
        // cada valor del array coincide con N
        for (int d : numeros) {
            if (d == valorN)
                contador++;
        }
        // output del contador
        System.out.println(contador);
        scanner.close();

    }

}
