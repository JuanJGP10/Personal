package programacion.tema15_16.ejercicio7;

public class Libro {
    private String titulo;
    private float precio;
    private int meGusta;

    public Libro(String titulo, float precio) {
        this.titulo = titulo;
        this.precio = precio;
        this.meGusta = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        if (meGusta == this.meGusta + 1)
            this.meGusta = meGusta;
    }

    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", precio=" + precio + ", meGusta=" + meGusta + "]";
    }

}
