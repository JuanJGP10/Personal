package programacion.tema9.MaratonEjercicios.ej911;

public class Trabajador {
    private String nombre;
    private int id;
    private String fechaNacimiento;
    private double salarioBase;

    public Trabajador(String nombre, int id, String fechaNacimiento, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre + " Id:" + id + " FechaNacimiento:" + fechaNacimiento + " SalarioBase:"
                + salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
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
        Trabajador other = (Trabajador) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
