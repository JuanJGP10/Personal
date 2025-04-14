package programacion.tema15_16.ejercicio9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Ruta del archivo de texto
        Path ruta = Paths.get(
                "C:\\Users\\Juan\\Desktop\\Grado\\1GradoSuperior\\Programacion\\src\\main\\java\\programacion\\tema15_16\\ejercicio9\\archivo.txt");

        // Leer el archivo y filtrar líneas que comienzan con "A"
        try (Stream<String> lineas = Files.lines(ruta)) {
            lineas.filter(linea -> linea.startsWith("A")) // Filtrar líneas que empiezan con "A"
                    .forEach(System.out::println); // Imprimir resultado
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
