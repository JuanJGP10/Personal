package programacion.tema15_16.ejercicios_profe;

import java.util.concurrent.ThreadLocalRandom;

public class Libro {
    private String titulo;
    private float precio;
    private int meGusta;

    public Libro(String titulo, float precio) {
        this.titulo = titulo;
        this.precio = precio;
        this.meGusta = ThreadLocalRandom.current().nextInt(100);
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

    public void setMeGusta() {
        this.meGusta++;
    }

    @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", precio=" + precio + ", meGusta=" + meGusta + "]";
    }

}
