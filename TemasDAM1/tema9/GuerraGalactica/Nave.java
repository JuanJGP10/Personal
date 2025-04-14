package programacion.tema9.GuerraGalactica;

import java.util.ArrayList;

public class Nave {
    private SerVivo[] tripulacion = new SerVivo[10];
    private String nombreNave;

    public Nave(String raza) {
        if (raza.equalsIgnoreCase("terricolas")) {
            this.nombreNave = "Nave Estelar";

            tripulacion[0] = (new Terricola("Terricola 1"));
            tripulacion[1] = (new Terricola("Terricola 2"));
            tripulacion[2] = (new Terricola("Terricola 3"));
            tripulacion[3] = (new Terricola("Terricola 4"));
            tripulacion[4] = (new Terricola("Terricola 5"));
            tripulacion[5] = (new Terricola("Terricola 6"));
            tripulacion[6] = (new Terricola("Terricola 7"));
            tripulacion[7] = (new Terricola("Terricola 8"));
            tripulacion[8] = (new Terricola("Terricola 9"));
            tripulacion[9] = (new Terricola("Terricola 10"));
        } else if (raza.equalsIgnoreCase("cyborgs")) {
            this.nombreNave = "Cubo Borg";

            tripulacion[0] = (new Cyborg());
            tripulacion[1] = (new Cyborg());
            tripulacion[2] = (new Cyborg());
            tripulacion[3] = (new Cyborg());
            tripulacion[4] = (new Cyborg());
            tripulacion[5] = (new Cyborg());
            tripulacion[6] = (new Cyborg());
            tripulacion[7] = (new Cyborg());
            tripulacion[8] = (new Cyborg());
            tripulacion[9] = (new Cyborg());
        } else {
            System.err.println("ERROR");
        }

    }

    public void recibeDisparo(int individuoQueRecibeElDisparo) {
        if (tripulacion[individuoQueRecibeElDisparo].vivo == true) {
            tripulacion[individuoQueRecibeElDisparo].vivo = false;
            if (tripulacion[individuoQueRecibeElDisparo] instanceof Terricola t)
                t.alcanzado();
            if (tripulacion[individuoQueRecibeElDisparo] instanceof Cyborg c)
                c.alcanzado();

        }
    }

    public int generarDisparo(int individuoQueDispara) {
        if (tripulacion[individuoQueDispara].vivo) {
            if (tripulacion[individuoQueDispara] instanceof Terricola t)
                return t.dispara(10);
            if (tripulacion[individuoQueDispara] instanceof Cyborg c)
                return c.dispara(10);
            return 0;
        } else {
            return 0;
        }

    }

    public int cuantosQuedan() {
        int vivos = 0;
        for (int i = 0; i < tripulacion.length; i++) {
            if (tripulacion[i].vivo == true) {
                vivos++;
            }
        }
        return vivos;
    }

}
