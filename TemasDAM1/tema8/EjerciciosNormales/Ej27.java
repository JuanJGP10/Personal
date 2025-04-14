package programacion.tema8.EjerciciosNormales;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(divisores(100));
        scanner.close();
    }

    public static ArrayList divisores(int numero) {
        ArrayList lista = new ArrayList<>();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                lista.add(i);
            }
        }
        return lista;
    }
}
