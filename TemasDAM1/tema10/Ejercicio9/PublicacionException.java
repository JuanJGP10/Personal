package programacion.tema10.Ejercicio9;

// public class PublicacionException extends Exception {

//     public PublicacionException(String message) {
//         super(message);
//     }
// }

public class PublicacionException extends IllegalArgumentException {
    public PublicacionException(String message) {
        super(message);
    }
}