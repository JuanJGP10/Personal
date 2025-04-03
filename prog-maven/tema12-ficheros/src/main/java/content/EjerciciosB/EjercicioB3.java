package content.EjerciciosB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EjercicioB3 {
    public static void main(String[] args) {

        Path rutaFicheroRead = Path
                .of("1GradoSuperior/Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/usa_personas.txt");
        Path rutaFicheroEdit = Path
                .of("1GradoSuperior/Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/usa_personas_sorted.txt");

        try {
            List<String> list = Files.readAllLines(rutaFicheroRead);
            list.sort(String::compareTo);
            Files.write(rutaFicheroEdit, list);

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
