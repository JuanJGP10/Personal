package programacion.tema8a9;

public class CambioBases {

    public static String decimalOctal(int numero) {
        String number = String.valueOf(numero);
        if (number == null || number.equals("") || !number.matches("\\d+") || numero < 0)
            return "-1";

        StringBuilder sb = new StringBuilder();
        while (numero > 0) {
            int resto = numero % 8;
            sb.append(resto);
            numero = numero / 8;
        }

        return sb.reverse().toString();
    }

    public static String decimalHexadecimal(int numero) {
        String number = String.valueOf(numero);
        if (number == null || number.equals("") || !number.matches("\\d+") || numero < 0)
            return "-1";
        String letras = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        while (numero > 0) {
            int resto = numero % 16;
            char caracter = letras.charAt(resto);
            sb.append(caracter);
            numero = numero / 16;
        }

        return sb.reverse().toString();
    }

    public static String decimalBinario(int numero) {
        String number = String.valueOf(numero);
        if (number == null || number.equals("") || !number.matches("\\d+") || numero < 0)
            return "-1";

        StringBuilder sb = new StringBuilder();
        while (numero > 0) {
            int resto = numero % 2;
            sb.append(resto);
            numero = numero / 2;
        }

        return sb.reverse().toString();
    }

    public static int octalDecimal(String numero) {
        if (numero == null || numero.equals("") || !numero.matches("[0-7]+"))
            return -1;

        int decimal = 0;
        for (int i = 0; i < numero.length(); i++) {
            char lastNumber = numero.charAt(numero.length() - i - 1);
            decimal += Character.getNumericValue(lastNumber) * Math.pow(8, i);
        }

        return decimal;
    }

    public static int binarioDecimal(String numero) {
        if (numero == null || numero.equals("") || !numero.matches("[01]+"))
            return -1;

        int decimal = 0;
        for (int i = 0; i < numero.length(); i++) {
            char lastNumber = numero.charAt(numero.length() - i - 1);
            decimal += Character.getNumericValue(lastNumber) * Math.pow(2, i);
        }

        return decimal;
    }

    public static int hexadecimalDecimal(String numero) {

        if (numero == null || numero.equals("") || !numero.matches("[0-9A-Fa-f]+"))
            return -1;

        numero = numero.toUpperCase();
        int decimal = 0;
        String letras = "0123456789ABCDEF";
        for (int i = 0; i < numero.length(); i++) {
            char lastNumber = numero.charAt(numero.length() - i - 1);
            int lastNumberI = letras.indexOf(lastNumber);
            decimal += lastNumberI * Math.pow(16, i);
        }

        return decimal;

    }

}
