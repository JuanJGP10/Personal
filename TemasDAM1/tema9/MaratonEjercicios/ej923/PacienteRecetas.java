package programacion.tema9.MaratonEjercicios.ej923;

public class PacienteRecetas extends Pacientes {
    private int medicamentos;

    public PacienteRecetas(String nombre, int edad, int medicamentos) {
        super(nombre, edad);
        this.medicamentos = medicamentos;
    }

    public int getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(int medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Override
    public double facturar() {
        return 5 * medicamentos;
    }

}
