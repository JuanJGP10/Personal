package programacion.tema15_16.ejercicios_profe;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Ejercicio9 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Se tiene que indicar el nombre del archivo como parámetro");
            System.exit(1);
        }

        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
            stream.filter(linea -> linea.startsWith("A"))
                    .forEach(System.out::println);
        } catch (Exception e) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, "Error en la lectura del fichero", e);
        }

        // Accediendo al fichero desde los resources
        // try {
        // Path
        // ruta=Path.of(Ejercicio9.class.getClassLoader().getResource(args[0]).toURI());
        // try (Stream<String> stream = Files.lines(ruta)) {
        // stream.filter(linea -> linea.startsWith("A"))
        // .forEach(System.out::println);
        // } catch (Exception e) {
        // Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, "Error en la
        // lectura del fichero", e);
        // }
        // } catch (URISyntaxException e ) {
        // Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, "Error al
        // acceder al fichero", e);
        // }
    }
}
