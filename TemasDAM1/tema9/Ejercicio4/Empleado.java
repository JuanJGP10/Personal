package programacion.tema9.Ejercicio4;

public class Empleado {
    private final String dni;
    private final String nombre;
    private double sueldoBrutoMensual;
    private int edad;
    private int telefono;
    private String direccion;

    public Empleado(String dni, String nombre, double sueldoBrutoMensual) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldoBrutoMensual = sueldoBrutoMensual;
    }

    public void mostrar() {
        System.out.printf("""
                Dni: %s
                Nombre: %s
                Sueldo bruto: %.2f
                Edad: %d
                Telefono: %d
                Direccion: %s
                """, dni, nombre, sueldoBrutoMensual, edad, telefono, direccion);
    }

    public double calcularSueldoNeto() {
        if ((sueldoBrutoMensual * 12) < 12000)
            return sueldoBrutoMensual * 0.80;
        else if ((sueldoBrutoMensual * 12) < 25000)
            return sueldoBrutoMensual * 0.70;
        else
            return sueldoBrutoMensual * 0.60;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoBrutoMensual() {
        return sueldoBrutoMensual;
    }

    public void setSueldoBrutoMensual(double sueldoBrutoMenusal) {
        this.sueldoBrutoMensual = sueldoBrutoMenusal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "[Dni:" + dni + ", SueldoBrutoMensual:" + sueldoBrutoMensual + ", Sueldo neto:"
                + calcularSueldoNeto() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

}
