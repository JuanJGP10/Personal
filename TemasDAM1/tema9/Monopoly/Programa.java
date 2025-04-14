package programacion.tema9.Monopoly;

public class Programa {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        tablero.mostrarTablero();

        System.out.println("Terrenos del jugador 1:");
        System.out.println(tablero.listarTerrenos(1));

    }

}
