package programacion.tema10.Ejercicios.Ejercicio7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Gato> lista = new ArrayList<>();
        int indice = 0;
        while (indice < 5) {
            try {

                System.out.println("Nombre del gato: ");
                String nombre = scanner.nextLine();

                System.out.println("Edad del gato: ");
                int edad = scanner.nextInt();
                scanner.nextLine();

                lista.add(new Gato(edad, nombre));
                indice++;

            } catch (InputMismatchException ex) {
                System.err.println("Formato invalido");
                ex.printStackTrace();
                scanner.next();
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

        for (Gato gato : lista) {
            gato.imprimir();
        }

    }
}
