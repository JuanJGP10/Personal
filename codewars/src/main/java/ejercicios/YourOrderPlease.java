package ejercicios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class YourOrderPlease {
    /*
     * Your task is to sort a given string. Each word in the string will contain a
     * single number. This number is the position the word should have in the
     * result.
     * 
     * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
     * 
     * If the input string is empty, return an empty string. The words in the input
     * String will only contain valid consecutive numbers.
     * 
     * Examples
     * "is2 Thi1s T4est 3a" --> "Thi1s is2 3a T4est"
     * "4of Fo1r pe6ople g3ood th5e the2" --> "Fo1r the2 g3ood 4of th5e pe6ople"
     * "" --> ""
     */
    public static String order(String words) {
        /*
         * if (words.isEmpty())
         * return "";
         * String[] palabras = words.split(" ");
         * String[] resultado = new String[palabras.length];
         * 
         * for (String palabra : palabras) {
         * for (char caracter : palabra.toCharArray()) {
         * if (Character.isDigit(caracter)) {
         * int numero = Character.getNumericValue(caracter);
         * resultado[numero - 1] = palabra;
         * break;
         * }
         * 
         * }
         * }
         * return String.join(" ", resultado);
         */

        // WOW
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("[A-Za-z]", ""))))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
    }
}
