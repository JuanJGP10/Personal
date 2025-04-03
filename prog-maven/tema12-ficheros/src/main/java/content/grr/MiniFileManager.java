package content.grr;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Comparator;

class MiniFileManager {

    public String getPwd() {
        return MiniTerminal.getDirectorioActual().getPath();
    }

    public void cd(String dir) {

        if (dir.equals("..")) {

            File actual = MiniTerminal.getDirectorioActual();

            if (actual == null)
                return;

            File padre = actual.getParentFile();

            if (padre == null || actual.getAbsolutePath().equals("/"))
                return;

            MiniTerminal.directorioActual = padre;
            return;

        }

        /*
         * Java interpreta "............" como un nombre de directorio, no como
         * múltiples ...
         * 
         * Como el directorio no existe, Java lo trata como una nueva ruta relativa y
         * simplemente lo añade a la ruta actual.
         */

        if (dir.contains("..")) {
            System.out.println("bash: cd: " + dir + ": No es un directorio");
            return;
        }

        File file = new File(getPwd() + "/" + dir);

        if (file.isDirectory()) {
            MiniTerminal.directorioActual = file;
        } else {
            System.out.println("bash: cd: " + dir + ": No es un directorio");
        }

    }

    public static String info(File ruta) {
        Date fecha = new Date(ruta.lastModified());
        return String.format("%-5d %-10s ", ruta.length(), fecha);
    }

    public void ls(File ruta, boolean info) throws FileNotFoundException {

        if (!ruta.exists())
            System.out.println("bash: No es un directorio");
        if (ruta.exists() && ruta.isDirectory()) {

            File[] dirfil = ruta.listFiles();
            Arrays.sort(dirfil, Comparator.comparing(File::isFile));
            // int contador = 0;
            for (int i = 0; i < dirfil.length; i++) {

                if (dirfil[i].isDirectory())
                    System.out.printf("%s %s%s%s  \n", info ? info(dirfil[i]) : "", MiniTerminal.BLUE,
                            dirfil[i].getName(), MiniTerminal.RESET);

                if (dirfil[i].isFile())

                    System.out.printf("%s %s  \n", info ? info(dirfil[i]) : "", dirfil[i].getName());

                // Idea para diseño de interiores

                // contador++;

                // if (contador == 4) {
                // System.out.print("\n");
                // contador = 0;
                // }

                // if (dirfil[i].equals(dirfil[dirfil.length - 1]))
                // System.out.print("\n");

            }
        }

    }

    public void crearDirectorio(String ruta) {
        File nuevaCarpeta = new File(ruta);
        nuevaCarpeta.mkdir();
    }

    public void remove(String rutaString) {
        File ruta = new File(rutaString);
        if (ruta.exists() && ruta != null) {
            if (ruta.isFile())
                ruta.delete();

            if (ruta.isDirectory()) {
                File[] ficheros = ruta.listFiles();
                for (File file : ficheros) {
                    if (file.isFile())
                        file.delete();
                    if (file.isDirectory())
                        System.out.println("Aviso: Directorio encontrado, dejando intacto");
                }
            }

            ruta.delete();
        } else
            System.out.println("bash: rm: No existe el directorio o archivo");

    }

    public void move(String file1String, String file2String) {
        File file1 = new File(MiniTerminal.getDirectorioActual(), file1String);
        File file2 = new File(MiniTerminal.getDirectorioActual(), file2String);

        if (!file1.exists()) {
            System.out.println("bash: mv: No existe el directorio o archivo");
            return;
        }

        if (file2.isDirectory()) {
            file2 = new File(file2, file1.getName());
        }

        if (!file1.renameTo(file2)) {
            System.out.println("bash: mv: Error al mover ");
        }
    }

    public void help() {
        System.out.println("""
                Comandos ->
                pwd (mostrar ruta actual)
                cd <DIR> (cambiar de directorio a <DIR>)
                ls (muestra carpetas y archivos)
                ll (muestra carpetas, archivos y informacion sobre ellos)
                mkdir <DIR> (crea un directorio con de nombre de <DIR>)
                rm <FILE> (borra los archivos de dentro del directorio <File>)
                mv <FILE1> <FILE2> (cambia el archivo desde <FILE1> a <FILE2>)
                help (muestra los comandos disponibles)
                exit (salir de la terminal)
                """);
    }

}