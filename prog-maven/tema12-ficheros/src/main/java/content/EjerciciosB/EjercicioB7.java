package content.EjerciciosB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EjercicioB7 {
    public static void main(String[] args) {
        File rutaLibros = new File(
                "C:\\Users\\Juan\\Desktop\\Grado\\1GradoSuperior\\Programacion\\src\\main\\java\\programacion\\tema12\\EjerciciosB\\Documentos\\Libros");

        File[] archivos = rutaLibros.listFiles();

        int contadorLineas = 0;

        for (int i = 0; i < archivos.length; i++) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivos[i]))) {

                if (archivos[i].isFile()) {

                    StringBuilder sb = new StringBuilder();
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        sb.append(linea).append("\n");
                        contadorLineas++;
                    }

                    String[] palabras = sb.toString().split(" ");
                    int numeroPalabras = palabras.length;
                    int numeroCaracteres = sb.toString().trim().length();

                    HashMap<String, Integer> mapa = new HashMap<>();

                    for (String palabra : palabras) {
                        if (!palabra.isBlank()/* && palabra.length() > 4 */)
                            mapa.put(palabra, mapa.getOrDefault(palabra, 0) + 1);
                    }

                    System.out.printf("""
                            _________________________________________________
                            Nombre del archivo: %s
                            Numero de lineas: %d
                            Numero de palabras: %d
                            Numero de caracteres: %d
                            10 palabras mas comunes y cuantas veces aparecen:
                            """, archivos[i].getName(), contadorLineas, numeroPalabras, numeroCaracteres);

                    mapa.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .limit(10)
                            .forEach(s -> System.out
                                    .println("Palabra: " + s.getKey() + " Apariciones: " + s.getValue()));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
