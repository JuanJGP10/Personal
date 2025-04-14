package programacion.estudiarExamenTema11_15.examen2023;

import java.util.HashMap;

public class ContadorLetras {
    public static void main(String[] args) {
        HashMap<Character, Integer> mapa = new HashMap<>();

        String frase = "Decir que Java es estupendo porque funciona con todos los sistemas operativos es como decir que el sexo anal es estupendo porque funciona con todos los géneros (Alanna)";

        for (int i = 0; i < frase.length(); i++) {
            mapa.put(frase.charAt(i), mapa.getOrDefault(frase.charAt(i), 0) + 1);
        }

        mapa.entrySet().forEach(s1 -> System.out.println("Letra: " + s1.getKey() + " , Apariciones: " + s1.getValue()));
    }
}
