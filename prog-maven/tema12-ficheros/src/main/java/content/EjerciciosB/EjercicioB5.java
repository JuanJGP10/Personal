package content.EjerciciosB;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EjercicioB5 {
    public static void main(String[] args) {
        File dicc = new File(
                "C:/Users/Juan/Desktop/Grado/1GradoSuperior/Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/Diccionario");

        dicc.mkdir();

        Path diccionario = Path.of(
                "C:/Users/Juan/Desktop/Grado/1GradoSuperior/Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/diccionario.txt");

        for (char letra = 'A'; letra <= 'Z'; letra++) {
            final char letraFinal = letra;
            Path ruta = Path.of(
                    "C:/Users/Juan/Desktop/Grado/1GradoSuperior/Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/Diccionario"
                            + "/" + (char) letra + ".txt");

            File nuevaArchivo = new File(dicc.getAbsolutePath() + "/" + letra + ".txt");

            try {

                nuevaArchivo.createNewFile();
                List<String> lineas = Files.readAllLines(diccionario);
                List<String> filtrado = lineas.stream().filter(s -> !s.isEmpty() && s.charAt(0) == letraFinal)
                        .toList();
                Files.write(ruta, filtrado);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
