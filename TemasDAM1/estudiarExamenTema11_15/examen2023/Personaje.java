package programacion.estudiarExamenTema11_15.examen2023;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Personaje {
    private final String nombre;
    private int fuerza;
    private boolean herido = false, muerto = false;

    public static final int FUERZA_DEFECTO = 5;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public abstract boolean retirada() throws Exception;

    public int fuerzaAleatoria() {
        return ThreadLocalRandom.current().nextInt(1, 11);
    }

    public boolean fuerzaCorrecta(int fuerza) {
        return (fuerza <= 10 && fuerza >= 1);
    }

    public String getNombre() {
        return nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public boolean isHerido() {
        return herido;
    }

    public void setHerido(boolean herido) {
        this.herido = herido;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        if (muerto)
            this.herido = false;
        this.muerto = muerto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.toLowerCase().hashCode());
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
        Personaje other = (Personaje) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equalsIgnoreCase(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Nombre: " + nombre + ", Fuerza: " + fuerza + ", Herido: " + herido
                + ", Muerto: " + muerto;
    }

}
