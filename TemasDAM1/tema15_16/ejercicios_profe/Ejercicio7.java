package programacion.tema15_16.ejercicios_profe;

import java.util.ArrayList;
import java.util.Comparator;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Crear una lista de libros
        ArrayList<Libro> listaLibros = new ArrayList<>();

        // Agregar 10 libros a la lista
        listaLibros.add(new Libro("El Gran Gatsby", 19.99f));
        listaLibros.add(new Libro("Cien Años de Soledad", 24.50f));
        listaLibros.add(new Libro("Don Quijote de la Mancha", 15.75f));
        listaLibros.add(new Libro("Orgullo y Prejuicio", 18.00f));
        listaLibros.add(new Libro("1984", 21.30f));
        listaLibros.add(new Libro("Matar a un Ruiseñor", 16.80f));
        listaLibros.add(new Libro("Crimen y Castigo", 22.10f));
        listaLibros.add(new Libro("Ulises", 20.50f));
        listaLibros.add(new Libro("La Odisea", 17.90f));
        listaLibros.add(new Libro("Los Hermanos Karamazov", 23.40f));

        listaLibros.sort(Comparator.comparing(Libro::getPrecio));

        listaLibros.forEach(System.out::println);

        // listaLibros.stream()
        // .sorted(Comparator.comparing(Libro::getPrecio))
        // .forEach(System.out::println);

    }
}
