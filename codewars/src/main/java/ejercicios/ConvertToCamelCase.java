package ejercicios;

public class ConvertToCamelCase {
    static String toCamelCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ('-') || s.charAt(i) == ('_')) {
                sb.append((s.charAt(i + 1) + "").toUpperCase());
                i += 1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toCamelCase("hola_que-tal"));
    }
}
