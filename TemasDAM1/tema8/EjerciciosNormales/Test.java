package programacion.tema8.EjerciciosNormales;

import java.util.Scanner;

public class Test {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String var3 = pedirString();
        System.out.println(var3);
    }

    public static double pedirDouble() {
        String valor;

        System.out.println("Volvere a preguntar si no es un double");
        do {
            valor = scanner.nextLine();
        } while (!valor.matches("\\d+([,]\\d+)?"));
        valor = valor.replace(',', '.');
        return Double.parseDouble(valor);
    }

    public static int pedirInt() {
        String valor;

        System.out.println("Volvere a preguntar si no es un int");
        do {
            valor = scanner.nextLine();
        } while (!valor.matches("\\d+"));

        return Integer.parseInt(valor);
    }

    public static String pedirString() {
        String valor;

        System.out.println("Volvere a preguntar si no son solo letras");
        do {
            valor = scanner.nextLine();
        } while (!valor.matches("[A-za-z(\s)?]+"));

        return valor;
    }

}
