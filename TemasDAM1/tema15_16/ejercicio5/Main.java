package programacion.tema15_16.ejercicio5;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> p = new Predicate<String>() {

            @Override
            public boolean test(String t) {
                return t.matches("[A-Z]+");
            }

        };

        System.out.println(p.test("null"));
        System.out.println(p.test("NULL"));
        System.out.println(p.test("nuLL"));
    }
}
