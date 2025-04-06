package content.EjerciciosB;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import utilidades.Persona;

public class Ejercicio8B {
    public static void main(String[] args) throws URISyntaxException {
        // Parte 1 Lee todas las personas
        Scanner scanner = new Scanner(System.in);
        URL url = Ejercicio8B.class.getClassLoader().getResource("Documentos/datos_personas.csv");
        HashMap<String, Persona> mapa = new HashMap<>();
        try {
            Path ruta = Paths.get(url.toURI());
            Files.lines(ruta).forEach(s -> {
                String[] linea = s.split(";");
                Persona p = new Persona(linea[0], linea[1], linea[2], Integer.parseInt(linea[3]));
                mapa.put(p.getDni(), p);
            });
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        // PArte 2 pide dni y lo busca
        while (true) {
            System.out.println("Dame le dni que buscas: ");
            String dni = scanner.nextLine();

            if (dni.equals("fin"))
                break;

            mapa.entrySet().stream().filter(s -> s.getKey().equals(dni))
                    .forEach(s -> System.out.println("Dni: " + s.getKey() + " Informacion: " + s.getValue()));
        }

        // Parte 3 Crea un fichero csv con los jubilados
        List<Persona> lista = mapa.entrySet().stream().filter(s -> s.getValue().esJubilado())
                .sorted(Map.Entry.comparingByKey((s1, s2) -> s1.compareTo(s2)))
                .map(Map.Entry::getValue).toList();
        File file = new File(
                "C:/Users/Juan/Desktop/Personal/prog-maven/tema12-ficheros/src/main/java/content/EjerciciosB/resultado8/datos_jubilados.csv");

        try {
            if (!file.exists())
                file.createNewFile();
            Path ruta = Paths.get(file.toURI());
            for (Persona persona : lista) {
                Files.write(ruta,
                        (persona.getDni() + ";" + persona.getNombre() + ";" + persona.getApellidos() + ";"
                                + persona.getEdad() + "\n")
                                .getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
