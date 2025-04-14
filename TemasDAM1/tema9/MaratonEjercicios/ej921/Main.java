package programacion.tema9.MaratonEjercicios.ej921;

public class Main {
    public static void main(String[] args) {
        Bicicleta b1 = new Bicicleta("Gucci", "BMX", 200);
        System.out.println(b1);

        b1.fijarDescuento(0.2);
        b1.informacionConDescuento();

        b1.fijarDescuento(0.3, 5);
        b1.informacionConDescuento();
    }
}
