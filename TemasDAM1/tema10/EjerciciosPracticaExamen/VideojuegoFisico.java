package programacion.tema10.EjerciciosPracticaExamen;

import programacion.tema10.Ejercicio9.ValorIncorrecto;

public class VideojuegoFisico extends Producto {

    private String codigoSKU;
    private String plataforma;
    private String titulo;
    private double precio;
    private int stock;

    public VideojuegoFisico(String codigoSKU, String plataforma, String titulo, double precio, int stock)
            throws ValorIncorrecto, FormatoIncorrectoException {
        super();
        if (!codigoSKU.matches("[A-Za-z]{8}"))
            throw new FormatoIncorrectoException("codigo no valido");
        if (precio <= 0)
            throw new ValorIncorrecto("precio incorrecto");
        if (stock < 1)
            throw new ValorIncorrecto("stock incorrecto");

        this.codigoSKU = codigoSKU;
        this.plataforma = plataforma;
        this.titulo = titulo;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public int compareTo(Producto otro) {
        if (otro instanceof VideojuegoDigital vi) {
            return 1;
        } else if (otro instanceof VideojuegoFisico) {
            VideojuegoFisico vf = (VideojuegoFisico) otro;
            return this.titulo.compareTo(vf.titulo);
        }
        return 0;

    }

    public String getCodigoSKU() {
        return codigoSKU;
    }

    public void setCodigoSKU(String codigoSKU) {
        this.codigoSKU = codigoSKU;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void mostrarEnLine() {
        System.out.printf("Codigo SKU: %s Plataforma: %s Titulo: %s Precio: %.2f  Stock: %d", codigoSKU, plataforma,
                titulo, precio, stock);

    }
}
