package programacion.tema9.MaratonEjercicios.ej923;

public class PacienteConsulta extends Pacientes {
    private String motivoDeConsulta;

    public PacienteConsulta(String nombre, int edad, String motivoDeConsulta) {
        super(nombre, edad);
        this.motivoDeConsulta = motivoDeConsulta;
    }

    public String getMotivoDeConsulta() {
        return motivoDeConsulta;
    }

    public void setMotivoDeConsulta(String motivoDeConsulta) {
        this.motivoDeConsulta = motivoDeConsulta;
    }

    @Override
    public double facturar() {
        return 100;
    }

}
