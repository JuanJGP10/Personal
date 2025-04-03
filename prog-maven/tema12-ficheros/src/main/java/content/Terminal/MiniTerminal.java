package content.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.util.Scanner;
import java.net.UnknownHostException;

public class MiniTerminal {
    protected static File directorioActual = new File(System.getProperty("user.dir"));
    private static MiniFileManager mfm = new MiniFileManager();
    private static String username;
    private static String computerName;
    public static final String GREEN = "\033[1;32m"; // Verde para usuario@host
    public static final String BLUE = "\033[1;34m"; // Azul para el directorio
    public static final String RESET = "\033[0m"; // Reset para volver al color normal
    private static final String os = System.getProperty("os.name").toLowerCase();

    public static String getComputername() {
        try {
            computerName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            computerName = "unknown-host";
        }
        return computerName;
    }

    public static String getUsername() {

        if (os.contains("win")) {
            // Para Windows
            username = System.getenv("USERNAME");
        } else {
            // Para Linux/Unix/Mac
            username = System.getenv("USER");
        }
        return username;
    }

    public static File getDirectorioActual() {
        return directorioActual;
    }

    public static String getPrompt() {

        String prompt = directorioActual.getAbsolutePath().replace('\\', '/');
        if (os.contains("win"))
            prompt = prompt.substring(2, prompt.length());

        return String.format("%s%s@%s%s:~%s%s%s$  ", GREEN, getUsername(), getComputername(), RESET, BLUE, prompt,
                RESET);
    }

    public static void main(String[] args) {
        String comando;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.print(getPrompt());
            comando = scanner.nextLine().trim();

            String[] argumentos = comando.split(" ", 3);

            switch (argumentos[0]) {

                case "pwd" -> {
                    if (argumentos.length == 1)
                        System.out.println(mfm.getPwd());
                    else
                        System.out.println("bash: pwd: Demasiados argumentos");
                }

                case "cd" -> {
                    if (argumentos.length == 2) {
                        mfm.cd(argumentos[1]);
                    } else
                        System.out.println("bash: cd: Demasiados argumentos");
                }

                case "ls" -> {
                    if (argumentos.length == 1) {
                        try {
                            mfm.ls(directorioActual, false);
                        } catch (FileNotFoundException e) {
                            e.getMessage();
                        }
                    } else
                        System.out.println("bash: ls: Demasiados argumentos");
                }

                case "ll" -> {
                    if (argumentos.length == 1) {
                        try {
                            mfm.ls(directorioActual, true);
                        } catch (FileNotFoundException e) {
                            e.getMessage();
                        }
                    } else
                        System.out.println("bash: ll: Demasiados argumentos");
                }

                case "mkdir" -> {
                    if (argumentos.length == 2) {
                        mfm.crearDirectorio(argumentos[1]);
                    } else
                        System.out.println("bash: mkdir: Demasiados argumentos");
                }

                case "rm" -> {
                    if (argumentos.length == 2) {
                        mfm.remove(argumentos[1]);
                    } else
                        System.out.println("bash: rm: Demasiados argumentos");
                }

                case "mv" -> {
                    if (argumentos.length == 3) {
                        mfm.move(argumentos[1], argumentos[2]);
                    } else
                        System.out.println("bash: mv: Demasiados argumentos");
                }

                case "help" -> {
                    mfm.help();
                }

                default -> System.out.println("bash: Comando no reconocido");

                case "exit" -> {
                    System.out.println("Saliendo...");
                    running = false;
                }
            }
        }
    }
}
