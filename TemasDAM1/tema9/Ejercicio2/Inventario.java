package programacion.tema9.Ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase inventario que manejara un arraylist de mascotas que hay en una tienda
 * 
 */
public class Inventario {
    private static ArrayList<Mascotas> mascotas = new ArrayList<>();

    /**
     * Metodo que nos mostrara todos los nombres y tipos de las mascotas de nuestra
     * tienda
     */
    public static void mostrarMascotas() {
        for (Mascotas mascota : mascotas) {
            System.out.println(mascota.nombre + " ~~ " + tipo(mascota));
        }
    }

    public static void mostrarMascota(String nombre) {
        for (Mascotas mascota : mascotas) {
            if (mascota.nombre.equalsIgnoreCase(nombre)) {
                mascota.muestra();
            }
        }
    }

    public static void mostrarTodosDatosMascotas() {
        for (Mascotas mascota : mascotas) {
            mascota.muestra();
        }
    }

    public static void insertarMascota(Mascotas mascota) {
        mascotas.add(mascota);
    }

    public static void eliminarMascota(String nombre) {
        Iterator<Mascotas> it = mascotas.iterator();
        while (it.hasNext()) {
            Mascotas mascota = it.next();
            if (mascota.nombre.equalsIgnoreCase(nombre))
                it.remove();
        }
    }

    public static void vaciarInventario() {
        mascotas.clear();
    }

    /**
     * Metodo para saber a que subclase pertenece el objeto y asi asignarle el tipo
     * de mascota que corresponda
     * 
     * @param m objeto mascota
     * @return devuelve tipo de enumeracion
     */
    public static Tipos tipo(Mascotas m) {
        if (m instanceof Perro)
            return Tipos.PERRO;
        if (m instanceof Loro)
            return Tipos.LORO;
        if (m instanceof Gato)
            return Tipos.GATO;
        if (m instanceof Canario)
            return Tipos.CANARIO;
        return null;
    }
}
