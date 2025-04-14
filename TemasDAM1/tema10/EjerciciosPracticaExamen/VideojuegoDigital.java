package programacion.tema10.EjerciciosPracticaExamen;

public class VideojuegoDigital extends Producto {
    private String codigoActivacion;
    private String titulo;
    private String plataforma;
    private double precio;

    public VideojuegoDigital(String codigoActivacion, String titulo, String plataforma, double precio)
            throws FormatoIncorrectoException, ValorIncorrecto {
        if (!codigoActivacion.matches("[A-Za-z]{12}"))
            throw new FormatoIncorrectoException("formato incorrecto");
        if (precio < 0)
            throw new ValorIncorrecto("precio incorrecto");
        this.codigoActivacion = codigoActivacion;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

    public void setCodigoActivacion(String codigoActivacion) {
        this.codigoActivacion = codigoActivacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void mostrarEnLine() {
        System.out.printf("Codigo activacion: %s Plataforma: %s Titulo: %s Precio: %.2f", codigoActivacion,
                plataforma, titulo, precio);
    }

    @Override
    public int compareTo(Producto o) {
        if (o instanceof VideojuegoFisico)
            return -1;
        if (o instanceof VideojuegoDigital) {
            VideojuegoDigital vd = (VideojuegoDigital) o;
            return this.titulo.compareTo(vd.titulo);
        }
        return 0;
    }

}
