package programacion.tema10.Ejercicio9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class Biblioteca {
    private static ArrayList<Publicacion> listaPublicaciones = new ArrayList<>();

    public void añadir(Publicacion publi) {
        listaPublicaciones.add(publi);
    }

    public void añadirLibro(String isbn, String titulo, Autor autor) {
        try {
            listaPublicaciones.add(new Libro(isbn, titulo, autor));
        } catch (ValorIncorrecto e) {
            System.out.println(e.toString());
            throw new PublicacionException("Error al dar de alta el libro");
        }

    }

    public Optional<Publicacion> buscar(String titulo) throws Exception {
        return listaPublicaciones.stream().filter(s -> (s instanceof Libro l && l.getTitulo().equals(titulo))
                || (s instanceof Revista r && r.getNombre().equals(titulo))).findFirst();
    }

    /**
     * examen alomejor tambien por id?
     * porque se complica?
     * 
     * @param libro
     * @return
     */
    public boolean buscarLibro(Libro libro) {
        return listaPublicaciones.stream().filter((s) -> libro.equals(s)).findAny().isPresent();

        // Tambien se puede con return publicaciones.contains(libro)
        // Tambien se puede con return publicaciones.indexOf(libro)
    }

    public ArrayList<Revista> revistasOrdenadas() {
        ArrayList<Revista> revistas = new ArrayList<>();
        // Primero añado todas las revistas

        listaPublicaciones.stream().filter((s) -> (s instanceof Revista r)).map(s -> (Revista) s)
                .forEach(revistas::add);

        revistas.sort(Comparator.comparing(Revista::getNombre).thenComparing(Revista::getIssn));

        return revistas;
    }

    public void ordenar() {
        Collections.sort(listaPublicaciones);

    }

    /**
     * ARREGLAR
     */
    public void mostrarLineas() {
        ArrayList<Publicacion> listaOrdenada = new ArrayList<>(listaPublicaciones);
        Collections.sort(listaOrdenada);

        boolean unaIt = true;
        System.out.println("--------------------------------------");
        System.out.printf("%-4s %-15s %-30s %-15s %-10s\n", "ID", "ISBN", "Titulo", "Autor", "NumeroEjemplares");
        System.out.println("--------------------------------------");
        for (Publicacion publicacion : listaOrdenada) {
            if (publicacion instanceof Revista && unaIt) {
                System.out.println("--------------------------------------");
                System.out.printf("%-4s %-15s %-30s %-10s\n", "ID", "ISNN", "Nombre", "Numero");
                System.out.println("--------------------------------------");
                unaIt = false;
            }
            publicacion.mostrarEnLinea();
        }
    }

    public static ArrayList<Publicacion> getListaPublicaciones() {
        return listaPublicaciones;
    }

    public static void setListaPublicaciones(ArrayList<Publicacion> listaPublicaciones) {
        Biblioteca.listaPublicaciones = listaPublicaciones;
    }

}
