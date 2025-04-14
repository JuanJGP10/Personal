package programacion.tema15_16.ejercicios_profe;

public class Ejercicio2 {
    public static void main(String[] args) {
        IImpuesto iva = new IImpuesto() {

            @Override
            public double aplicar(double importe, float impuesto) {
                return importe + impuesto;
            }
        };

        System.out.println(iva.aplicar(50, 10));
    }
}
