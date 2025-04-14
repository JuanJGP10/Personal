package programacion.tema9.MaratonEjercicios.ej918;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ingrese un número cualquiera:");
        int num1 = Consola.leerEntero();

        int num2 = Consola.leerEntero("Introduzca su edad:");

        int num3 = Consola.leerEntero("Introduzca su edad entre 0 y 120:", 0, 120);

        System.out.println("Introduzca un número entre 10 y 50:");
        int num4 = Consola.leerEntero(10, 50);

        System.out.println("Valores ingresados: " + num1 + ", " + num2 + ", " + num3 + ", " + num4);
    }
}
