package programacion.tema15_16.ejercicio8_v2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ej8 {
        public static void main(String[] args) {
                ArrayList<Libro> biblio = new ArrayList<>();

                biblio.add(new Libro("1", 10));
                biblio.add(new Libro("4", 40));
                biblio.add(new Libro("3", 30));
                biblio.add(new Libro("2", 100));
                biblio.get(0).setMeGusta(1);
                biblio.get(0).setMeGusta(2);
                biblio.get(0).setMeGusta(3);
                biblio.sort(Comparator.comparing(Libro::getPrecio));

                biblio.forEach((s1) -> System.out.println(s1.getTitulo() + " Precio: " + s1.getPrecio()));

                System.out.println("-------------------------------------");

                // a)
                biblio.stream().filter((s1) -> s1.getPrecio() > 10).forEach(System.out::println);
                // b)
                System.out.println("-------------------------------------");
                biblio.stream().filter(l -> l.getPrecio() > 10).map(Libro::getTitulo).forEach(System.out::println);
                // c)
                System.out.println("-------------------------------------");
                Set<Libro> set = biblio.stream().filter(s1 -> s1.getMeGusta() > 2).collect(Collectors.toSet());
                set.forEach(System.out::println);
                // d)
                System.out.println("-------------------------------------");
                System.out.println("Libros con cero me gustas: "
                                + biblio.stream().filter(s1 -> s1.getMeGusta() == 0).count());
                // e)

                System.out.println("-------------------------------------");
                System.out.println(
                                "Numero de megustas en total: " + biblio.stream().mapToInt(Libro::getMeGusta).sum());
                // f)
                System.out.println("-------------------------------------");
                List<Libro> biblioUsa = biblio.stream().peek(s1 -> s1.setPrecio(s1.getPrecio() / 0.92f)).toList();
                biblioUsa.stream().forEach(System.out::println);
                // g)
                System.out.println("-------------------------------------");
                System.out.println(
                                "Libro con mas me gustas: " + biblio.stream()
                                                .max((s1, s2) -> s1.getMeGusta() - s2.getMeGusta()).get());
        }
}
