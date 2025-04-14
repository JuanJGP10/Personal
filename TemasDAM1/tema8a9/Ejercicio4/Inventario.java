package programacion.tema8a9.Ejercicio4;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static int capacidad = 3;

    public static boolean addProducto(Producto p) {
        if (p == null)
            return false;
        if (productos.size() < capacidad) {
            productos.add(p);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static int getCapacidad() {
        return capacidad;
    }

    public static int deleteProducto(String nombre) {
        if (nombre == null || nombre.isEmpty())
            return -1;
        Iterator<Producto> it = productos.iterator();
        int contador = 0;
        while (it.hasNext()) {
            Producto producto = it.next();
            if (producto.nombre().equals(nombre)) {
                it.remove();
                contador++;

            }

        }
        if (contador == 0)
            return -1;
        else
            return contador;

    }

    public static double valorCategoria(CategoriaProducto categoria) {
        if (categoria == null)
            return -1;
        double valor = 0;
        for (Producto producto : productos) {
            if (producto.categoria() == categoria) {
                valor += producto.precio();
            }
        }
        return valor;
    }

    public static ArrayList<Producto> productosCategoria(CategoriaProducto categoria) {
        ArrayList<Producto> lista = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.categoria() == categoria) {
                lista.add(producto);
            }
        }
        return lista;
    }
}
