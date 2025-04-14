package programacion.tema8.Factura;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/** */
public class Factura {
    /** */
    private final int identificador;
    private final LocalDate fechaFactura;
    private final int numeroCliente;
    public static final double IVA = 0.21;
    private double importeTotal = 0;
    private ArrayList<LineaFactura> lineas;

    /**
     * Constructor Factura
     * 
     * @param identificador
     * @param numeroCliente
     */
    public Factura(int identificador, int numeroCliente) {
        this.identificador = identificador;

        this.numeroCliente = numeroCliente;

        this.fechaFactura = LocalDate.now();
        this.lineas = new ArrayList<LineaFactura>();
    }

    // public void añadirLineaProfe(LineaFactura linea) {
    // lineas.add(linea);
    // importeTotal += linea.getImporteTotalLinea();
    // }

    /**
     * 
     * @param descripcion
     * @param precioUnitario
     * @param unidades
     */
    public void añadirLinea(String descripcion, int precioUnitario, int unidades) {

        LineaFactura linea = new LineaFactura(descripcion, precioUnitario, unidades);
        importeTotal += linea.getImporteTotalLinea();
        lineas.add(linea);

    }

    /**
     * Metodo para borrar una linea de la factura
     * 
     * @param numeroLinea indice de la linea a borrar
     * @return Linea Factura eliminada o null si no se borra
     */
    public LineaFactura eliminarLinea(int numeroLinea) {
        if (!lineas.isEmpty() && numeroLinea > 0 && numeroLinea <= lineas.size()) {
            importeTotal -= lineas.get(numeroLinea - 1).getImporteTotalLinea();
            return lineas.remove(numeroLinea - 1);
        } else {
            return null;
        }

    }

    /** */
    public void imprimirFacturaProfe() {
        System.out.printf("""
                Identificacion factura: %d
                Fecha: %s
                Cliente: %d
                """, identificador, fechaFactura, numeroCliente);
    }

    public void imprimirFactura() {
        double importeTotalconIva = importeTotal * 1.21;
        System.out.println(
                "*********************************************************************************************");
        System.out.println("                                        FACTURA             ");
        System.out.println(
                "*********************************************************************************************");
        System.out.println("Número de Factura: " + identificador);
        System.out.println("Fecha: " + fechaFactura);
        System.out.println("Cliente: " + numeroCliente);
        System.out
                .println(
                        "-----------------------------------------------------------------------------------------------");
        System.out.println(lineas);
        System.out
                .println(
                        "-----------------------------------------------------------------------------------------------");
        System.out.printf("IVA (21%%):                                                                  %.2f\n", IVA);
        System.out.printf("TOTAL:                                                                      %.2f\n",
                importeTotalconIva);
        System.out
                .println(
                        "***********************************************************************************************");
        System.out.println("                                ¡Gracias por su compra! ");
    }

    @Override
    public String toString() {
        return "Factura [" + identificador + "]\nfechaFactura=" + fechaFactura + "\nnumeroCliente="
                + numeroCliente + "\nimporteTotal=" + importeTotal + "$\nlineas=" + lineas;
    }

    public int getIdentificador() {
        return identificador;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public ArrayList<LineaFactura> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaFactura> lineas) {
        this.lineas = lineas;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int entrada = 0;
        Factura factura = new Factura(1000, 1000);
        boolean existeF = false;
        do {
            System.out.println("""
                    1.Darse de alta
                    2.Añadir linea
                    3.Eliminar linea
                    4.Imprimir factura
                    5.Salir
                    """);
            // System.out.println("1. Darse de alta");
            // System.out.println("2. Añadir lineas");
            // System.out.println("3. Eliminar lineas");
            // System.out.println("4. Imprimir factura");
            // System.out.println("5. Salir");
            entrada = scanner.nextInt();
            scanner.nextLine();

            switch (entrada) {
                case 1:
                    if (!existeF) {
                        existeF = true;
                        System.out.println("Identificador:");
                        int ident = scanner.nextInt();
                        System.out.println("Numero de cliente");
                        int numCl = scanner.nextInt();
                        factura = new Factura(ident, numCl);
                    } else {
                        System.out.println("Usted ya ha creado na factura");
                    }

                    break;
                case 2:
                    if (existeF) {
                        System.out.println("Descripcion de la linea");
                        String desc = scanner.nextLine();
                        System.out.println("Precio unitario");
                        int precioUni = scanner.nextInt();
                        System.out.println("Unidades");
                        int unidades = scanner.nextInt();
                        scanner.nextLine();
                        factura.añadirLinea(desc, precioUni, unidades);
                        break;
                    } else {
                        System.out.println("Crea la factura primero");
                        break;
                    }

                case 3:

                    if (existeF) {
                        System.out.println("Numero de linea a borrar (RANGO: " + factura.lineas.size() + ")");
                        int linea = scanner.nextInt();
                        factura.eliminarLinea(linea);
                        break;
                    } else {
                        System.out.println("Crea la factura primero");
                        break;
                    }

                case 4:
                    if (existeF) {
                        factura.imprimirFactura();
                        break;
                    } else {
                        System.out.println("Crea la factura primero");
                        break;
                    }

                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    break;
            }

        } while (entrada != 5);

        scanner.close();
    }

}
