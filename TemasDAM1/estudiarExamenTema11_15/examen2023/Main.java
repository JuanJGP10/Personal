package programacion.estudiarExamenTema11_15.examen2023;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grupo g = new Grupo();
        añadirPjs(g);

        List<Mago> list = g.dameMagos();
        list.forEach(System.out::println);

        if (g.incluirPersonajes(new Mago("Juan", 0)))
            System.out.println("Personaje añadido con exito");
        else
            System.out.println("Personaje no añadido");

        System.out.println(g.getMiembro("Troll1"));

        g.retirada();

        g.mostrar();

        for (Personaje p : list) {
            p.setMuerto(true);
        }
        g.limpiarGrupo();

        g.mostrar();

        g.mostrarGrupo();

        g.mostrarGrupoPorFuerza();
    }

    public static void añadirPjs(Grupo g) {
        g.getGrupo().add(new Troll());
        g.getGrupo().add(new Troll());
        g.getGrupo().add(new Troll());
        g.getGrupo().add(new Troll());
        g.getGrupo().add(new Troll());
        g.getGrupo().add(new Mago("Juan", 10));
        g.getGrupo().add(new Mago("Melo", 10));
        g.getGrupo().add(new Mago("Pepe", 10));
        g.getGrupo().add(new Mago("ISma", 10));
        g.getGrupo().add(new Mago("Sandra", 10));
    }
}
