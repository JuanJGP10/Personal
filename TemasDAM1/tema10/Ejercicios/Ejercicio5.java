package programacion.tema10.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p;
        int n;
        while (true) {
            try {
                System.out.println("Valor para meter en imprimir positivo:");
                p = scanner.nextInt();
                System.out.println("Valor para meter en imprimir negativo:");
                n = scanner.nextInt();
                if (n == 0 || p == 0)
                    break;
                imprimePositivo(p);
                imprimeNegativo(n);
            } catch (InputMismatchException exc) {
                System.err.println("Formato invalido");
                scanner.next();
                exc.printStackTrace();
            } catch (Exception exz) {
                System.err.println(exz.getMessage()); // Atrapamos la excepcion creada por nosotros y la mostramos con
                                                      // getMessage()
                exz.printStackTrace();
            }

        }
    }

    public static void imprimePositivo(int p) throws Exception {
        if (p < 0)
            throw new Exception("El valor debe ser positivo");
        else
            System.out.println("Valor positivo: " + p);
    }

    public static void imprimeNegativo(int n) throws Exception {
        if (n > 0)
            throw new Exception("El valor debe ser negativo");
        else
            System.out.println("Valor en negativo: " + n);

    }
}
