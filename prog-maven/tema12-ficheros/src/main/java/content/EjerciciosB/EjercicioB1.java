package content.EjerciciosB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EjercicioB1 {
    public static void main(String[] args) {
        /*
         * Implementa un programa que muestre por pantalla los valores máximos y mínimos
         * del
         * archivo ‘numeros.txt’.
         */

        Path ruta = Path.of(
                "1GradoSuperior/Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/numeros.txt");
        try {
            List<String> listaNumeros = Files.readAllLines(ruta);
            System.out
                    .println("Numero mas alto: " + listaNumeros.stream().mapToInt(Integer::parseInt).max().orElse(0));
            System.out.println(
                    "Numero mas pequeño: " + listaNumeros.stream().mapToInt(Integer::parseInt).min().orElse(0));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
