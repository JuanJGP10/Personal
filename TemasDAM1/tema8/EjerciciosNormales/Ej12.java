package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Ej12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array1[] = new int[10];
        char opcion;
        int v = 0;
        int p = 0;
        do {
            System.out.println("a.Mostrar indices\nb.Introducir valor\nc.Salir");
            opcion = scanner.nextLine().charAt(0);

            switch (opcion) {
                case 'a':
                    for (int i : array1) {
                        System.out.println(i);
                    }
                    break;
                case 'b':
                    System.out.println("Dame P(posicion del array a cambiar)");
                    p = scanner.nextInt();
                    System.out.println("Dame V(valor a cambiar en el array)");
                    v = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < array1.length; i++) {
                        if (i == p) {
                            array1[i] = v;
                        }
                    }

                    System.out.println("Resultado =");
                    for (int i : array1) {
                        System.out.println(i);
                    }

                    break;
                case 'c':
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion nno valida. ");
                    break;
            }
        } while (opcion != 'c');
        scanner.close();
    }

}
