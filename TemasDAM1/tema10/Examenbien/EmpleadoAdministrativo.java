package programacion.tema10.Examenbien;

public class EmpleadoAdministrativo extends Empleado {
    int añosServicio;

    public EmpleadoAdministrativo(String dni, String nombre, Direccion direccion, int añosServicio) {
        super(dni, nombre, direccion);
        setAñosServicio(añosServicio);
    }

    public EmpleadoAdministrativo(String dni, String nombre, Direccion direccion) {
        this(dni, nombre, direccion, 0);
    }

    @Override
    public double calcularSalario() {
        return 2000 + (añosServicio * 100);
    }

    public int getAñosServicio() {
        return añosServicio;
    }

    public void setAñosServicio(int añosServicio) {
        if (añosServicio < 0)
            throw new EmpleadoException("Los años de servicio no pueden ser negativos");
    }

}
