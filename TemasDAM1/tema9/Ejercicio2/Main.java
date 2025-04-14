package programacion.tema9.Ejercicio2;

import java.util.Scanner;

import programacion.nomeacuerdo.nomeacuerdo;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Instanciando Perros
        Perro perro1 = new Perro("Rex", 3, "Saludable", "10 de abril", "Labrador", true);
        Perro perro2 = new Perro("Max", 2, "Enfermo", "10 de abril", "Bulldog", false);

        // Instanciando Gatos
        Gato gato1 = new Gato("Whiskers", 4, "Saludable", "10 de abril", "Blanco", true);
        Gato gato2 = new Gato("Michi", 5, "Saludable", "10 de abril", "Negro", false);

        // Instanciando Loros
        Loro loro1 = new Loro("Paco", 2, "Saludable", "10 de abril", "alargado", true, "Amazonas", true);
        Loro loro2 = new Loro("Pepito", 3, "Enfermo", "10 de abril", "corto", false, "Colombia", false);

        // Instanciando Canarios
        Canario canario1 = new Canario("Piolín", 1, "Saludable", "10 de abril", "alargado", true, "Amarillo", true);
        Canario canario2 = new Canario("Tweety", 2, "Saludable", "10 de abril", "alargado", true, "Naranja", false);

        // Agregando a la lista
        Inventario.insertarMascota(perro1);
        Inventario.insertarMascota(perro2);
        Inventario.insertarMascota(gato1);
        Inventario.insertarMascota(gato2);
        Inventario.insertarMascota(canario2);
        Inventario.insertarMascota(canario1);
        Inventario.insertarMascota(loro1);
        Inventario.insertarMascota(loro2);

        String opcion = "";
        do {

            System.out.println("""
                    1.Mostrar lista de animales
                    2.Mostrar datos de un animal en concreto (busqueda por nombre)
                    3.Mostrar todos los datos de todos los animales
                    4.Insertar animales en inventario
                    5.Eliminar animales de inventario(busqueda por nombre)
                    6.Vaciar inventario
                    7.Salir
                    """);

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    Inventario.mostrarMascotas();
                    break;
                case "2":
                    System.out.println("Dame el nombre de la mascota que quieres inspeciconar");
                    String nombre = scanner.nextLine();
                    Inventario.mostrarMascota(nombre);
                    break;
                case "3":
                    Inventario.mostrarTodosDatosMascotas();
                    break;
                case "4":
                    Mascotas mascota = pedirDatosMascota();
                    Inventario.insertarMascota(mascota);
                    break;
                case "5":
                    System.out.println("Dame el nombre de la mascota que quieres inspeciconar");
                    nombre = scanner.nextLine();
                    Inventario.eliminarMascota(nombre);
                    break;
                case "6":
                    Inventario.vaciarInventario();
                    break;
                case "7":
                    System.out.println("Saliendo....");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!opcion.equals("7"));
    }

    /**
     * Metodo que pide los datos de la mascota a insertar
     * 
     * @return mascota a insertar en la lista del inventario de mascotas
     */
    private static Mascotas pedirDatosMascota() {
        String tipo = "";

        do {

            System.out.println("Que tipo de mascota quieres insertar en la tienda (perro, gato, loro, canario)");
            tipo = scanner.nextLine();

        } while (!tipo.equalsIgnoreCase("canario") && !tipo.equalsIgnoreCase("loro") && !tipo.equalsIgnoreCase("gato")
                && !tipo.equalsIgnoreCase("perro"));

        System.out.println("Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Edad:");
        int edad = nomeacuerdo.pedirInt();
        System.out.println("Estado:");
        String estado = scanner.nextLine();
        System.out.println("Fecha de nacimiento:");
        String fechaNacimiento = scanner.nextLine();

        switch (tipo.toLowerCase()) {

            case "perro":

                System.out.println("Raza:");
                String raza = scanner.nextLine();
                String pulgas = "";

                do {
                    System.out.println("Tiene pulgas? (si/no)");
                    pulgas = scanner.nextLine();
                } while (!pulgas.equalsIgnoreCase("si") && !pulgas.equalsIgnoreCase("no"));

                boolean pulgasB;
                if (pulgas.equalsIgnoreCase("si")) {
                    pulgasB = true;
                } else {
                    pulgasB = false;
                }

                Mascotas perro = new Perro(nombre, edad, estado, fechaNacimiento, raza, pulgasB);
                return perro;

            case "gato":

                System.out.println("Color:");
                String color = scanner.nextLine();
                String peloLargo = "";

                do {
                    System.out.println("Tiene pelo largo? (si/no)");
                    peloLargo = scanner.nextLine();
                } while (!peloLargo.equalsIgnoreCase("si") && !peloLargo.equalsIgnoreCase("no"));

                boolean peloLargoB;
                if (peloLargo.equalsIgnoreCase("si")) {
                    peloLargoB = true;
                } else {
                    peloLargoB = false;
                }

                Mascotas gato = new Gato(nombre, edad, estado, fechaNacimiento, color, peloLargoB);
                return gato;

            case "loro":
                System.out.println("Pico:");
                String pico = scanner.nextLine();
                String vuela = "";

                do {
                    System.out.println("Vuela? (si/no)");
                    vuela = scanner.nextLine();
                } while (!vuela.equalsIgnoreCase("si") && !vuela.equalsIgnoreCase("no"));

                boolean vuelaB;
                if (vuela.equalsIgnoreCase("si")) {
                    vuelaB = true;
                } else {
                    vuelaB = false;
                }

                System.out.println("Origen:");
                String origen = scanner.nextLine();
                String habla = "";

                do {
                    System.out.println("habla? (si/no)");
                    habla = scanner.nextLine();
                } while (!habla.equalsIgnoreCase("si") && !habla.equalsIgnoreCase("no"));

                boolean hablaB;
                if (habla.equalsIgnoreCase("si")) {
                    hablaB = true;
                } else {
                    hablaB = false;
                }

                Mascotas loro = new Loro(nombre, edad, estado, fechaNacimiento, pico, vuelaB, origen, hablaB);
                return loro;

            case "canario":
                System.out.println("Pico:");
                String picoC = scanner.nextLine();
                String vuelaC = "";

                do {
                    System.out.println("vuela? (si/no)");
                    vuelaC = scanner.nextLine();
                } while (!vuelaC.equalsIgnoreCase("si") && !vuelaC.equalsIgnoreCase("no"));

                boolean vuelaCB;
                if (vuelaC.equalsIgnoreCase("si")) {
                    vuelaCB = true;
                } else {
                    vuelaCB = false;
                }

                System.out.println("Color:");
                String colorC = scanner.nextLine();
                String canta = "";

                do {
                    System.out.println("canta? (si/no)");
                    canta = scanner.nextLine();
                } while (!canta.equalsIgnoreCase("si") && !canta.equalsIgnoreCase("no"));

                boolean cantaB;
                if (canta.equalsIgnoreCase("si")) {
                    cantaB = true;
                } else {
                    cantaB = false;
                }

                Mascotas canario = new Loro(nombre, edad, estado, fechaNacimiento, picoC, vuelaCB, colorC, cantaB);
                return canario;

            default:
                return null;

        }
    }
}
