package content.EjerciciosB;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjercicioB2 {
    public static void main(String[] args) {
        String[] linea;
        Map<String, Double> notasMedias = new HashMap<>();

        try {
            URI uri = EjercicioB2.class.getResource("Documentos/alumnos_notas.txt").toURI();
            Path ruta = Paths.get(uri);
            List<String> listaNumeros = Files.readAllLines(ruta);
            for (String line : listaNumeros) {
                if (line.isBlank())
                    break;
                linea = line.split(" ");
                notasMedias.put((linea[0] + " " + linea[1]),
                        (Arrays.stream(linea)).skip(2).mapToInt(Integer::parseInt).average().orElse(0));
            }
        } catch (IOException | URISyntaxException e) {

            e.printStackTrace();
        }

        notasMedias.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(s -> System.out.println("Nombre: " + s.getKey() + ", Nota media: " + s.getValue()));

    }
}