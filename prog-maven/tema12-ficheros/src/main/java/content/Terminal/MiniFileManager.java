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
 * La clase {@code MiniFileManager} proporciona funcionalidades para manipular
 * el
 * sistema de archivos de forma similar a una terminal.
 * Incluye operaciones como navegar entre directorios, listar contenido,
 * crear o eliminar archivos/directorios, mover archivos, y más.
 */
class MiniFileManager {

    /** Nombre del usuario que está ejecutando el programa. */
    private static String username;

    /** Nombre del host o equipo donde se ejecuta el programa. */
    private static String computerName;

    /** Constantes de color para resaltar en el prompt (verde, azul, reset). */
    public static final String GREEN = "\033[1;32m";
    public static final String BLUE = "\033[1;34m";
    public static final String RESET = "\033[0m";

    /** Nombre del sistema operativo actual en minúsculas. */
    private static final String os = System.getProperty("os.name").toLowerCase();

    /**
     * Obtiene el nombre del host (equipo) actual.
     * 
     * @return nombre del equipo o "unknown-host" si no puede determinarse.
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
     * Obtiene el nombre del usuario actual del sistema operativo.
     * 
     * @return nombre del usuario actual.
     */
    public String getUsername() {
        if (os.contains("win")) {
            username = System.getenv("USERNAME");
        } else {
            username = System.getenv("USER");
        }
        return username;
    }

    /**
     * Genera el prompt de la terminal personalizado con usuario, host y ruta.
     * 
     * @return Cadena del prompt formateado.
     */
    public String getPrompt() {
        String prompt = MiniTerminal.getDirectorioActual().getAbsolutePath().replace('\\', '/');
        if (os.contains("win"))
            prompt = prompt.substring(2); // Omitir letra de unidad (ej. C:) en Windows
        return String.format("%s%s@%s%s:~%s%s%s$  ", GREEN, getUsername(), getComputername(), RESET, BLUE, prompt,
                RESET);
    }

    /**
     * Retorna la ruta actual como una cadena.
     * 
     * @return Ruta actual del directorio.
     */
    public String getPwd() {
        return MiniTerminal.getDirectorioActual().getPath();
    }

    /**
     * Cambia el directorio de trabajo actual al especificado.
     * 
     * @param dir Nombre del directorio destino.
     * @return true si el cambio se realizó correctamente.
     * @throws FileManagerException si el directorio no existe o es inválido.
     */
    public boolean cd(String dir) throws FileManagerException {
        switch (dir) {
            case "." -> throw new FileManagerException("/. No es un directorio");
            case ".." -> {
                File actual = MiniTerminal.getDirectorioActual();
                File padre = actual.getParentFile();
                if (actual == null || padre == null || actual.getAbsolutePath().equals("/"))
                    return false;
                MiniTerminal.directorioActual = padre;
                return true;
            }
            default -> {
                if (dir.matches("\\.{3,}"))
                    throw new FileManagerException("/" + dir + " No es un directorio");
            }
        }

        File nuevoDir = new File(MiniTerminal.getDirectorioActual(), dir).getAbsoluteFile();
        if (!nuevoDir.isDirectory())
            throw new FileManagerException("/" + dir + " No es un directorio");
        MiniTerminal.directorioActual = nuevoDir;
        return true;
    }

    /**
     * Devuelve información sobre el archivo: tamaño y fecha de modificación.
     * 
     * @param ruta Archivo o directorio.
     * @return Cadena con tamaño y fecha.
     */
    public static String info(File ruta) {
        Date fecha = new Date(ruta.lastModified());
        return String.format("%-10d %-20s ", ruta.length(), fecha);
    }

    /**
     * Lista los archivos y carpetas de un directorio.
     * 
     * @param ruta Directorio a listar.
     * @param info true para mostrar información detallada.
     * @throws FileNotFoundException si el directorio no existe.
     * @throws FileManagerException  si no es un directorio válido.
     */
    public void ls(File ruta, boolean info) throws FileNotFoundException, FileManagerException {
        if (!ruta.exists() || !ruta.isDirectory())
            throw new FileManagerException(ruta.getName() + " No es un directorio");

        File[] archivos = ruta.listFiles();
        Arrays.sort(archivos, Comparator.comparing(File::isFile)); // Directorios antes que archivos

        if (info)
            System.out.printf("%-10s %-20s %-12s\n", "Tamaño", "UltimaModificacion", "Nombre");

        for (File f : archivos) {
            if (f.isDirectory())
                System.out.printf("%s %s%s%s  \n", info ? info(f) : "", BLUE, f.getName(), RESET);
            else
                System.out.printf("%s %s  \n", info ? info(f) : "", f.getName());
        }
    }

    /**
     * Crea un nuevo directorio en la ubicación actual.
     * 
     * @param ruta Nombre del nuevo directorio.
     * @throws FileManagerException si ya existe.
     */
    public void crearDirectorio(String ruta) throws FileManagerException {
        File nuevaCarpeta = new File(MiniTerminal.getDirectorioActual(), ruta);
        if (nuevaCarpeta.exists())
            throw new FileManagerException(" Ya existe este directorio");
        nuevaCarpeta.mkdir();
    }

    /**
     * Elimina archivos o contenido de un directorio.
     * 
     * @param rutaString Ruta del archivo o directorio.
     * @throws FileManagerException si el archivo no existe o tiene subcarpetas.
     */
    public void remove(String rutaString) throws FileManagerException {
        File ruta = new File(MiniTerminal.getDirectorioActual(), rutaString);
        if (!ruta.exists())
            throw new FileManagerException("No existe el archivo o direcorio");

        if (ruta.isFile()) {
            ruta.delete();
            return;
        }

        boolean tieneSubcarpetas = false;
        for (File f : ruta.listFiles()) {
            if (f.isDirectory())
                tieneSubcarpetas = true;
            else
                f.delete();
        }

        if (tieneSubcarpetas)
            throw new FileManagerException("Aviso: El directorio tiene subcarpetas, dejando intactas...");

        ruta.delete(); // Intenta borrar si quedó vacío
    }

    /**
     * Mueve un archivo/directorio a otro destino.
     * 
     * @param file1String Ruta de origen.
     * @param file2String Ruta de destino.
     * @throws FileManagerException si falla la operación.
     */
    public void move(String file1String, String file2String) throws FileManagerException {
        File file1 = new File(MiniTerminal.getDirectorioActual(), file1String);
        File file2 = new File(MiniTerminal.getDirectorioActual(), file2String);

        if (!file1.exists())
            throw new FileManagerException("No existe el directorio o archivo");

        if (file2.isDirectory())
            file2 = new File(file2, file1.getName());

        if (!file1.renameTo(file2))
            throw new FileManagerException("Error al mover ");
    }

    /**
     * Muestra todos los comandos disponibles de la terminal.
     */
    public void help() {
        System.out.println(
                """
                        Comandos ->
                        pwd                             (muestra la ruta actual)
                        cd <DIR>                        (cambia de directorio)
                        ls                              (lista carpetas y archivos)
                        ll                              (lista con información adicional)
                        mkdir <DIR>                     (crea un nuevo directorio)
                        rm <FILE>                       (elimina archivos dentro de un directorio)
                        mv <FILE1> <FILE2>              (mueve o renombra un archivo/directorio)
                        mostrar <FICHERO>               (muestra el contenido de un archivo)
                        sustituir <FICHERO> <ORI> <FIN> (reemplaza cadenas en archivo)
                        help                            (muestra este mensaje)
                        exit                            (sale de la terminal)
                        """);
    }

    /**
     * Muestra el contenido de un archivo en consola.
     * 
     * @param fichero Nombre del archivo a mostrar.
     * @throws FileManagerException si no es un archivo válido.
     */
    public void mostrar(String fichero) throws FileManagerException {
        File file = new File(MiniTerminal.getDirectorioActual(), fichero);
        Path ruta = Paths.get(file.toURI());

        if (!Files.exists(ruta))
            throw new FileManagerException("No es un fichero");

        try {

            Files.lines(ruta).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sustituye una cadena por otra dentro de un archivo de texto.
     * 
     * @param fichero        Nombre del archivo.
     * @param cadenaOriginal Cadena a buscar.
     * @param cadenaFinal    Cadena que la reemplaza.
     * @throws FileManagerException si el archivo no es válido.
     */
    public void sustituir(String fichero, String cadenaOriginal, String cadenaFinal) throws FileManagerException {

        File file = new File(MiniTerminal.getDirectorioActual(), fichero);
        Path ruta = Paths.get(file.toURI());

        if (!Files.exists(ruta))
            throw new FileManagerException("No es un fichero");

        try {

            List<String> lineas = Files.lines(ruta)
                    .map(l -> l.contains(cadenaOriginal) ? l.replace(cadenaOriginal, cadenaFinal) : l)
                    .collect(Collectors.toList());

            Files.write(ruta, lineas, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
