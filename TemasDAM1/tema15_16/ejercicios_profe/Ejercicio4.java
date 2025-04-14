package programacion.tema15_16.ejercicios_profe;

public class Ejercicio4 {
    public static void main(String[] args) {
        IImpuesto iva1 = (a, b) -> a + b;
        System.out.println(iva1.aplicar(50, 10));
    }
}
