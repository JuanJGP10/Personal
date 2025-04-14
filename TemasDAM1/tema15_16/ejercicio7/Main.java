package programacion.tema15_16.ejercicio7;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> biblio = new ArrayList<>();

        biblio.add(new Libro("1", 10));
        biblio.add(new Libro("4", 40));
        biblio.add(new Libro("3", 30));
        biblio.add(new Libro("2", 100));

        biblio.sort(Comparator.comparing(Libro::getPrecio));

        biblio.forEach(System.out::println);

    }
}
