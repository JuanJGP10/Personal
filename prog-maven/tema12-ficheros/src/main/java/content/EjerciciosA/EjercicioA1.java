package content.EjerciciosA;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioA1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = "e";
        while (!entrada.isBlank()) {
            entrada = scanner.nextLine();
            File file = new File(entrada);
            try {
                muestraInfoRuta(file);
            } catch (FileNotFoundException e) {

                e.getMessage();
            }
        }

    }

    public static void muestraInfoRuta(File ruta) throws FileNotFoundException {
        if (ruta.exists()) {
            if (ruta.isFile())
                System.out.println(ruta.getName());
            if (ruta.isDirectory())
                System.out.println(ruta.getName());

            String[] dirfil = ruta.list();

            for (int i = 0; i < dirfil.length; i++) {
                System.out.println(dirfil[i]);
            }
        } else {
            throw new FileNotFoundException("Fichero no encontrado");
        }

    }
}
