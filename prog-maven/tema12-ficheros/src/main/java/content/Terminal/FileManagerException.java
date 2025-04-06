package content.Terminal;

/**
 * La clase {@code FileManagerException} representa una excepción personalizada
 * para manejar errores relacionados con las operaciones del sistema de archivos
 * dentro de la terminal.
 *
 * Extiende la clase base {@link Exception}, lo que permite lanzar y capturar
 * esta excepción de manera específica en los métodos del gestor de archivos.
 */
public class FileManagerException extends Exception {

    /**
     * Constructor que permite crear una nueva instancia de
     * {@code FileManagerException}
     * con un mensaje de error específico.
     *
     * @param mensaje El mensaje que describe el error ocurrido.
     */
    public FileManagerException(String mensaje) {
        super(mensaje); // Llama al constructor de la clase Exception con el mensaje proporcionado
    }
}
