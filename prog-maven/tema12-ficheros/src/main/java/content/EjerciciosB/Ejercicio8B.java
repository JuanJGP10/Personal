package content.EjerciciosB;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import utilidades.Persona;

public class Ejercicio8B {
    public static void main(String[] args) {
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

        while (true) {
            System.out.println("Dame le dni que buscas: ");
            String dni = scanner.nextLine();

            if (dni.equals("fin"))
                break;

            mapa.entrySet().stream().filter(s -> s.getKey().equals(dni))
                    .forEach(s -> System.out.println("Dni: " + s.getKey() + " Informacion: " + s.getValue()));
        }

        url = Ejercicio8B.class.getClassLoader().getResource("Documentos/datos_jubilados.csv");
        List<String> lista = mapa.entrySet().stream().sorted(Map.Entry.comparingByKey((s1, s2) -> s1.compareTo(s2)))
                .map(s1 -> s1.getKey())
                .collect(Collectors.toList());

        try {
            Path ruta = Paths.get(url.toURI());
            for (String dni : lista) {
                Persona p = mapa.get(dni);
                if (p.esJubilado())
                    Files.write(ruta,
                            p.getDni() + ";" + p.getNombre() + ";" + p.getApellidos() + ";" + p.getEdad() + ";",
                            StandardOpenOption.WRITE);

            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

}
