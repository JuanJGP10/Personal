package content.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * La clase {@code MiniTerminal} simula una terminal interactiva básica,
 * permitiendo al usuario ejecutar comandos relacionados con el sistema de
 * archivos.
 * Soporta comandos como {@code pwd}, {@code cd}, {@code ls}, {@code mkdir},
 * {@code rm},
 * {@code mv}, {@code mostrar}, {@code sustituir}, entre otros.
 */
public class MiniTerminal {

    /**
     * Directorio actual de trabajo.
     * Inicialmente se establece al directorio de trabajo del sistema operativo.
     */
    protected static File directorioActual = new File(System.getProperty("user.dir"));

    /**
     * Instancia de {@link MiniFileManager} utilizada para manejar
     * operaciones sobre el sistema de archivos.
     */
    private static MiniFileManager mfm = new MiniFileManager();

    /**
     * Devuelve el directorio actual en el que se encuentra la terminal.
     *
     * @return El directorio actual como un objeto {@link File}.
     */
    public static File getDirectorioActual() {
        return directorioActual;
    }

    /**
     * Valida si el número de argumentos proporcionado para un comando
     * se encuentra dentro de los límites esperados.
     *
     * @param comando Nombre del comando.
     * @param args    Argumentos pasados al comando.
     * @param min     Número mínimo de argumentos esperados.
     * @param max     Número máximo de argumentos permitidos.
     * @return {@code true} si el número de argumentos es válido; {@code false} en
     *         caso contrario.
     */
    private static boolean validarArgumentos(String comando, String[] args, int min, int max) {
        if (args.length < min) {
            System.out.println("Faltan argumentos");
        } else if (args.length > max) {
            System.out.println("Demasiados argumentos");
        }
        return args.length >= min && args.length <= max;
    }

    /**
     * Método principal que inicia la ejecución de la terminal.
     * Lee comandos desde la entrada estándar y ejecuta la lógica correspondiente
     * llamando a métodos de {@link MiniFileManager}.
     *
     * @param args Argumentos de línea de comandos (no utilizados en esta
     *             implementación).
     */
    public static void main(String[] args) {
        String comando;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Bucle principal de ejecución de la terminal
        while (running) {
            // Muestra el prompt actual
            System.out.print(mfm.getPrompt());

            // Lee la línea introducida por el usuario
            comando = scanner.nextLine().trim();

            // Separa los argumentos considerando comillas dobles
            String[] argumentos = comando.split(" (?=([^\"]*\"[^\"]*\")*[^\"]*$)");

            // Elimina comillas al inicio y final de cada argumento
            for (int i = 0; i < argumentos.length; i++) {
                argumentos[i] = argumentos[i].replaceAll("^\"|\"$", "");
            }

            // Procesa el comando
            switch (argumentos[0]) {

                case "pwd" ->
                    System.out.println(validarArgumentos("pwd", argumentos, 1, 1) ? mfm.getPwd() : "");

                case "cd" -> {
                    if (validarArgumentos("cd", argumentos, 2, 2)) {
                        try {
                            mfm.cd(argumentos[1]);
                        } catch (FileManagerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case "ls" -> {
                    if (validarArgumentos("ls", argumentos, 1, 1)) {
                        try {
                            mfm.ls(directorioActual, false);
                        } catch (FileNotFoundException e) {
                            System.out.println("No se encontró el archivo o directorio");
                        } catch (FileManagerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case "ll" -> {
                    if (validarArgumentos("ll", argumentos, 1, 1)) {
                        try {
                            mfm.ls(directorioActual, true);
                        } catch (FileNotFoundException e) {
                            System.out.println("No se encontró el archivo o directorio");
                        } catch (FileManagerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case "mkdir" -> {
                    if (validarArgumentos("mkdir", argumentos, 2, 2)) {
                        try {
                            mfm.crearDirectorio(argumentos[1]);
                        } catch (FileManagerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case "rm" -> {
                    if (validarArgumentos("rm", argumentos, 2, 2)) {
                        try {
                            mfm.remove(argumentos[1]);
                        } catch (FileManagerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case "mv" -> {
                    if (validarArgumentos("mv", argumentos, 3, 3)) {
                        try {
                            mfm.move(argumentos[1], argumentos[2]);
                        } catch (FileManagerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case "help" -> mfm.help();

                case "mostrar" -> {
                    if (validarArgumentos("mostrar", argumentos, 2, 2)) {
                        try {
                            mfm.mostrar(argumentos[1]);
                        } catch (FileManagerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case "sustituir" -> {
                    if (validarArgumentos("sustituir", argumentos, 4, 4)) {
                        try {
                            mfm.sustituir(argumentos[1], argumentos[2], argumentos[3]);
                        } catch (FileManagerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case "exit" -> running = false;

                default -> System.out.println("Comando no reconocido");
            }
        }

        scanner.close();
    }
}
