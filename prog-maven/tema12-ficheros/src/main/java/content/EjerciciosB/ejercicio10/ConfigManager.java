package content.EjerciciosB.ejercicio10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private Properties config;

    public ConfigManager() {
        config = new Properties();
    }

    public void loadConfig() {
        try (FileInputStream fichero = new FileInputStream(
                "prog-maven/tema12-ficheros/src/main/java/content/EjerciciosB/ejercicio10/config.properties")) {
            config.load(fichero);
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public String getNombreEmpresa() {
        return config.getProperty("empresa.nombre");
    }

    public int getMaximoIntentos() {
        return Integer.parseInt(config.getProperty("login.max_intentos"));

    }

    public int getSesionTimeout() {
        return Integer.parseInt(config.getProperty("sesion.timeout"));
    }

}
