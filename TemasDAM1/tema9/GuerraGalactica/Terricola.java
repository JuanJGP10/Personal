package programacion.tema9.GuerraGalactica;

import java.util.concurrent.ThreadLocalRandom;

public class Terricola extends SerVivo implements Guerrero {
    private final String nombre;
    public static int contador = 1;

    public Terricola(String nombre) {
        super(contador);
        contador++;
        this.nombre = nombre;
    }

    @Override
    public int dispara(int maximo) {
        int enemigo = ThreadLocalRandom.current().nextInt(1, maximo);
        System.out.println("Soy Terricola " + id + "y disparo al " + enemigo);
        return enemigo;
    }

    @Override
    public void alcanzado() {
        System.out.println("Me han dado <Terricola " + id + ">");
    }

}
