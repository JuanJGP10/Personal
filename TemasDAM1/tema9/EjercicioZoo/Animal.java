package programacion.tema9.EjercicioZoo;

public abstract class Animal {
    private final String nombre;
    private int estancia;

    public Animal(String nombre, int estancia) {
        this.nombre = nombre;
        this.estancia = estancia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstancia() {
        return estancia;
    }

    public void setEstancia(int estancia) {
        this.estancia = estancia;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Animal))
            return false;
        return this.nombre.equals(((Animal) obj).nombre);
    }

    @Override
    public String toString() {
        return "Animal [nombre=" + nombre + ", estancia=" + estancia + "]";
    }

    public abstract void ejercicio();

}
