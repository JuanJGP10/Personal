package programacion.tema10.Ejercicios.Ejercicio6;

public class Main {
    public static void main(String[] args) {

        try {
            Gato gato1 = new Gato(2, "aidfha");
            gato1.imprimir();

            gato1.setNombre(null);
            gato1.imprimir();

        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

    }
}
