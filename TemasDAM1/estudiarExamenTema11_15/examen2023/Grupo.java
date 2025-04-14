package programacion.estudiarExamenTema11_15.examen2023;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import programacion.tema11.Ejercicios.ejercicio3.Persona;

public class Grupo {
    private HashSet<Personaje> grupo = new HashSet<>();

    public boolean incluirPersonajes(Personaje p) {
        if (grupo.contains(p))
            return false;

        grupo.add(p);
        return true;
    }

    public Optional<Personaje> getMiembro(String nombre) {
        return grupo.stream().filter(s -> s.getNombre().equals(nombre)).findFirst();
        // for (Personaje personaje : grupo) {
        // if (personaje.getNombre().equals(nombre))
        // return personaje;
        // }
        // return null;
    }

    public List<Mago> dameMagos() {
        List<Mago> lista = grupo.stream().filter(s -> (s instanceof Mago)).map(s -> (Mago) s)
                .collect(Collectors.toList());
        return lista;
    }

    public void retirada() {
        grupo.forEach(s -> {
            try {
                System.out.println("Entidad: " + s.getNombre() + " Se retira?: " + s.retirada());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        // for (Personaje personaje : grupo) {
        // try {
        // System.out.println("Entidad: " + personaje.getNombre() + " Se retira?: " +
        // personaje.retirada());
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }
        // }

    }

    public void mostrar() {
        grupo.forEach(System.out::println);
        System.out.println("Fuerza del grupo:  " + grupo.stream().mapToInt(Personaje::getFuerza).sum());
    }

    public int limpiarGrupo() {
        int trollsMuertos = (int) grupo.stream().filter(s -> (s instanceof Troll && s.isMuerto())).count();
        Iterator<Personaje> it = grupo.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.isMuerto())
                it.remove();
        }
        return trollsMuertos;

    }

    public void mostrarGrupo() {
        grupo.stream().sorted(Comparator.comparing(Personaje::getNombre)).forEach(System.out::println);
    }

    public void mostrarGrupoPorFuerza() {
        grupo.stream().sorted(Comparator.comparing(Personaje::getFuerza).reversed()).forEach(System.out::println);
    }

    public HashSet<Personaje> getGrupo() {
        return grupo;
    }
}
