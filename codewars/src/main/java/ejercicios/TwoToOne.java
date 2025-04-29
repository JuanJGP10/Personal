package ejercicios;

public class TwoToOne {
    /*
     * Take 2 strings s1 and s2 including only letters from a to z. Return a new
     * sorted string (alphabetical ascending), the longest possible, containing
     * distinct letters - each taken only once - coming from s1 or s2.
     * 
     * Examples:
     * a = "xyaabbbccccdefww"
     * b = "xxxxyyyyabklmopq"
     * longest(a, b) -> "abcdefklmopqwxy"
     * 
     * a = "abcdefghijklmnopqrstuvwxyz"
     * longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
     */

    public static String longest(String s1, String s2) {
        /*
         * TreeSet<Character> ts = new TreeSet<>();
         * for (Character character : (s1 + s2).toCharArray()) {
         * ts.add(character);
         * }
         * 
         * StringBuilder sb = new StringBuilder();
         * for (Character character : ts) {
         * sb.append(character);
         * }
         * return sb.toString();
         */

        /*
         * LOCURA
         * StringBuilder sb = new StringBuilder();
         * (s1 + s2).chars().distinct().sorted().forEach(s -> sb.append((char) s));
         * return sb.toString();
         */

        // NEXT LEVEL
        return (s1 + s2).chars().distinct()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
    }
}
