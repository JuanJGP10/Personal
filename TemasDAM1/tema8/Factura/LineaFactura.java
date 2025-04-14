package programacion.tema8.Factura;

public class LineaFactura {
    private final String descripcion;
    private final double precioUnitario;
    private final int unidades;
    private final double descuento;
    private final double importeTotalLinea;

    /**
     * Constructor LineaFactura
     * 
     * @param descripcion
     * @param precioUnitario
     * @param unidades
     * @param descuento
     */
    public LineaFactura(String descripcion, double precioUnitario, int unidades) {
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.unidades = unidades;
        this.descuento = (unidades > 10) ? 0.05 : 0;
        this.importeTotalLinea = (unidades * precioUnitario) - ((unidades * precioUnitario) * descuento);

    }

    public double getImporteTotalLinea() {
        return importeTotalLinea;
    }

    // @Override
    // public String toString() {
    // return "[descripcion=" + descripcion + " precioUnitario=" + precioUnitario +
    // " unidades="
    // + unidades + " descuento=" + descuento + " importeTotalLinea=" +
    // importeTotalLinea + "]\n";
    // }

    @Override
    public String toString() {
        return String.format("%80s %6d %4d %2.2f %6.2f", descripcion, precioUnitario, unidades, descuento,
                importeTotalLinea);
    }

}