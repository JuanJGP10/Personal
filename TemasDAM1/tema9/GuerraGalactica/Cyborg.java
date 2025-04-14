package programacion.tema9.GuerraGalactica;

import java.util.concurrent.ThreadLocalRandom;

public final class Cyborg extends SerVivo implements Guerrero {

    public static int contador = 1;

    public Cyborg() {
        super(contador);
        contador++;

    }

    @Override
    public int dispara(int maximo) {
        int enemigo = ThreadLocalRandom.current().nextInt(1, maximo);
        System.out.println("Soy el Cyborg " + id + "y disparo al enemigo " + enemigo);
        return enemigo;
    }

    @Override
    public void alcanzado() {
        System.out.println("Cyborg nodo " + this.id + " destruido");
    }

}
