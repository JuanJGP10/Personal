package programacion.tema9.Monopoly;

public class Estaciones extends Propiedad {
    private static final int VALOR_ESTACION = 100;

    public Estaciones(String nombre) {
        super(nombre, VALOR_ESTACION, VALOR_ESTACION);
    }

    @Override
    public int getAlquiler(int modificador) {
        return precio / modificador;
    }

    // Aqui no tengo q hacer un toString porque no hay atributos nuevos, hara el
    // toString de Propiedad

}