package programacion.codewars;

import java.util.ArrayList;

public class DuplicateEncoder {

    /*
     * The goal of this exercise is to convert a string to a new string where each
     * character in the new string is "(" if that character appears only once in the
     * original string, or ")" if that character appears more than once in the
     * original string. Ignore capitalization when determining if a character is a
     * duplicate.
     * 
     * Examples
     * "din" => "((("
     * "recede" => "()()()"
     * "Success" => ")())())"
     * "(( @" => "))(("
     */
    public String encode(String word) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (appearsMoreThanOnce(word, word.charAt(i)))
                sb.append(")");
            else
                sb.append("(");
        }
        return sb.toString();
    }

    static boolean appearsMoreThanOnce(String str, char ch) {

        int apariciones = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) + "").equalsIgnoreCase(ch + ""))
                apariciones++;
        }

        return (apariciones > 1);
    }
}
