package programacion.tema9.MaratonEjercicios.ej920;

import java.time.Duration;
import java.time.LocalDateTime;

public class Furgonetas extends VehiculosGeneral {
    private double longitud;

    public Furgonetas(String matricula, double longitud) {
        super(matricula);
        this.longitud = longitud;

    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return super.toString() + " Longitud: " + longitud;
    }

    public double pagar() {
        LocalDateTime fechaAhora = LocalDateTime.now();
        long segundosPasados = Duration.between(getFechaEntrada(), fechaAhora).getSeconds();
        return segundosPasados * 4 + (20 * longitud);
    }

}
