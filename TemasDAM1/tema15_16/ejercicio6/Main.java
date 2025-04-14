package programacion.tema15_16.ejercicio6;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> p = (str) -> str.matches("[A-Z]+");

        System.out.println(p.test("null"));
        System.out.println(p.test("NULL"));
        System.out.println(p.test("nuLL"));
    }
}
