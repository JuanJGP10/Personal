package programacion.estudiarExamenTema11_15.biblioteca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import programacion.tema10.Biblioteca2.Autor;

public class Biblioteca {
    private ArrayList<Publicacion> biblio = new ArrayList<>();

    public void añadir(Publicacion p) {
        biblio.add(p);
    }

    public void añadirLibro(String isbn, String titulo, Autor autor) {
        biblio.add(new Libro(isbn, titulo, autor));
    }

    public Optional<Publicacion> buscar(String nombreString) {
        return biblio.stream().filter(s -> (s instanceof Revista && ((Revista) s).getTitulo().equals(nombreString)) ||
                (s instanceof Libro l && l.getTitulo().equals(nombreString))).findFirst();
    }

    public boolean buscarLibro(Libro l) {
        return biblio.stream().anyMatch(s -> (s instanceof Libro libro && libro.equals(l)));
    }

    public ArrayList<Revista> revistasOrdenadas() {
        List<Revista> revistasOrd = biblio.stream().filter(s -> (s instanceof Revista r))
                .map(s -> (Revista) s)
                .sorted(Comparator.comparing(Revista::getTitulo).thenComparing(Revista::getIssn))
                .collect(Collectors.toList());

        return new ArrayList<>(revistasOrd);
    }

    public void ordenar() {
        ArrayList<Revista> revistas = revistasOrdenadas();

        List<Libro> libros = biblio.stream().filter(s -> s instanceof Libro).map(s -> (Libro) s)
                .sorted(Comparator.comparing(Libro::getTitulo).thenComparing(Libro::getIsbn))
                .collect(Collectors.toList());

        biblio.clear();

        revistas.stream().forEach(s -> biblio.add(s));
        libros.stream().forEach(s -> biblio.add(s));
    }

}
