package programacion.tema15_16.ejercicio1;

public class Main {
    public static void main(String[] args) {
        IImpuesto i = new Iva();
        System.out.println("Precio con el iva aplicado: " + i.aplicar(1000, 10));
    }
}
