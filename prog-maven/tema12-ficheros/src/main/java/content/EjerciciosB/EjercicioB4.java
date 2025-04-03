package content.EjerciciosB;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class EjercicioB4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path rutaNombres = Path
                .of("Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/usa_nombres.txt");
        Path rutaApellidos = Path
                .of("Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/usa_apellidos.txt");

        System.out.println("Cuantos nombres quieres generar?: ");
        String cantidadNombres = scanner.nextLine();
        System.out.println("A donde quieres escribir estos nombres?:");
        String rutaFinal = scanner.nextLine();

        Path pathFinal = Path.of("Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/" + rutaFinal);

        try {
            List<String> nombres = Files.readAllLines(rutaNombres);
            List<String> apellidos = Files.readAllLines(rutaApellidos);
            ArrayList<String> nombresCompletos = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(cantidadNombres); i++) {
                nombresCompletos.add(nombres.get(ThreadLocalRandom.current().nextInt(0, nombres.size() + 1)) + " "
                        + apellidos.get(ThreadLocalRandom.current().nextInt(0, apellidos.size() + 1)));
            }
            Files.write(pathFinal, nombresCompletos, StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
