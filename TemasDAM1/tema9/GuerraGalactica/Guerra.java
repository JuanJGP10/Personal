package programacion.tema9.GuerraGalactica;

import java.util.concurrent.ThreadLocalRandom;

public class Guerra {
    private Nave naveTerricolas;
    private Nave naveCyborgs;

    public Guerra() {
        this.naveTerricolas = new Nave("Terricolas");
        this.naveCyborgs = new Nave("Cyborgs");

    }

    public void empezarGuerra(Nave naveTerricolas, Nave naveCyborgs) {

        while (naveCyborgs.cuantosQuedan() != 0 && naveTerricolas.cuantosQuedan() != 0) {

            int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
            int rand2 = ThreadLocalRandom.current().nextInt(0, 10);
            int disparoC = naveCyborgs.generarDisparo(rand1);
            naveTerricolas.recibeDisparo(disparoC);

            int disparoT = naveTerricolas.generarDisparo(rand2);
            naveCyborgs.recibeDisparo(disparoT);

        }

        if (naveCyborgs.cuantosQuedan() == 0) {
            System.out.println("ganan los terricolas");
        } else {
            System.out.println("ganan lso cyborgs");
        }

    }

    public static void main(String[] args) {
        Guerra guerra = new Guerra();
        guerra.empezarGuerra(guerra.naveTerricolas, guerra.naveCyborgs);
    }
}
