package programacion.tema9.Monopoly;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {
    private ArrayList<Casilla> casillas = new ArrayList<>();

    public Tablero() {
        // Crear instancias de las casillas individualmente
        Terreno terreno1 = new Terreno("Terreno 1", 250, 200, ColorTerreno.VERDE, 50);
        terreno1.comprar(1);
        Terreno terreno2 = new Terreno("Terreno 2", 250, 200, ColorTerreno.VERDE, 50);
        Estaciones estacionNorte = new Estaciones("Norte");
        estacionNorte.comprar(1);
        Terreno terreno3 = new Terreno("Terreno 3", 300, 350, ColorTerreno.ROJO, 100);
        Estaciones estacionSur = new Estaciones("Sur");

        // Añadir las casillas a la lista
        casillas.add(terreno1);
        casillas.add(terreno2);
        casillas.add(estacionNorte);
        casillas.add(terreno3);
        casillas.add(estacionSur);

    }

    public void mostrarTablero() {
        for (Casilla casilla : casillas) {
            System.out.println(casilla);
            if (casilla instanceof Propiedad) {
                Propiedad propiedad = (Propiedad) casilla;

                if (propiedad.getPropietario() != -1) {
                    System.out.println("La casilla tiene dueño ");
                } else {
                    System.out.println("La casilla no tiene dueño");
                }

            }
        }
    }

    public ArrayList<Terreno> listarTerrenos(int jugador) {
        ArrayList<Terreno> lista = new ArrayList<>();

        // for (Casilla casilla : casillas) {
        // if (casilla instanceof Terreno terreno) {
        // Terreno terreno = (Terreno) casilla;
        // if (terreno.getPropietario() == jugador) {
        // lista.add(terreno);
        // }
        // }
        // }
        // No hace falta castear si creas el objeto terreno en el instance of, asi lo
        // puedes hacer directamente

        for (Casilla casilla : casillas) {
            if (casilla instanceof Terreno terreno) {
                if (terreno.getPropietario() == jugador) {
                    lista.add(terreno);
                }
            }
        }

        return lista;
    }
}
