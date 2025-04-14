package programacion.tema9.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Chatgpt para crear los objetos
        // Instancias de Planetas
        Astros tierra = new Planeta(6371, 24, 5.97e24, 15, 9.81, 149.6e6, 365.25, true, "Tierra");
        Astros marte = new Planeta(3389.5, 24.6, 6.39e23, -63, 3.71, 227.9e6, 687, true, "Marte");
        Astros jupiter = new Planeta(69911, 9.9, 1.898e27, -145, 24.79, 778.5e6, 4333, true, "Jupiter");
        Astros venus = new Planeta(6051.8, 243, 4.867e24, 464, 8.87, 108.2e6, 225, false, "Venus");

        // Instancias de Satelites
        Astros luna = new Satelite(1737, 27.3, 7.34e22, -20, 1.62, 384400, 27.3, "Tierra", "Luna");
        Astros fobos = new Satelite(11.1, 0.3189, 1.08e16, -40, 0.0057, 9377, 0.3189, "Marte", "Fobos");
        Astros europa = new Satelite(1560.8, 3.55, 4.8e22, -160, 1.315, 670900, 3.55, "Júpiter", "Europa");
        Astros titan = new Satelite(2574.7, 15.95, 1.35e23, -179.5, 1.352, 1221870, 15.95, "Saturno", "Titan");

        ArrayList<Astros> lista = new ArrayList<>();
        lista.add(tierra);
        lista.add(marte);
        lista.add(jupiter);
        lista.add(venus);
        lista.add(luna);
        lista.add(fobos);
        lista.add(europa);
        lista.add(titan);
        String opcion = "";

        do {
            System.out.println("""

                    1.Mostrar lista de astros
                    2.Mostrar astro
                    3.Salir

                    """);
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Lista de astros disponibles");
                    for (Astros astros : lista) {
                        System.out.println(astros.nombre);
                    }
                    break;

                case "2":
                    System.out.println("Que astro quieres que te muestre de la lista?");
                    String astro = scanner.nextLine();

                    for (Astros astros : lista) {
                        if (astros.nombre.equalsIgnoreCase(astro)) {
                            astros.muestra();
                        }
                    }
                    break;
                case "3":
                    System.out.println("Saliendo....");
                default:
                    System.out.println("Entrada no valida");
            }
        } while (!opcion.equals("3"));

    }

}
