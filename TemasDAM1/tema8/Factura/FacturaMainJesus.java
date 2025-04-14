package programacion.tema8.Factura;

import java.util.Scanner;

public class FacturaMainJesus {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        Factura factura = new Factura(10000, 1000);

        do {
            System.out.println("""
                    1.Darse de alta
                    2.Añadir linea
                    3.Eliminar linea
                    4.Imprimir factura
                    5.Salir
                    """);

            entrada = scanner.nextLine();

            switch (entrada) {
                case "1":
                    factura = altaFactura();
                    break;
                case "2":
                    añadirLinea(factura);

                    break;
                case "3":
                    eliminarLinea(factura);
                    break;

                case "4":
                    imprimirFactura(factura);
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    break;
                default:
                    break;
            }

        } while (!entrada.equals("5"));
        scanner.close();
    }

    private static void imprimirFactura(Factura factura) {
        if (factura != null) {
            double importeTotalconIva = factura.getImporteTotal() * 1.21;
            System.out.println(
                    "*********************************************************************************************");
            System.out.println("                                        FACTURA             ");
            System.out.println(
                    "*********************************************************************************************");
            System.out.println("Número de Factura: " + factura.getIdentificador());
            System.out.println("Fecha: " + factura.getFechaFactura());
            System.out.println("Cliente: " + factura.getNumeroCliente());
            System.out
                    .println(
                            "-----------------------------------------------------------------------------------------------");
            System.out.println(factura.getLineas());
            System.out
                    .println(
                            "-----------------------------------------------------------------------------------------------");
            System.out.printf("IVA (21%%):                                                                  %.2f\n",
                    factura.IVA);
            System.out.printf("TOTAL:                                                                      %.2f\n",
                    importeTotalconIva);
            System.out
                    .println(
                            "***********************************************************************************************");
            System.out.println("                                ¡Gracias por su compra! ");
        } else {
            System.out.println("NO estas dado de alta");
        }
    }

    private static void eliminarLinea(Factura factura) {
        Scanner scanner = new Scanner(System.in);
        if (factura != null) {
            System.out.println("Numero de linea a borrar RANGO = " + factura.getLineas().size());
            int linea = scanner.nextInt();
            factura.eliminarLinea(linea);

        } else {
            System.out.println("No estas dado de alta");

        }

    }

    private static void añadirLinea(Factura factura) {
        Scanner scanner = new Scanner(System.in);
        if (factura != null) {
            System.out.println("Descripcion de la linea");
            String desc = scanner.nextLine();
            System.out.println("Precio unitario");
            int precioUni = scanner.nextInt();
            System.out.println("Unidades");
            int unidades = scanner.nextInt();

            factura.añadirLinea(desc, precioUni, unidades);
        } else {
            System.out.println("No estas dado de alta");
        }

    }

    private static Factura altaFactura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Identificador:");
        int ident = scanner.nextInt();
        System.out.println("Numero de cliente");
        int numCl = scanner.nextInt();

        return new Factura(ident, numCl);

    }
}
