package content.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * La clase {@code MiniTerminal} simula una terminal básica de comandos, similar
 * a un shell.
 * Permite ejecutar comandos como {@code pwd}, {@code cd}, {@code ls},
 * {@code mkdir}, {@code rm}, {@code mv},
 * y otros para interactuar con el sistema de archivos.
 */
public class MiniTerminal {

    /**
     * Directorio actual de trabajo, por defecto es el directorio de trabajo actual
     * del sistema.
     */
    protected static File directorioActual = new File(System.getProperty("user.dir"));

    /**
     * Instancia de {@link MiniFileManager} utilizada para realizar operaciones en
     * el sistema de archivos.
     */
    private static MiniFileManager mfm = new MiniFileManager();

    /**
     * Obtiene el directorio actual de trabajo.
     *
     * @return El directorio actual.
     */
    public static File getDirectorioActual() {
        return directorioActual;
    }

    /**
     * Valida los argumentos para los comandos de la terminal.
     * Asegura que el número de argumentos esté dentro del rango válido.
     *
     * @param comando El nombre del comando que se está ejecutando.
     * @param args    Los argumentos pasados al comando.
     * @param min     El número mínimo de argumentos esperados.
     * @param max     El número máximo de argumentos esperados.
     * @return {@code true} si el número de argumentos es válido, {@code false} en
     *         caso contrario.
     */
    private static boolean validarArgumentos(String comando, String[] args, int min, int max) {
        if (args.length < min) {
            System.out.println("bash: " + comando + ": Faltan argumentos");
        } else if (args.length > max) {
            System.out.println("bash: " + comando + ": Demasiados argumentos");
        }
        return args.length >= min && args.length <= max;
    }

    /**
     * Método principal que ejecuta la terminal. Lee los comandos introducidos por
     * el usuario,
     * procesa los argumentos y llama a los métodos correspondientes en
     * {@link MiniFileManager}.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        String comando;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Bucle principal de la terminal
        while (running) {

            System.out.print(mfm.getPrompt()); // Muestra el prompt de la terminal
            comando = scanner.nextLine().trim(); // Lee el comando introducido por el usuario

            String[] argumentos = comando.split(" "); // Separa los argumentos del comando

            // Switch que ejecuta diferentes comandos dependiendo del input del usuario
            switch (argumentos[0]) {

                case "pwd" -> System.out.println(validarArgumentos("pwd", argumentos, 1, 1) ? mfm.getPwd() : "");

                case "cd" -> {
                    if (validarArgumentos("cd", argumentos, 2, 2))
                        mfm.cd(argumentos[1]);

                }

                case "ls" -> {
                    if (validarArgumentos("ls", argumentos, 1, 2)) {
                        try {
                            mfm.ls(directorioActual, false);
                        } catch (FileNotFoundException e) {
                            System.out.println("bash: ls: No se encontró el archivo o directorio");
                        }
                    }
                }

                case "ll" -> {
                    if (validarArgumentos("ll", argumentos, 1, 2)) {
                        try {
                            mfm.ls(directorioActual, true);
                        } catch (FileNotFoundException e) {
                            System.out.println("bash: ls: No se encontró el archivo o directorio");
                        }
                    }
                }

                case "mkdir" -> {
                    if (validarArgumentos("mkdir", argumentos, 2, 2))
                        mfm.crearDirectorio(argumentos[1]);

                }

                case "rm" -> {
                    if (validarArgumentos("rm", argumentos, 2, 2))
                        mfm.remove(argumentos[1]);

                }

                case "mv" -> {
                    if (validarArgumentos("mv", argumentos, 3, 3))
                        mfm.move(argumentos[1], argumentos[2]);

                }

                case "help" -> mfm.help();

                case "mostrar" -> {
                    if (validarArgumentos("mostrar", argumentos, 2, 2))
                        mfm.mostrar(argumentos[1]);
                }

                case "sustituir" -> {
                    if (validarArgumentos("sustituir", argumentos, 4, 4))
                        mfm.sustituir(argumentos[1], argumentos[2], argumentos[3]);
                }

                default -> System.out.println("bash: Comando no reconocido");

                case "exit" -> running = false;
            }
        }
    }
}
