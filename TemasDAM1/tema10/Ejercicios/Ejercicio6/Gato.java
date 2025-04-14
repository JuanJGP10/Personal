package programacion.tema10.Ejercicios.Ejercicio6;

public class Gato {
    private int edad;
    private String nombre;

    public Gato(int edad, String nombre) throws Exception {
        setEdad(edad);
        setNombre(nombre);
    }

    public void imprimir() {
        System.out.println("Nombre: " + nombre + " Edad: " + edad);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws Exception {
        if (edad < 0)
            throw new Exception("La edad no puede ser negativa");
        else
            this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre == null || nombre.isEmpty() || nombre.length() < 3)
            throw new Exception("El nombre no puede ser nulo, ni vacio ni menor que 3 caracteres");
        else
            this.nombre = nombre;
    }

}
