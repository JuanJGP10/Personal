package programacion.tema8a9.Ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

public class Parking {

    private static ArrayList<Vehiculo> parking = new ArrayList<>();
    private static int capacidadMaxima = 3;

    public static boolean agregarVehiculo(Vehiculo v) {
        if (v == null)
            return false;
        if (parking.size() < capacidadMaxima) {
            parking.add(v);
            return true;
        } else {
            return false;
        }

    }

    public static boolean retirarVehiculo(String matricula) {
        if (matricula == null || matricula.isEmpty() || !matricula.matches("\\d{4}[A-Z]{3}"))
            return false;
        Iterator<Vehiculo> it = parking.iterator();

        while (it.hasNext()) {
            Vehiculo vehiculo = it.next();
            if (vehiculo.matricula().equals(matricula)) {
                it.remove();
                return true;
            }

        }
        return false;
    }

    public static void listarVehiculos() {
        for (Vehiculo vehiculo : parking) {
            System.out.println(vehiculo);
        }
    }

    public static ArrayList<Vehiculo> getParking() {
        return parking;
    }

    public static int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public static void setParking(ArrayList<Vehiculo> parking) {
        Parking.parking = parking;
    }

    public static void setCapacidadMaxima(int capacidadMaxima) {
        Parking.capacidadMaxima = capacidadMaxima;
    }

}
