package programacion.tema10.Ejercicio9;

public class Main {
    public static void main(String[] args) {
        try {

            Revista revista1 = new Revista("12345678", "National Geographic", 5);
            Revista revista2 = new Revista("87654321", "Science", 10);
            Revista revista3 = new Revista("23456789", "Nature", 3);
            Revista revista4 = new Revista("34567890", "Time", 8);
            Revista revista5 = new Revista("98765432", "Forbes", 12);
            Revista revista6 = new Revista("11223344", "Popular Science", 7);

            Autor autor1 = new Autor("Isaac Asimov", "El bicho");
            Autor autor2 = new Autor("J.K. Rowling", "El meme");
            Autor autor3 = new Autor("George Orwell", "El aNIMAL");

            Libro libro1 = new Libro("9780134685991", "Fundamentals of Java", autor1);

            Libro libro2 = new Libro("9780131101630", "Introduction to Algorithms", autor1);
            Libro libro3 = new Libro("9780747532743", "Harry Potter", autor2);
            Libro libro4 = new Libro("9780451524935", "1984", autor3);
            Libro libro5 = new Libro("9780545582939", "The Casual Vacancy", autor2);
            Libro libro6 = new Libro("9780397001514", "Animal Farm", autor3);

            Biblioteca b = new Biblioteca();
            b.añadir(libro1);
            b.añadir(libro2);
            b.añadir(libro3);
            b.añadir(revista3);
            b.añadir(revista4);
            b.añadir(revista5);
            b.añadir(revista6);
            b.añadir(libro4);
            b.añadir(libro5);
            b.añadir(libro6);
            b.añadir(revista1);
            b.añadir(revista2);

            b.mostrarLineas();

        } catch (PublicacionException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ValorIncorrecto e) {
            System.out.println(e.toString());
        }

    }
}
