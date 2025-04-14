package programacion.tema10.Ejercicio9;

public class Libro extends Publicacion {
    private final String isbn;
    private final String titulo;
    private final Autor autor;
    private int numeroEjemplares;

    public Libro(String isbn, String titulo, Autor autor) throws ValorIncorrecto {
        if (!isbn.matches("[0-9]{13}"))
            throw new ValorIncorrecto(isbn);
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroEjemplares = 1;
    }

    public Libro(String isbn, String titulo, Autor autor, int numeroEjemplares) throws ValorIncorrecto {
        this(isbn, titulo, autor);
        if (numeroEjemplares < 0)
            throw new ValorIncorrecto(String.valueOf(numeroEjemplares));
        this.numeroEjemplares = numeroEjemplares;
    }

    public void mostrarEnLinea() {
        System.out.printf("%-4s %-15s %-30s %-15s %-10d\n", String.valueOf(id), isbn, titulo,
                autor.getPseudonimo(), numeroEjemplares);
    }

    @Override
    public int compareTo(Publicacion o) {
        if (o instanceof Revista)
            return -1;
        if (o instanceof Libro l) {
            int comparacionNombre = this.titulo.compareTo(l.titulo);

            // si comparacion nombre da 0 es que los nombre son iguales
            if (comparacionNombre == 0) {
                return this.isbn.compareTo(l.isbn);
            }

            return comparacionNombre;
        }
        return 0;
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

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
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

        // Asi seria si compararamos por id tambien
        if (!String.valueOf(id).equals(String.valueOf(id)))
            return false;

        return true;
    }

}
