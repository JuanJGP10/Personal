package programacion.tema10.Ejercicio9;

public class Autor implements Comparable<Autor> {
    private final String nombre;
    private final String pseudonimo;

    public Autor(String nombre, String pseudonimo) {
        this.nombre = nombre;
        this.pseudonimo = pseudonimo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((pseudonimo == null) ? 0 : pseudonimo.hashCode());
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
        Autor other = (Autor) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (pseudonimo == null) {
            if (other.pseudonimo != null)
                return false;
        } else if (!pseudonimo.equals(other.pseudonimo))
            return false;
        return true;
    }

    @Override
    public int compareTo(Autor o) {
        int comparacionNombre = nombre.compareToIgnoreCase(o.nombre);

        if (comparacionNombre == 0)
            return pseudonimo.compareToIgnoreCase(o.pseudonimo);

        return comparacionNombre;
    }

}
