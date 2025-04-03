package content.EjerciciosA.ej5;

import java.io.File;
import java.io.FileNotFoundException;

public class Ej5 {
    public static void main(String[] args) {
        File fotos = new File(
                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej5/Documentos/Mis_cosas/Fotografias");
        File libros = new File(
                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej5/Documentos/Mis_cosas/Libros");
        File alfabeto = new File(
                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej5/Documentos/Alfabeto");
        File misCosas = new File(
                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej5/Documentos/Mis_cosas");
        File documentos = new File(
                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej5/Documentos");

        try {
            System.out.println("Directorio fotos borrado: " + borraTodo(fotos));
            System.out.println("Directorio libros borrado: " + borraTodo(libros));
            System.out.println("Directorio alfabeto borrado: " + borraTodo(alfabeto));
            System.out.println("Directorio misCosas borrado: " + borraTodo(misCosas));
            System.out.println("Directorio documento borrado: " + borraTodo(documentos));
            // Funciona
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean borraTodo(File f) throws FileNotFoundException {
        if (f.exists()) {
            if (f.isFile())
                f.delete();
            if (f.isDirectory()) {
                for (File file : f.listFiles()) {
                    if (file.isDirectory())
                        borraTodo(file);
                    file.delete();
                }
            }
            return f.delete();
        } else {
            throw new FileNotFoundException();
        }
    }
}
