package content.EjerciciosB;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import utilidades.Persona;

public class Ejercicio9B {

    public static void main(String[] args) {
        URL url = Ejercicio9B.class.getClassLoader().getResource("Documentos/datos_personas.bin");
        List<Persona> personas = new ArrayList<>();
        try {
            Path ruta = Paths.get(url.toURI());
            try (ObjectInputStream oos = new ObjectInputStream(Files.newInputStream(ruta))) {
                personas = (ArrayList<Persona>) oos.readObject();
                System.out.println("Cantidad de personas: " + personas.size());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.getMessage();
        }

        List<Persona> personasMayores20 = personas.stream().filter(s -> s.getEdad() > 19 && s.getEdad() < 30).toList();
        System.out.println("Cantidad de personas en los veinte: " + personasMayores20.size());
        Path ruta = Paths
                .get("prog-maven/tema12-ficheros/src/main/java/content/EjerciciosB/resultado9/datos_veintes.ser");

        try (ObjectOutputStream osi = new ObjectOutputStream(
                Files.newOutputStream(ruta, StandardOpenOption.CREATE))) {
            osi.writeObject(personasMayores20);
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
