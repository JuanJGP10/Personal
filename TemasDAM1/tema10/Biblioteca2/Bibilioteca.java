package programacion.tema10.Biblioteca2;

import java.util.ArrayList;
import java.util.Collections;

import programacion.tema10.Ejercicio9.PublicacionException;

public class Bibilioteca {
    private ArrayList<Publicacion> lista = new ArrayList<>();

    public void añadir(Publicacion p) {
        lista.add(p);
    }

    public void añadirLibro(String isbn, String titulo, Autor autor) {
        try {
            lista.add(new Libro(isbn, titulo, autor));
        } catch (ValorIncorrecto e) {
            e.getMessage();
            throw new PublicacionException("Error al dar de alta un libro");
        }
    }

    public Publicacion buscar(String titulo) {
        for (Publicacion publicacion : lista) {
            if (publicacion instanceof Libro l && titulo.equals(l.getTitulo()))
                return l;
            if (publicacion instanceof Revista r && titulo.equals(r.getTitulo()))
                return r;

        }

        throw new PublicacionException("Titulo no encontrado");
    }

    public boolean buscarLibro(Libro l) {
        return lista.contains(l);
    }

    public ArrayList<Revista> revistasOrdenadas() {
        ArrayList<Revista> revistasO = new ArrayList<>();
        for (Publicacion publicacion : lista) {
            if (publicacion instanceof Revista r)
                revistasO.add(r);
        }
        Collections.sort(revistasO);
        return revistasO;
    }

    public void ordenar() {

    }
}
