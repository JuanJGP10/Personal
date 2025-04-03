package content.EjerciciosA.ej3;

import java.io.File;

public class EjercicioA3 {
    public static void main(String[] args) {
        File f1 = new File("1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej3/Documentos");
        File f12 = new File("1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej3/DOCS");
        File f2 = new File("1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej3/DOCS/Fotografias");
        File f22 = new File("1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej3/DOCS/FOTOS");
        File f3 = new File("1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej3/DOCS/Libros");
        File f32 = new File("1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej3/DOCS/LIBROS");

        f1.renameTo(f12);
        f2.renameTo(f22);
        f3.renameTo(f32);

        File[] foto = f22.listFiles();
        for (int i = 0; i < foto.length; i++) {
            String nuevoNombre = foto[i].getName().substring(0, foto[i].getName().lastIndexOf("."));
            File nuevaRuta = new File(foto[i].getParent(), nuevoNombre);
            foto[i].renameTo(nuevaRuta);
        }

        File[] libro = f32.listFiles();
        for (int i = 0; i < libro.length; i++) {
            String nuevoNombre = libro[i].getName().substring(0, libro[i].getName().lastIndexOf("."));
            File nuevaRuta = new File(libro[i].getParent(), nuevoNombre);
            libro[i].renameTo(nuevaRuta);
        }
    }

}
