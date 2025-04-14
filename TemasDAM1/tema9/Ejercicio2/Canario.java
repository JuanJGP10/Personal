package programacion.tema9.Ejercicio2;

public class Canario extends Aves {
    private String color;
    private boolean canta;

    public Canario(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela,
            String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.color = color;
        this.canta = canta;
    }

    @Override
    public void muestra() {
        System.out.printf("""

                Loro
                Nombre: %s
                Edad: %d
                Estado: %s
                Fecha de nacimiento: %s
                Pico: %s
                Vuela: %b
                Color: %s
                Canta: %b

                """, nombre, edad, estado, fechaNacimiento, pico, vuela, color, canta);
    }

    @Override
    public void habla() {
        System.out.println("Sonido de Canario");
    }

    @Override
    public void vuela() {
        System.out.println("Canario Vuela.......");
    }
}
