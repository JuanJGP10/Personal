package programacion.tema15_16.ejercicio8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
        public static void main(String[] args) {
                ArrayList<Libro> biblio = new ArrayList<>();

                biblio.add(new Libro("1", 10));
                biblio.add(new Libro("4", 40));
                biblio.add(new Libro("3", 30));
                biblio.add(new Libro("2", 100));
                biblio.get(0).setMeGusta(1);
                biblio.sort(Comparator.comparing(Libro::getPrecio));

                biblio.forEach((s1) -> System.out.println(s1.getTitulo() + " Precio: " + s1.getPrecio()));

                System.out.println("-------------------------------------");

                // a)
                biblio.stream()
                                .filter(arg -> arg.getPrecio() > 10)
                                .forEach(System.out::println);
                System.out.println("-------------------------------------");

                // b)
                // biblio.stream()
                // .filter(arg -> arg.getPrecio() > 10)
                // .forEach((salida) -> System.out.println("Titulo:" + salida.getTitulo()));
                biblio.stream().map((Libro::getTitulo)).forEach(System.out::println);
                // c)
                System.out.println("-------------------------------------");

                Set<Libro> set = biblio.stream()
                                .filter(arg -> arg.getMeGusta() > 2)
                                .collect(Collectors.toSet());

                // d)
                System.out.println("-------------------------------------");

                System.out.println("Contador de libros con 0 megustas: " + biblio.stream()
                                .filter(arg -> arg.getMeGusta() == 0)
                                .count());
                // e)
                System.out.println("-------------------------------------");

                System.out.println("Cantidad de megustas en total: " + biblio.stream()
                                .mapToInt(Libro::getMeGusta)
                                .sum());
                // f)
                System.out.println("-------------------------------------");

                List<Libro> librosUsa = biblio.stream()
                                .peek(arg -> arg.setPrecio(arg.getPrecio() / 0.92f))
                                .collect(Collectors.toList());
                librosUsa.forEach(System.out::println);
                // g)
                System.out.println("-------------------------------------");

                System.out.println(biblio.stream().max((arg1, arg2) -> arg1.getMeGusta() - arg2.getMeGusta()));

        }
}
