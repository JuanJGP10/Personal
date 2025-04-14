package programacion.tema9.Ejercicio2;

public class Perro extends Mascotas {
    private String raza;
    private boolean pulgas;

    public Perro(String nombre, int edad, String estado, String fechaNacimiento, String raza, boolean pulgas) {
        super(nombre, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }

    @Override
    public void muestra() {
        System.out.printf("""

                Perro
                Nombre: %s
                Edad: %d
                Estado: %s
                Fecha de nacimiento: %s
                Raza: %s
                Pulgas: %b

                """, nombre, edad, estado, fechaNacimiento, raza, pulgas);
    }

    @Override
    public void habla() {
        System.out.println("Guau Guau");
    }

}
