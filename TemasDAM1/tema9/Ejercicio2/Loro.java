package programacion.tema9.Ejercicio2;

public class Loro extends Aves {
    private String origen;
    private boolean habla;

    public Loro(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela,
            String origen, boolean habla) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.origen = origen;
        this.habla = habla;
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
                Origen: %s
                Habla: %b

                """, nombre, edad, estado, fechaNacimiento, pico, vuela, origen, habla);
    }

    @Override
    public void habla() {
        System.out.println("Sonido de loro");
    }

    @Override
    public void vuela() {
        System.out.println("Loro Vuela.......");
    }

}
