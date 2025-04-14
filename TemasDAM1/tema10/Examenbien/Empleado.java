package programacion.tema10.Examenbien;

public abstract class Empleado {
    private final String dni;
    private String nombre;
    private Direccion direccion;

    public Empleado(String dni, String nombre, Direccion direccion) {
        if (!dni.matches("[0-9]{8}[A-Z]{1}"))
            throw new EmpleadoException("DNi no valido");
        this.dni = dni;
        setNombre(nombre);
        setDireccion(direccion);
    }

    public abstract double calcularSalario();

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null)
            throw new EmpleadoException("Nombre no puede ser nulo");
        if (dni.isEmpty())
            throw new EmpleadoException("Nombre no puede ser vacio");
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        if (direccion == null)
            throw new EmpleadoException("Nombre no puede ser nulo");
        this.direccion = direccion;
    }

}
