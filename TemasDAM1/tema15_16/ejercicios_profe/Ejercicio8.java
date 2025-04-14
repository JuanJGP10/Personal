package programacion.tema15_16.ejercicios_profe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Ejercicio8 {
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

        listaLibros.stream().filter(l -> l.getPrecio() > 10).forEach(System.out::println);
        listaLibros.stream().filter(l -> l.getPrecio() > 10).map(Libro::getTitulo).forEach(System.out::println);
        Set<Libro> favoritos = listaLibros.stream().filter(l -> l.getMeGusta() > 2).collect(Collectors.toSet());
        long conCero = listaLibros.stream().filter(l -> l.getMeGusta() == 0).count();
        int sumaMeGusta = listaLibros.stream().mapToInt(Libro::getMeGusta).sum();
        ArrayList<Libro> enDolares = (ArrayList<Libro>) listaLibros.stream()
                .map(l -> new Libro(l.getTitulo(), l.getPrecio() / 0.92f)).collect(Collectors.toList());
        System.out.println(enDolares);
        System.out.println(listaLibros);
        // Optional<Libro>
        // masMeGusta=listaLibros.stream().max((l1,l2)->l1.getMeGusta()-l2.getMeGusta());
        Optional<Libro> masMeGusta = listaLibros.stream().max(Comparator.comparing(Libro::getMeGusta));
        System.out.println(masMeGusta);
    }
}
