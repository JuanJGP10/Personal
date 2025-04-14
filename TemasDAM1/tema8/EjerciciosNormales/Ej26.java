package programacion.tema8.EjerciciosNormales;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej26 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList list = new ArrayList<>();
        char opcion;
        double altura = 0;
        do {
            System.out.println(
                    "a)Añadir altura \nb)Mostrar lista \nc)Elimina por posicion(se le pasa un parametro altura y las elimina de la lsita) \nd)Elimina por valor(se le pasa un parametro) \ne)Ordenar lista \nf)Salir");
            opcion = scanner.nextLine().charAt(0);
            switch (opcion) {
                case 'a':
                    do {
                        System.out.println("Dame la altura (debe ser entre 0.50 y 2.50)");

                        altura = scanner.nextDouble();
                        scanner.nextLine();
                    } while (altura < 0.50 || altura > 2.50);
                    list.add(altura);
                    break;
                case 'b':
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("Objeto " + (i + 1) + " = " + list.get(i));
                    }
                    break;
                case 'c':
                    int posicion = 0;
                    System.out.println("Dame una posicion y la borro");
                    do {
                        posicion = scanner.nextInt();

                    } while (posicion < 0 || posicion > list.size());
                    scanner.nextLine();
                    for (int i = 0; i < list.size(); i++) {
                        if (posicion == i)
                            list.remove(i);
                    }
                    break;
                case 'd':
                    double valor = 0;
                    int contador = 0;
                    valor = scanner.nextDouble();
                    scanner.nextLine();
                    for (int i = 0; i < list.size(); i++) {
                        if (valor == (double) list.get(i)) {
                            list.remove(i);
                            contador++;
                        }
                    }
                    System.out.println("Eliminaciones = " + contador);

                    break;
                case 'e':
                    list.sort(null);
                    break;
                case 'f':
                    System.out.println("Saliendo");
                    break;
                default:
                    break;
            }
        } while (opcion != 'f');
        scanner.close();
    }
}
