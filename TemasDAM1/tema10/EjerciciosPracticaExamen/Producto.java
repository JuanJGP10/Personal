package programacion.tema10.EjerciciosPracticaExamen;

public abstract class Producto implements Comparable<Producto> {
    private int id;

    public static int contador = 0;

    public Producto() {
        this.id = contador;
        contador++;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Producto other = (Producto) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void mostrarEnLine();
}
