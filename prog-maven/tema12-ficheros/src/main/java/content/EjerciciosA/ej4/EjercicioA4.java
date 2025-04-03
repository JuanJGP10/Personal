package content.EjerciciosA.ej4;

import java.io.File;

public class EjercicioA4 {
        public static void main(String[] args) {
                File misCosas = new File(
                                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej4/Documentos/Mis_cosas");

                File alfabeto = new File(
                                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej4/Documentos/Alfabeto");

                boolean resultado1 = misCosas.mkdir();
                System.out.println("¿Se ha creado la carpeta 'Documentos/Mis Cosas'? " + resultado1);
                boolean resultado2 = alfabeto.mkdir();
                System.out.println("¿Se ha creado la carpeta 'Documentos/Mis Cosas'? " + resultado2);

                File fotOrigen = new File(
                                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej4/Documentos/Fotografias");
                File fotDestino = new File(
                                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej4/Documentos/Mis_cosas/Fotografias");

                File libOrigen = new File(
                                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej4/Documentos/Libros");
                File libDestino = new File(
                                "C:/Users/juani/Desktop/Clase/1GradoSuperior/Programacion/src/main/java/programacion/tema12/ej4/Documentos/Mis_cosas/Libros");

                fotOrigen.renameTo(fotDestino);
                libOrigen.renameTo(libDestino);

                for (int i = 65; i <= 90; i++) {
                        File nuevaCarpeta = new File(alfabeto.getParent() + "/" + alfabeto.getName() + "/" + (char) i);
                        nuevaCarpeta.mkdir();
                }
        }
}
