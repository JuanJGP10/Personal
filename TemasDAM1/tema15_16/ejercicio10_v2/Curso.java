package programacion.tema15_16.ejercicio10_v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Curso {
    private String titulo;
    private float duracion; // Expresada en horas
    private int videos; // Cantidad de vídeos
    private int alumnos; // Cantidad de alumnos

    public Curso(String titulo, float duracion, int videos, int alumnos) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.videos = videos;
        this.alumnos = alumnos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public int getVideos() {
        return videos;
    }

    public void setVideos(int videos) {
        this.videos = videos;
    }

    public int getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(int alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Curso [titulo=" + titulo + ", duracion=" + duracion + ", videos=" + videos + ", alumnos="
                + alumnos
                + "]";
    }

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();

        // Agregar 20 cursos con datos simulados
        cursos.add(new Curso("Java Básico", 10.5f, 50, 200));
        cursos.add(new Curso("Java Avanzado", 15.0f, 60, 150));
        cursos.add(new Curso("Python para Principiantes", 8.0f, 40, 300));
        cursos.add(new Curso("Machine Learning", 12.5f, 45, 180));
        cursos.add(new Curso("C++ Fundamentos", 1f, 35, 220));
        cursos.add(new Curso("Desarrollo Web con React", 14.0f, 55, 250));
        cursos.add(new Curso("Bases de Datos SQL", 11.0f, 30, 270));
        cursos.add(new Curso("Ciberseguridad Básica", 7.5f, 25, 190));
        cursos.add(new Curso("Diseño UX/UI", 10.0f, 40, 230));
        cursos.add(new Curso("Redes Neuronales en Python", 13.0f, 50, 170));
        cursos.add(new Curso("Fundamentos de JavaScript", 9.5f, 40, 280));
        cursos.add(new Curso("PHP y MySQL", 10.5f, 35, 210));
        cursos.add(new Curso("Swift para iOS", 12.0f, 45, 160));
        cursos.add(new Curso("Flutter y Dart", 1f, 50, 240));
        cursos.add(new Curso("Blockchain y Criptomonedas", 11.5f, 38, 175));
        cursos.add(new Curso("Big Data con Hadoop", 13.5f, 48, 200));
        cursos.add(new Curso("Análisis de Datos con R", 10.0f, 30, 190));
        cursos.add(new Curso("Desarrollo de APIs REST", 12.0f, 42, 260));
        cursos.add(new Curso("Automatización con Selenium", 8.5f, 28, 210));
        cursos.add(new Curso("Docker y Kubernetes", 1f, 55, 220));

        // b)
        System.out.println("Cantidad de cursos con duracion mayor de 5 horas: "
                + cursos.stream().filter(s -> s.getDuracion() > 5));

        // c)
        System.out.println("-------------------------------");
        System.out.println("Cantidad de cursos con duracion menor a 2 horas: "
                + cursos.stream().filter(s -> s.getDuracion() < 2));

        // d)
        System.out.println("-------------------------------");
        System.out.println("Titulos de cursos con mas de 50 videos:");
        cursos.stream().filter(s -> s.getVideos() > 50).map(Curso::getTitulo).forEach(System.out::println);
        // e)
        System.out.println("-------------------------------");
        System.out.println("3 cursos con mayor duracion:");
        cursos.stream().limit(3).sorted((s1, s2) -> (int) s1.getDuracion() - (int) s2.getDuracion())
                .forEach(System.out::println);
        System.out.println("-------------------------------");
        // f)

        System.out.println("-------------------------------");
        System.out.println(
                "Duracion total de todos los cursos: " + cursos.stream().mapToDouble(Curso::getDuracion).sum());
        // g)

        System.out.println("-------------------------------");
        System.out.println("Cursos que superen la media de duracion de los cursos:");
        double media = cursos.stream().mapToDouble(Curso::getDuracion).average().getAsDouble();

        cursos.stream().filter(s -> s.getDuracion() > media).forEach(System.out::println);
        System.out.println("-------------------------------");
        // h)
        System.out.println("Mostrar la duracion de los cursos con menos de 500 alumnos");
        cursos.stream().filter(s -> s.getAlumnos() < 500).map(Curso::getDuracion).forEach(System.out::println);
        System.out.println("-------------------------------");
        // i)
        System.out.println("Curso con mayor duracion");
        System.out.println(cursos.stream().max((s1, s2) -> (int) s1.getDuracion() - (int) s2.getDuracion()).get());
        System.out.println("-------------------------------");
        // j)
        System.out.println("Arraylist con los titulos de los cursos");
        List<String> nombreCursos = cursos.stream().map((Curso::getTitulo)).collect(Collectors.toList());
        System.out.println("-------------------------------");
        // k)
        System.out.println("Imprimir la lista de titulos:");
        nombreCursos.forEach(System.out::println);
    }
}
