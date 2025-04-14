package programacion.tema9.MaratonEjercicios.ej919;

public class PacienteRevision extends Pacientes {
    private String fechaVisitaAnterior;

    public PacienteRevision(String nombre, int edad, String fechaVisitaAnterior) {
        super(nombre, edad);
        this.fechaVisitaAnterior = fechaVisitaAnterior;
    }

    public String getFechaVisitaAnterior() {
        return fechaVisitaAnterior;
    }

    public void setFechaVisitaAnterior(String fechaVisitaAnterior) {
        this.fechaVisitaAnterior = fechaVisitaAnterior;
    }

    @Override
    public double facturar() {
        if (getEdad() > 65) {
            return 30;
        } else {
            return 50;
        }

    }
}
