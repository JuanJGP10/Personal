package programacion.tema10.Biblioteca2;

public class Libro extends Publicacion {
    private final String isbn;
    private final String titulo;
    private final Autor autor;
    private int numEjemplares;

    public Libro(String isbn, String titulo, Autor autor) throws ValorIncorrecto {
        super();
        if (!isbn.matches("[0-9]{13}"))
            throw new ValorIncorrecto("ISBN INCORRECTO");
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = 1;
    }

    public Libro(String isbn, String titulo, Autor autor, int numEjemplares) throws ValorIncorrecto {
        this(isbn, titulo, autor);
        if (numEjemplares < 0)
            throw new ValorIncorrecto("NUMERO DE EJEMPLARES NEGATIVO");
        this.numEjemplares = numEjemplares;
    }

    @Override
    public int compareTo(Publicacion o) {
        if (o instanceof Revista)
            return -1;
        if (o instanceof Libro) {
            Libro l = (Libro) o;
            int nombre = this.titulo.compareTo(l.titulo);

            if (nombre == 0) {
                return this.isbn.compareTo(l.isbn);
            }

            return nombre;
        }
        return 0;
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

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    @Override
    public void mostrarEnLinea() {
        // TODO Auto-generated method stub

    }

}
