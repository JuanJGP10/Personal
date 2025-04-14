package programacion.tema9.MaratonEjercicios.ej920;

import java.util.ArrayList;

public class Parking {
    private int plazas = 100;
    private ArrayList<VehiculosGeneral> parking = new ArrayList<>();

    public Parking(int plazas, ArrayList<VehiculosGeneral> parking) {
        this.plazas = plazas;
        this.parking = parking;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public ArrayList<VehiculosGeneral> getParking() {
        return parking;
    }

    public void setParking(ArrayList<VehiculosGeneral> parking) {
        this.parking = parking;
    }

}
