package programacion.estudiarExamenTema11_15.biblioteca;

public class Revista extends Publicacion {
    final private String issn;
    final private String titulo;
    final private int numero;

    public Revista(String issn, String titulo, int numero) {
        if (!issn.matches("[1-9]{8}"))
            throw new IllegalArgumentException("Issn incorrecto");
        if (numero < 1)
            throw new IllegalArgumentException("Numero negativo no admitido");
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
    void mostrarEnLinea() {
        System.out.printf("%10s %10s %5d", issn, titulo, numero);

    }

}
