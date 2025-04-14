package programacion.tema9.MaratonEjercicios.ej920;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class VehiculosGeneral {
    private String matricula;
    private LocalDateTime fechaEntrada;

    public VehiculosGeneral(String matricula) {
        this.matricula = matricula;
        this.fechaEntrada = fechaEntrada.now();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + " FechaEntrada: " + fechaEntrada;
    }

    public double pagar() {
        LocalDateTime fechaAhora = LocalDateTime.now();
        long segundosPasados = Duration.between(fechaEntrada,
                fechaAhora).getSeconds();
        return segundosPasados * 4;
    }

    // public double pagar() {
    // LocalDateTime fechaAhora = LocalDateTime.now();
    // long segundosPasados = ChronoUnit.SECONDS.between(fechaEntrada, fechaAhora);
    // return segundosPasados * 4;
    // }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VehiculosGeneral other = (VehiculosGeneral) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

}
