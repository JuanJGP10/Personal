package programacion.tema15_16.ejercicio4;

import programacion.tema15_16.ejercicio1.IImpuesto;

public class Main {
    public static void main(String[] args) {

        IImpuesto i = (importe, impuesto) -> importe + impuesto;

        System.out.println("Precio final: " + i.aplicar(1000, 125));
    }
}
