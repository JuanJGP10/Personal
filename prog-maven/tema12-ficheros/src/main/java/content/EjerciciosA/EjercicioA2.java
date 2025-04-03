package content.EjerciciosA;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EjercicioA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = "e";
        while (!entrada.isBlank()) {
            entrada = scanner.nextLine();
            File file = new File(entrada);
            try {
                muestraInfoRuta(file, true);
            } catch (FileNotFoundException e) {

                System.out.println(e.getMessage());
            }
        }

    }

    public static void muestraInfoRuta(File ruta, boolean info) throws FileNotFoundException {

        if (ruta.exists()) {
            if (ruta.isFile()) {
                System.out.printf("[A] %s %s\n", ruta.getName(), info ? info(ruta) : "");

            }

            if (ruta.isDirectory()) {
                File[] dirfil = ruta.listFiles();
                Arrays.sort(dirfil, Comparator.comparing(File::isFile));

                for (int i = 0; i < dirfil.length; i++) {
                    if (dirfil[i].isDirectory())
                        System.out.printf("[*] %s %s\n", dirfil[i].getName(), info ? info(dirfil[i]) : "");
                    if (dirfil[i].isFile())
                        System.out.printf("[A] %s %s\n", dirfil[i].getName(), info ? info(dirfil[i]) : "");
                }
            }
        } else {
            throw new FileNotFoundException("Fichero no encontrado");
        }

    }

    public static String info(File ruta) {
        Date fecha = new Date(ruta.lastModified());
        return String.format("Bytes: %-5s LastModified: %-10s ", String.valueOf(ruta.length()), fecha);
    }
}