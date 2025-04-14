package programacion.tema8.LaTiendaDelBarrio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Clase ‘Tienda’
// • Contendrá la función ‘main’ del programa.
// • Al iniciar el programa se mostrará por pantalla un menú principal con las
// siguientes opciones:

// 1. Mostrar artículos.
// 2. Venta a cliente.
// 3. Compra a proveedor.
// 4. Gestionar artículos.
// 5. Salir.
// • La opción 1 mostrará por pantalla la descripción de todos los artículos de la
// tienda.
// • La opción 2 permitirá realizar una venta. Pedirá los identificadores y cantidades
// de los artículos deseados además del nombre del cliente. Mostrará el precio total y
// pedirá confirmar la venta.
// • La opción 3 permitirá realizar una compra. Pedirá los identificadores y cantidades
// de los artículos deseados además del nombre del proveedor. Mostrará el precio
// total y pedirá confirmar la compra.
// • La opción 4 mostrará un submenú con cuatro opciones: ‘1. Añadir artículo’, ‘2.
// Editar artículo’, ‘3. Eliminar artículo’ y ‘4. Volver’. Las tres primeras opciones pedirán
// introducir la información necesaria y realizarán la operación si es posible. La
// cuarta opción volverá al menú principal.
// • La opción 5 termina el programa.
// •El menú principal y el submenú se volverán a mostrar tras cada operación hasta
// que el usuario elija ‘Salir’ o ‘Volver’ según el caso.
// • Toda interacción con el usuario deberá realizarse por entrada y salida estándar
// (teclado y pantalla).
// • Los artículos deberán almacenarse en memoria en alguna estructura de datos.
// • Deberán manejarse los posibles errores y que puedan producirse.
// • No programes todo directamente en la función main. Implementa distintas
// funciones adicionales para que el código sea lo más modular.
// • Es obligatorio utilizar la clase ‘Articulo’.

/**
 * Clase main que representa la tienda y gestiona las operaciones de
 * venta, compra y gestión de artículos.
 */
public class Tienda {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion;
        String opcionSub;
        ArrayList<Articulo> articulos = new ArrayList<>(); // Lista de artículos en la tienda

        // Menú
        do {
            opcion = menu();
            switch (opcion) {
                case "1":
                    mostrarArticulos(articulos); // Mostrar todos los artículos
                    break;
                case "2":
                    realizarVenta(articulos); // Realizar una venta a un cliente
                    break;
                case "3":
                    realizarCompra(articulos); // Realizar una compra a un proveedor
                    break;
                case "4":
                    // Submenú
                    do {
                        opcionSub = submenu();
                        switch (opcionSub) {
                            case "1":
                                añadirArticulo(articulos); // Añadir un nuevo artículo
                                break;
                            case "2":
                                editarArticulo(articulos); // Editar un artículo existente
                                break;
                            case "3":
                                eliminarArticulo(articulos); // Eliminar un artículo
                                break;
                            case "4":
                                System.out.println("Volviendo......"); // Volver al menú principal
                                break;
                            default:
                                System.err.println("Error: entrada no esperada"); // Entrada no válida
                                break;
                        }
                    } while (!opcionSub.equals("4"));
                    break;
                case "5":
                    System.out.println("Saliendo......"); // Salir de la aplicación
                    break;
                default:
                    System.err.println("Error: entrada no esperada"); // Entrada no válida
                    break;
            }
        } while (!opcion.equals("5"));
    }

    /**
     * Elimina un artículo de la lista de artículos basado en su identificador.
     *
     * @param articulos Lista de artículos de la tienda.
     */
    private static void eliminarArticulo(ArrayList<Articulo> articulos) {
        System.out.println("Que articulo deseas eliminar (numero de identificador)");
        int identificador = pediridentificador(articulos); // Solicitar el identificador del artículo a eliminar
        Iterator<Articulo> buscarPorIdentificador = articulos.iterator();

        // Buscar y eliminar el artículo con el identificador proporcionado
        while (buscarPorIdentificador.hasNext()) {
            if (buscarPorIdentificador.next().getArticuloIdentificador() == (identificador)) {
                buscarPorIdentificador.remove();
            }
        }
    }

    /**
     * Edita los detalles de un artículo existente basado en su identificador.
     *
     * @param articulos Lista de artículos de la tienda.
     */
    private static void editarArticulo(ArrayList<Articulo> articulos) {

        // Solicitar el identificador del artículo a editar
        System.out.println("Que articulo deseas editar (numero de identificador)");
        int identificador = pediridentificador(articulos);

        // Solicitar nuevos valores para el artículo
        System.out.println("Dame el precio de venta al publico:");
        double precioV = pedirPrecio();
        System.out.println("Dame el precio de compra al proveedor:");
        double precioC = pedirPrecio();
        System.out.println("Dame el stock actual del articulo:");
        int stock = pedirCantidad();

        // Buscar el artículo por su identificador y actualizar sus valores
        Iterator<Articulo> buscarPorIdentificador = articulos.iterator();
        while (buscarPorIdentificador.hasNext()) {
            Articulo articuloTemp = buscarPorIdentificador.next();
            if (articuloTemp.getArticuloIdentificador() == (identificador)) {
                articuloTemp.setArticuloPrecioCompraProovedor(precioC);
                articuloTemp.setArticuloPrecioVenta(precioV);
                articuloTemp.setArticuloStock(stock);
            }
        }
    }

    /**
     * Añade un nuevo artículo a la lista de artículos.
     *
     * @param articulos Lista de artículos de la tienda.
     */
    private static void añadirArticulo(ArrayList<Articulo> articulos) {
        System.out.println("Dame el nombre del articulo:");
        String nombre = scanner.nextLine();
        System.out.println("Dame el precio de venta al publico:");
        double precioV = pedirPrecio();
        System.out.println("Dame el precio de compra al proveedor:");
        double precioC = pedirPrecio();
        System.out.println("Dame el stock actual del articulo:");
        int stock = pedirCantidad();

        // Crear un nuevo artículo y añadirlo a la lista
        Articulo articulo = new Articulo(nombre, precioV, precioC, stock);
        articulos.add(articulo);
    }

    /**
     * Muestra el submenú de gestión de artículos y devuelve la opción seleccionada.
     *
     * @return La opción seleccionada por el usuario.
     */
    private static String submenu() {
        System.out.println("""
                1.Añadir articulo
                2.Editar articulo
                3.Eliminar articulo
                4.Volver
                """);
        return scanner.nextLine();
    }

    /**
     * Realiza una compra de artículos a un proveedor.
     *
     * @param articulos Lista de artículos de la tienda.
     */
    private static void realizarCompra(ArrayList<Articulo> articulos) {
        System.out.println("Nombre del proveedor:");
        String nombreProveedor = scanner.nextLine();
        System.out.println("Cuantos articulos quieres comprar a " + nombreProveedor + " ?:");
        int numeroArt = pedirCantidad();
        int identificador = 0;
        int cantidad = 0;
        double precioFinal = 0;
        ArrayList<Integer> identificadores = new ArrayList<>(); // Lista de identificadores de artículos comprados
        ArrayList<Integer> cantidades = new ArrayList<>(); // Lista de cantidades compradas

        // Solicitar datos de cada artículo comprado
        for (int i = 1; i <= numeroArt; i++) {
            System.out.println("Articulo " + i);
            System.out.println("Identificador:");
            identificador = pediridentificador(articulos);
            System.out.println("Cantidad:");
            cantidad = pedirCantidad();

            // Buscar el artículo por su identificador e ir calculando el precio final
            Iterator<Articulo> buscarPorIdentificador = articulos.iterator();
            while (buscarPorIdentificador.hasNext()) {
                Articulo articuloTemp = buscarPorIdentificador.next();
                if (articuloTemp.getArticuloIdentificador() == (identificador)) {
                    precioFinal += cantidad * (articuloTemp.getArticuloPrecioCompraProovedor() * (Articulo.IVA + 1));
                }
            }

            identificadores.add(identificador);
            cantidades.add(cantidad);
        }

        // Mostrar el precio final y confirmar la compra
        System.out.printf("""
                El precio final sera: %.2f
                Desea realizar esta compra?:
                """, precioFinal);

        String opcion = scanner.nextLine();

        // Si se confirma la compra, actualizar el stock de los artículos
        if (opcion.equalsIgnoreCase("si")) {
            for (int i = 0; i < identificadores.size(); i++) {
                Iterator<Articulo> buscarPorIdentificador = articulos.iterator();
                while (buscarPorIdentificador.hasNext()) {
                    Articulo articuloTemp = buscarPorIdentificador.next();
                    if (articuloTemp.getArticuloIdentificador() == (identificadores.get(i))) {
                        int cantidadSumarStock = cantidades.get(i);
                        articuloTemp.comprar(cantidadSumarStock);
                    }
                }
            }
            System.out.println("Compra realizada con éxito");
        } else {
            System.out.println("Compra cancelada");
        }
    }

    /**
     * Realiza una venta de artículos a un cliente.
     *
     * @param articulos Lista de artículos de la tienda.
     */
    private static void realizarVenta(ArrayList<Articulo> articulos) {
        System.out.println("Nombre del cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Cuantos articulos quieres comprar " + nombreCliente + " ?:");
        int numeroArt = pedirCantidad();
        int identificador = 0;
        int cantidad = 0;
        double precioFinal = 0;
        ArrayList<Integer> identificadores = new ArrayList<>(); // Lista de identificadores de artículos vendidos
        ArrayList<Integer> cantidades = new ArrayList<>(); // Lista de cantidades vendidas

        // Solicitar detalles de cada artículo a vender
        for (int i = 1; i <= numeroArt; i++) {
            System.out.println("Articulo " + i);
            System.out.println("Identificador:");
            identificador = pediridentificador(articulos);
            System.out.println("Cantidad:");
            cantidad = pedirCantidad();

            // Buscar el artículo por su identificador e ir calculando el precio final
            Iterator<Articulo> buscarPorIdentificador = articulos.iterator();
            while (buscarPorIdentificador.hasNext()) {
                Articulo articuloTemp = buscarPorIdentificador.next();
                if (articuloTemp.getArticuloIdentificador() == (identificador)) {
                    precioFinal += cantidad * (articuloTemp.getArticuloPrecioVenta() * (Articulo.IVA + 1));
                }
            }

            identificadores.add(identificador);
            cantidades.add(cantidad);
        }

        // Mostrar el precio final y confirmar la venta
        System.out.printf("""
                El precio final sera: %.2f
                Desea realizar esta venta?:
                """, precioFinal);

        String opcion = scanner.nextLine();

        // Si se confirma la venta, actualizar el stock de los artículos
        if (opcion.equalsIgnoreCase("si")) {
            for (int i = 0; i < identificadores.size(); i++) {
                Iterator<Articulo> buscarPorIdentificador = articulos.iterator();
                while (buscarPorIdentificador.hasNext()) {
                    Articulo articuloTemp = buscarPorIdentificador.next();
                    if (articuloTemp.getArticuloIdentificador() == (identificadores.get(i))) {
                        int cantidadRestarStock = cantidades.get(i);
                        articuloTemp.vender(cantidadRestarStock);
                    }
                }
            }
            System.out.println("Venta realizada con éxito");
        } else {
            System.out.println("Venta cancelada");
        }
    }

    /**
     * Muestra todos los artículos de la lista.
     *
     * @param articulos Lista de artículos de la tienda.
     */
    private static void mostrarArticulos(ArrayList<Articulo> articulos) {
        for (Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }

    /**
     * Muestra el menú principal y devuelve la opción seleccionada.
     *
     * @return La opción seleccionada por el usuario.
     */
    private static String menu() {
        System.out.println("""
                1.Mostrar articulos
                2.Venta al cliente
                3.Compra a proveedor
                4.Gestionar articulos
                5.Salir
                """);
        return scanner.nextLine();
    }

    /**
     * Solicita al usuario un precio válido.
     *
     * @return El precio ingresado por el usuario habiendo pasado por las
     *         validaciones.
     */
    public static double pedirPrecio() {
        String precio;
        System.out.println("Formato numero decimal (puede o no tener comas)");
        do {
            precio = scanner.nextLine();
        } while (!precio.matches("\\d+([,]\\d+)?"));
        precio = precio.replace(',', '.');
        return Double.parseDouble(precio);
    }

    /**
     * Solicita al usuario una cantidad válida.
     *
     * @return La cantidad ingresada por el usuario habiendo pasado por las
     *         validaciones.
     */
    public static int pedirCantidad() {
        String cantidad;
        System.out.println("Formato numero entero");
        do {
            cantidad = scanner.nextLine();
        } while (!cantidad.matches("\\d+"));
        return Integer.parseInt(cantidad);
    }

    /**
     * Solicita al usuario un identificador válido para un artículo.
     *
     * @param articulos Lista de artículos de la tienda.
     * @return El identificador ingresado por el usuario habiendo pasado las
     *         validaciones.
     */
    public static int pediridentificador(ArrayList<Articulo> articulos) {
        String identificador;
        System.out.println("Escribe el identificador del articulo (seguire preguntando si no es valido)");
        do {
            identificador = scanner.nextLine();
        } while (!identificador.matches("\\d+") || (Integer.parseInt(identificador)) < 0
                || (Integer.parseInt(identificador)) > (articulos.size() + 1));
        return Integer.parseInt(identificador);
    }
}