package programacion.tema9.Ejercicio5;

import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        // Lista para almacenar los vehículos
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        // Creación de vehículos específicos
        vehiculos.add(new Coche("1234ABC", "Toyota Corolla", 4, true));
        vehiculos.add(new Moto("5678DEF", "Yamaha R1", 2, "Rojo"));
        vehiculos.add(new Barco("BOAT1", "Titanic", 30.5, true));
        vehiculos.add(new Submarino("SUB2", "Nautilus", 20.0, 500.0));
        vehiculos.add(new Avion("PLNA5678", "Boeing 747", 300, 12.5));
        vehiculos.add(new Helicoptero("HELI1234", "Apache AH-64", 2, 4));

        // Creación de vehículos genéricos
        vehiculos.add(new VehiculoTerrestre("9999ZZZ", "Genérico Terrestre", 6));
        vehiculos.add(new VehiculoAcuatico("BOATGEN", "Genérico Acuático", 15.0));
        vehiculos.add(new VehiculoAereo("FLYAIR", "Genérico Aéreo", 50));

        // Recorrer la lista y llamar al método imprimir() de cada vehículo
        for (Vehiculo v : vehiculos) {
            v.imprimir();
        }
    }
}
