package programacion.estudiarExamenTema11_15.biblioteca;

import programacion.tema10.Biblioteca2.Autor;

public class Libro extends Publicacion {
    final private String isbn;
    final private String titulo;
    final private Autor autor;
    private int ejemplares;

    public Libro(String isbn, String titulo, Autor autor) {
        super();
        if (!isbn.matches("[1-9]{13}"))
            throw new IllegalArgumentException("Isbn no correcto");
        this.isbn = isbn;
        setEjemplares(1);
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro(String isbn, String titulo, Autor autor, int ejemplares) {
        this(isbn, titulo, autor);
        setEjemplares(ejemplares);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        if (ejemplares < 1)
            throw new IllegalArgumentException("Ejemplares negativos no admitidos");
        this.ejemplares = ejemplares;
    }

    @Override
    void mostrarEnLinea() {
        System.out.printf("%10s %10s %10s %5d", isbn, titulo, autor, ejemplares);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        return true;
    }

}
