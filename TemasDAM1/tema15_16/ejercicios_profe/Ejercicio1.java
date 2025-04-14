package programacion.tema15_16.ejercicios_profe;

public class Ejercicio1 {
    public static void main(String[] args) {
        IImpuesto iva = new Iva();
        System.out.println(iva.aplicar(1000, 10));
    }
}
