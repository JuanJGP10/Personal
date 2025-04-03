package content.EjerciciosB;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                Persona p = (Persona) oos.readObject();
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (URISyntaxException e) {
            e.getMessage();
        }

    }
}
