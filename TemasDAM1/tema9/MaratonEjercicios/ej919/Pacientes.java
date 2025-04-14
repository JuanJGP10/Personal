package programacion.tema9.MaratonEjercicios.ej919;

public abstract class Pacientes {
    private String nombre;
    private int edad;

    public Pacientes(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public abstract double facturar();

}
