package programacion.tema9.Ejercicio2;

public class Gato extends Mascotas {
    private String color;
    private boolean peloLargo;

    public Gato(String nombre, int edad, String estado, String fechaNacimiento, String color, boolean peloLargo) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    @Override
    public void muestra() {
        System.out.printf("""

                Gato
                Nombre: %s
                Edad: %d
                Estado: %s
                Fecha de nacimiento: %s
                Color: %s
                Tiene pelo largo: %b

                """, nombre, edad, estado, fechaNacimiento, color, peloLargo);
    }

    @Override
    public void habla() {
        System.out.println("Miau Miau");
    }

}
