package programacion.tema10.Biblioteca2;

public class Revista extends Publicacion {
    private final String issn;
    private final String titulo;
    private final int numero;;

    public Revista(String issn, String titulo, int numero) throws ValorIncorrecto {
        super();
        if (!issn.matches("[0-9]{8}"))
            throw new ValorIncorrecto("ISBN INCORRECTO");
        if (numero < 0)
            throw new ValorIncorrecto("NUMERO INCORRECTO");
        this.issn = issn;
        this.titulo = titulo;
        this.numero = numero;

    }

    public String getIssn() {
        return issn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int compareTo(Publicacion o) {
        if (o instanceof Libro) {
            return 1;
        }
        if (o instanceof Revista) {
            Revista r = (Revista) o;
            int nombre = this.titulo.compareTo(r.titulo);

            if (nombre == 0) {
                return this.issn.compareTo(r.issn);
            }

            return nombre;
        }
        return 0;

    }

    @Override
    public void mostrarEnLinea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarEnLinea'");
    }

}
