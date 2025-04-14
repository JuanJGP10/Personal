package programacion.tema15_16.ejercicios_profe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Ejercicio10 {
    public static void main(String[] args) {
        List<Curso> cursos = generarCursos(20);

        System.out.println(
                "Número de cursos que duran más de 5 horas: " + cursos.stream().filter(c -> c.duracion() > 5).count());
        System.out.println(
                "Número de cursos que duran más de 5 horas: " + cursos.stream().filter(c -> c.duracion() < 2).count());

        System.out.println("\nListar el título de cursos con más de 50 vídeos");
        cursos.stream().filter(c -> c.videos() > 50).map(c -> c.titulo()).forEach(System.out::println);
        System.out.println("\nMostrar el título de los 3 cursos con mayor duración");
        cursos.stream().sorted(Comparator.comparingDouble(Curso::duracion).reversed()).limit(3).map(Curso::titulo)
                .forEach(System.out::println);
        // cursos.stream().sorted(Comparator.comparingDouble(Curso::duracion).reversed()).limit(3).forEach(c->System.out.println(c.titulo()+":"+c.duracion()));

        System.out.println("Duración total de todos los cursos: " + cursos.stream().mapToDouble(Curso::duracion).sum());

        double promedio = cursos.stream().mapToDouble(Curso::duracion).average().orElse(0);
        System.out.println("\nMostrar cursos que superen el promedio de duración: " + promedio);
        cursos.stream().filter(curso -> curso.duracion() > promedio).forEach(System.out::println);

        System.out.println("\nMostrar la duración de cursos con menos de 500 alumnos");
        cursos.stream().filter(c -> c.alumnos() < 500).map(Curso::duracion).forEach(System.out::println);

        System.out.println("\nEl curso con mayor duración: " +
                cursos.stream().sorted(Comparator.comparing(Curso::duracion).reversed()).findFirst().get());

        // Set<String>
        // titulos=cursos.stream().map(Curso::titulo).collect(Collectors.toSet());
        System.out.println("\nCrear una lista de Strings con los títulos de los cursos");
        List<String> titulos = cursos.stream().map(Curso::titulo).toList();
        titulos.forEach(System.out::println);

    }

    public static List<Curso> generarCursos(int cantidad) {
        List<Curso> cursos = new ArrayList<>();

        for (int i = 1; i <= cantidad; i++) {
            String titulo = "Curso " + i;
            double duracion = ThreadLocalRandom.current().nextDouble(1, 10);
            int videos = ThreadLocalRandom.current().nextInt(1, 60);
            int alumnos = ThreadLocalRandom.current().nextInt(1, 1001);

            cursos.add(new Curso(titulo, duracion, videos, alumnos));
        }

        return cursos;
    }
}
