package programacion.tema15_16.ejercicios_profe;

public class Ejercicio3 {
    public static void main(String[] args) {
        IImpuesto iva1 = (a, b) -> a + a * b / 100;
        System.out.println(iva1.aplicar(1000, 10));
    }
}
