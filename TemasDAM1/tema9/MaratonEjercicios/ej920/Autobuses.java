package programacion.tema9.MaratonEjercicios.ej920;

import java.time.Duration;
import java.time.LocalDateTime;

public class Autobuses extends VehiculosGeneral {
    private int asientos;

    public Autobuses(String matricula, int asientos) {
        super(matricula);
        this.asientos = asientos;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return super.toString() + " Numero de asientos: " + asientos;
    }

    public double pagar() {
        LocalDateTime fechaAhora = LocalDateTime.now();
        long segundosPasados = Duration.between(getFechaEntrada(), fechaAhora).getSeconds();
        return segundosPasados * 4 + (25 * asientos);
    }

}
