package programacion.tema9.Monopoly;

public abstract class Propiedad extends Casilla implements Comprable {
    protected final int precio;
    protected final int hipoteca;
    private int propietario;

    public Propiedad(String nombre, int precio, int hipoteca) {
        super(nombre);
        this.precio = precio;
        this.hipoteca = hipoteca;
        this.propietario = -1;
    }

    public int getPropietario() {
        return propietario;
    }

    public abstract int getAlquiler(int modificador);

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return super.toString() + " Precio=" + precio + " Hipoteca=" + hipoteca;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + precio;
        result = prime * result + hipoteca;
        result = prime * result + propietario;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Propiedad other = (Propiedad) obj;
        if (precio != other.precio)
            return false;
        if (hipoteca != other.hipoteca)
            return false;
        if (propietario != other.propietario)
            return false;
        return true;
    }

    @Override
    public void comprar(int i) {
        if (this.getPropietario() == -1) {
            setPropietario(i);
        }
    }

}
