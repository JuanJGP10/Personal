package programacion.tema8.LaTiendaDelBarrio;

// En La Tienda del Barrio S.A. necesitan un programa en lenguaje Java que les ayude a
// gestionar la información sobre los artículos que tienen en la tienda, así como realizar
// ventas a clientes y compras a proveedores.

// Clase ‘Articulo’
// • Un artículo tiene un identificador (número entero), un nombre, un precio de
// venta a cliente, un precio de compra a proveedor, un IVA (%) y un stock
// (representa la cantidad de ese artículo disponible en tienda). El nombre y el
// identificador de un artículo no pueden cambiar. El identificador ha de establecerse
// automáticamente y ser único, podemos llevar un contador de los objetos creados y
// así el identificador será único. El IVA es el mismo para todos los artículos (un 21%).
// Tanto el precio de compra como el precio de venta han de ser valores superiores a
// cero. El precio de venta ha de ser superior al precio de compra. El stock ha de ser
// superior o igual a cero.
// • Deberá tener un único constructor así como todos los getters y setters que sea
// posible.
// • Deberá tener al menos dos métodos públicos, uno para vender (a cliente) y otro
// para comprar (a proveedor). En ambos casos deberá pasarse un único argumento
// con la cantidad de unidades a vender o comprar, y se devolverá un valor indicando
// si fue posible realizar la operación o no. Si la operación se puede realizar, se
// deberá modificar el stock del artículo.
// • Deberá tener un método público que devuelva una cadena de texto de una sola
// línea con la información sobre dicho artículo: id, nombre, precios, IVA y stock.
// • En los casos en los que sea necesario, los métodos públicos mostrarán un
// mensaje por System.err si no es posible realizar la operación solicitada.
// • Pueden implementarse otros métodos si se considera necesario.
// • Es obligatorio que esta clase no realice ningún tipo de entrada por teclado ni
// salida por pantalla (Excepto los mencionados mensajes de error)

/**
 * Clase que representa un artículo en la tienda.
 * Contiene información como el identificador, nombre, precios, stock y
 * operaciones relacionadas.
 */
public class Articulo {

    private final int articuloIdentificador; // Identificador único del artículo
    private final String articuloNombre; // Nombre del artículo
    private double articuloPrecioVenta; // Precio de venta al público
    private double articuloPrecioCompraProovedor; // Precio de compra al proveedor
    public static final double IVA = 0.21; // Impuesto sobre el valor añadido (IVA)
    private int articuloStock; // Cantidad de unidades en stock
    public static int contadorIdent = 1; // Contador para generar identificadores únicos

    /**
     * Constructor de la clase Articulo.
     *
     * @param nombre       Nombre del artículo.
     * @param precioVenta  Precio de venta al público.
     * @param precioCompra Precio de compra al proveedor.
     * @param stock        Cantidad de unidades en stock.
     */
    public Articulo(String nombre, double precioVenta, double precioCompra, int stock) {
        this.articuloIdentificador = contadorIdent; // Asignar identificador único
        contadorIdent++; // Incrementar el contador para el próximo artículo

        this.articuloNombre = nombre;
        setArticuloPrecioVenta(precioVenta); // Validar y asignar el precio de venta
        setArticuloPrecioCompraProovedor(precioCompra); // Validar y asignar el precio de compra
        setArticuloStock(stock); // Validar y asignar el stock
    }

    public int getArticuloIdentificador() {
        return articuloIdentificador;
    }

    public String getArticuloNombre() {
        return articuloNombre;
    }

    public double getArticuloPrecioVenta() {
        return articuloPrecioVenta;
    }

    /**
     * Establece el precio de venta al público.
     * El precio de venta debe ser mayor que el precio de compra y mayor que 0.
     *
     * @param articuloPrecioVenta El nuevo precio de venta.
     */
    public void setArticuloPrecioVenta(double articuloPrecioVenta) {
        if (articuloPrecioVenta > articuloPrecioCompraProovedor && articuloPrecioVenta > 0) {
            this.articuloPrecioVenta = articuloPrecioVenta;
        } else {
            System.err.println("Error al establecer el precio de venta");
        }
    }

    public double getArticuloPrecioCompraProovedor() {
        return articuloPrecioCompraProovedor;
    }

    /**
     * Establece el precio de compra al proveedor.
     * El precio de compra debe ser menor que el precio de venta y mayor que 0.
     *
     * @param articuloPrecioCompraProovedor El nuevo precio de compra.
     */
    public void setArticuloPrecioCompraProovedor(double articuloPrecioCompraProovedor) {
        if (articuloPrecioCompraProovedor < articuloPrecioVenta && articuloPrecioCompraProovedor > 0) {
            this.articuloPrecioCompraProovedor = articuloPrecioCompraProovedor;
        } else {
            System.err.println("Error al establecer el precio de compra");
        }
    }

    public int getArticuloStock() {
        return articuloStock;
    }

    /**
     * Establece la cantidad de unidades en stock.
     * El stock no puede ser negativo.
     *
     * @param articuloStock La nueva cantidad de unidades en stock.
     */
    public void setArticuloStock(int articuloStock) {
        if (articuloStock >= 0) {
            this.articuloStock = articuloStock;
        } else {
            System.err.println("Error al establecer el stock del artículo");
        }
    }

    /**
     * Realiza una venta del artículo, reduciendo el stock.
     *
     * @param unidades Cantidad de unidades a vender.
     * @return 1 si la venta fue exitosa, 0 si no fue posible.
     */
    public int vender(int unidades) {
        if (unidades > 0 && unidades <= articuloStock) {
            this.articuloStock -= unidades;
            return 1; // Venta exitosa
        } else {
            System.err.println("No ha sido posible realizar la operación");
            return 0; // Venta fallida
        }
    }

    /**
     * Realiza una compra del artículo, aumentando el stock.
     *
     * @param unidades Cantidad de unidades a comprar.
     * @return 1 si la compra fue exitosa, 0 si no fue posible.
     */
    public int comprar(int unidades) {
        if (unidades > 0) {
            this.articuloStock += unidades;
            return 1; // Compra exitosa
        } else {
            System.err.println("No ha sido posible realizar la operación");
            return 0; // Compra fallida
        }
    }

    /**
     * Devuelve una representación en cadena del artículo.
     *
     * @return Una cadena con los detalles del artículo.
     */
    @Override
    public String toString() {
        return String.format(
                """
                        Identificador: %d | Nombre: %s | Precio de venta: %.2f | Precio de compra: %.2f | IVA: %.2f | Stock: %d
                        """,
                articuloIdentificador, articuloNombre, articuloPrecioVenta, articuloPrecioCompraProovedor, IVA,
                articuloStock);
    }
}