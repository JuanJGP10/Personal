package programacion.tema9.Monopoly;

public class Casilla {
    private final String nombre;
    private int codigo;
    public static int contador = 1;

    public Casilla(String nombre) {
        this.nombre = nombre;
        this.codigo = contador++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Casilla other = (Casilla) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " Nombre=" + nombre + " Codigo=" + codigo;
    }

}
