package programacion.tema8.Receta;

import java.util.ArrayList;
import java.util.Scanner;

public class RecetaMain {
    public static void main(String[] args) {
        pedirDatosReceta();
    }

    private static void pedirDatosReceta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre de la receta: ");
        String nombre = scanner.nextLine();
        System.out.println("Elaboracion de la receta: ");
        String elaboracion = scanner.nextLine();
        System.out.println("Duracion de la receta: ");
        int duracion = scanner.nextInt();
        System.out.println("Ingredientes en total de la receta: ");
        int totalIngredientes = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Ingrediente> ingredientes = new ArrayList<>();

        for (int i = 0; i < totalIngredientes; i++) {
            System.out.println("Nombre del ingrediente:");
            String nombreIng = scanner.nextLine();

            System.out.println("Cantidad:");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Unidades:");
            String unidades = scanner.nextLine();

            Ingrediente ing = new Ingrediente(nombreIng, cantidad, unidades);
            ingredientes.add(ing);
        }

        Receta receta = new Receta(nombre, elaboracion, duracion, ingredientes);
        receta.imprimirReceta();
        scanner.close();
    }

}
