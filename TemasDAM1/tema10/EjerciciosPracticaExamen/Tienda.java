package programacion.tema10.EjerciciosPracticaExamen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class Tienda {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void añadirProductos(Producto p) throws ElementoDuplicadoException {
        if (productos.contains(p)) {
            throw new ElementoDuplicadoException();
        }
        productos.add(p);
    }

    public Optional<Producto> buscar(String criterio) {
        System.out.println("Se permite buscar por codigo sku, titulo, codigo de activacion");
        for (Producto producto : productos) {
            if (producto instanceof VideojuegoFisico v) {
                if (v.getCodigoSKU().equals(criterio))
                    return Optional.of(producto);
                if (v.getTitulo().equals(criterio))
                    return Optional.of(producto);
            }

            if (producto instanceof VideojuegoDigital d) {
                if (d.getCodigoActivacion().equals(criterio))
                    return Optional.of(producto);
                if (d.getTitulo().equals(criterio))
                    return Optional.of(producto);
            }

        }
        return Optional.empty();
    }

    public void ordenar() {
        Collections.sort(productos);

        for (Producto producto : productos) {
            producto.mostrarEnLine();
        }
    }
}
