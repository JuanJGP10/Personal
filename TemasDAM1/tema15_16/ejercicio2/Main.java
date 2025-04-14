package programacion.tema15_16.ejercicio2;

import programacion.tema15_16.ejercicio1.IImpuesto;

public class Main {
    public static void main(String[] args) {
        IImpuesto i = new IImpuesto() {
            public double aplicar(double importe, float impuesto) {
                return importe + impuesto;
            }
        };

        System.out.println("Precio final: " + i.aplicar(1000, 125));
    }
}
