package content.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Date;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * La clase {@code MiniFileManager} gestiona las operaciones relacionadas con el
 * sistema de archivos,
 * como cambiar de directorio, listar archivos, crear directorios, eliminar y
 * mover archivos.
 * Además, gestiona la creación del prompt y la obtención de la información del
 * usuario y del sistema.
 */
class MiniFileManager {

    /**
     * Nombre del usuario que está ejecutando la terminal.
     */
    private static String username;

    /**
     * Nombre del ordenador donde se está ejecutando la terminal.
     */
    private static String computerName;

    /**
     * Colores para los mensajes en la terminal.
     * Verde para el nombre de usuario y el host, y azul para el directorio.
     */
    public static final String GREEN = "\033[1;32m";
    public static final String BLUE = "\033[1;34m";
    public static final String RESET = "\033[0m"; // Reset para volver al color normal

    /**
     * Nombre del sistema operativo en el que se está ejecutando el programa.
     */
    private static final String os = System.getProperty("os.name").toLowerCase();

    /**
     * Obtiene el nombre del ordenador desde la red.
     *
     * @return El nombre del ordenador.
     */
    public String getComputername() {
        try {
            computerName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            computerName = "unknown-host";
        }
        return computerName;
    }

    /**
     * Obtiene el nombre del usuario que está ejecutando el programa.
     *
     * @return El nombre del usuario.
     */
    public String getUsername() {
        if (os.contains("win")) {
            // Para Windows
            username = System.getenv("USERNAME");
        } else {
            // Para Linux/Unix/Mac
            username = System.getenv("USER");
        }
        return username;
    }

    /**
     * Genera el prompt que se muestra en la terminal, incluyendo el nombre del
     * usuario,
     * el nombre del ordenador y el directorio actual.
     *
     * @return El prompt formateado de la terminal.
     */
    public String getPrompt() {
        String prompt = MiniTerminal.getDirectorioActual().getAbsolutePath().replace('\\', '/');
        if (os.contains("win"))
            prompt = prompt.substring(2, prompt.length()); // Elimina la letra de la unidad en Windows

        return String.format("%s%s@%s%s:~%s%s%s$  ", GREEN, getUsername(), getComputername(), RESET, BLUE, prompt,
                RESET);
    }

    /**
     * Devuelve la ruta del directorio actual.
     *
     * @return La ruta del directorio actual.
     */
    public String getPwd() {
        return MiniTerminal.getDirectorioActual().getPath();
    }

    /**
     * Cambia el directorio actual a un nuevo directorio especificado por el
     * parámetro {@code dir}.
     * Permite navegar hacia el directorio padre con el comando `..`.
     * Si el directorio no existe, muestra un mensaje de error.
     *
     * @param dir El nombre del directorio al que se desea cambiar.
     */
    public void cd(String dir) {
        switch (dir) {
            case "." -> {
                System.out.println("bash: cd: " + dir + ": No es un directorio");
                return;
            }

            case ".." -> {
                File actual = MiniTerminal.getDirectorioActual();

                if (actual == null)
                    return;

                File padre = actual.getParentFile();

                if (padre == null || actual.getAbsolutePath().equals("/"))
                    return;

                MiniTerminal.directorioActual = padre;
                return;
            }

            default -> {
                if (dir.matches("\\.{3,}")) {
                    System.out.println("bash: cd: " + dir + ": No es un directorio");
                    return;
                }
            }
        }

        File file = new File(MiniTerminal.getDirectorioActual(), dir).getAbsoluteFile();

        if (file.isDirectory()) {
            MiniTerminal.directorioActual = file;
        } else {
            System.out.println("bash: cd: " + dir + ": No es un directorio");
        }
    }

    /**
     * Devuelve la información básica de un archivo o directorio (tamaño y fecha de
     * modificación).
     *
     * @param ruta El archivo o directorio.
     * @return Una cadena con la información formateada del archivo.
     */
    public static String info(File ruta) {
        Date fecha = new Date(ruta.lastModified());
        return String.format("%-10d %-20s ", ruta.length(), fecha);
    }

    /**
     * Muestra una lista de los archivos y directorios dentro de un directorio
     * especificado.
     * Si el parámetro {@code info} es {@code true}, se muestra información
     * adicional
     * (tamaño y fecha de modificación).
     *
     * @param ruta El directorio en el que se realizará la lista.
     * @param info Indica si se debe mostrar la información adicional de los
     *             archivos.
     * @throws FileNotFoundException Si el directorio no existe o no es accesible.
     */
    public void ls(File ruta, boolean info) throws FileNotFoundException {
        if (!ruta.exists() || !ruta.isDirectory()) {
            System.out.println("bash: No es un directorio");
            return;
        }

        File[] dirfil = ruta.listFiles();
        Arrays.sort(dirfil, Comparator.comparing(File::isFile)); // Ordenar archivos y directorios
        if (info)
            System.out.printf("%-10s %-20s %-12s\n", "Tamaño", "UltimaModificacion", "Nombre");
        for (File file : dirfil) {
            if (file.isDirectory())
                System.out.printf("%s %s%s%s  \n", info ? info(file) : "", BLUE, file.getName(), RESET);

            if (file.isFile())
                System.out.printf("%s %s  \n", info ? info(file) : "", file.getName());
        }
    }

    /**
     * Crea un nuevo directorio con el nombre especificado por {@code ruta}.
     *
     * @param ruta El nombre del nuevo directorio.
     */
    public void crearDirectorio(String ruta) {
        File nuevaCarpeta = new File(MiniTerminal.getDirectorioActual(), ruta);
        nuevaCarpeta.mkdir();
    }

    /**
     * Elimina un archivo o directorio especificado por {@code rutaString}.
     * Si es un directorio, elimina todos los archivos contenidos, pero deja los
     * subdirectorios intactos.
     * Si el directorio o archivo no existe, muestra un mensaje de error.
     *
     * @param rutaString El nombre del archivo o directorio a eliminar.
     */
    public void remove(String rutaString) {
        File ruta = new File(MiniTerminal.getDirectorioActual(), rutaString);
        if (!ruta.exists())
            System.out.println("bash: rm: No existe el directorio o archivo");

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
            ruta.delete();
        }
    }

    /**
     * Mueve un archivo o directorio desde {@code file1String} a
     * {@code file2String}.
     * Si el destino es un directorio, mueve el archivo o directorio dentro de él.
     * Si no se puede mover, muestra un mensaje de error.
     *
     * @param file1String El archivo o directorio origen.
     * @param file2String El destino donde se moverá el archivo o directorio.
     */
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

    /**
     * Muestra un mensaje con la lista de comandos disponibles en la terminal.
     */
    public void help() {
        System.out.println(
                """
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
                        mostrar <fichero>  Mostrará el contenido de fichero por pantalla
                        sustituir <fichero> <cadena_original> <cadena_final> sustituirá cadena_orinal por cadena_final en el fichero especificado
                        """);
    }

    /**
     * Muestra el contenido de un archivo línea por línea en la consola.
     * 
     * Este método lee un archivo especificado por su ruta, y luego imprime su
     * contenido línea por línea
     * en la consola. Si el archivo no existe, el método termina sin realizar
     * ninguna acción.
     * 
     * @param fichero El nombre o la ruta del archivo que se desea mostrar.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public void mostrar(String fichero) {
        Path ruta = Paths.get(fichero);

        if (!Files.exists(ruta))
            return;

        try {
            Files.lines(ruta).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sustituye todas las ocurrencias de una cadena en un archivo por una nueva
     * cadena.
     * 
     * Este método lee el archivo especificado por su ruta y reemplaza todas las
     * ocurrencias de la cadena
     * `cadenaOriginal` por `cadenaFinal`. Si el archivo no existe, el método
     * termina sin realizar ninguna acción.
     * Luego, sobrescribe el archivo con las líneas modificadas.
     * 
     * @param fichero        El nombre o la ruta del archivo en el que se desea
     *                       realizar el reemplazo.
     * @param cadenaOriginal La cadena que se desea reemplazar en el archivo.
     * @param cadenaFinal    La cadena que reemplazará a `cadenaOriginal` en el
     *                       archivo.
     * @throws IOException Si ocurre un error al leer o escribir el archivo.
     */
    public void sustituir(String fichero, String cadenaOriginal, String cadenaFinal) {
        Path ruta = Paths.get(fichero);

        if (!Files.exists(ruta))
            return;

        try {
            List<String> lineas = Files.lines(ruta)
                    .map(linea -> linea.contains(cadenaOriginal) ? linea.replace(cadenaOriginal, cadenaFinal) : linea)
                    .collect(Collectors.toList());

            Files.write(ruta, lineas, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
