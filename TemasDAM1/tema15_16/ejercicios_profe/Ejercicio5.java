package programacion.tema15_16.ejercicios_profe;

import java.util.function.Predicate;

public class Ejercicio5 {
    public static void main(String[] args) {
        Predicate<String> enMayusculas = new Predicate<String>() {
            @Override
            public boolean test(String arg0) {
                return arg0.equals(arg0.toUpperCase());
            }
        };

        if (enMayusculas.test("esTA no"))
            System.out.println("La cadena está en mayusculas");
        else
            System.out.println("La cadena no está en mayúsculas");

        if (enMayusculas.test("ESTA SI"))
            System.out.println("La cadena está en mayusculas");
        else
            System.out.println("La cadena no está en mayúsculas");

    }
}
