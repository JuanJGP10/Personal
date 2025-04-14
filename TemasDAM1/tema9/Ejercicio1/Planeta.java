package programacion.tema9.Ejercicio1;

public class Planeta extends Astros {

    private double distanciaAlSol;
    private double orbitaAlSol;
    private boolean tieneSatelites;

    public Planeta(double radioEcuatorial, double rotacionSobreSuEje, double masa, double temperaturaMedia,
            double gravedad, double distanciaAlSol, double orbitaAlSol, boolean tieneSatelites, String nombre) {

        super(radioEcuatorial, rotacionSobreSuEje, masa, temperaturaMedia, gravedad, nombre);
        this.distanciaAlSol = distanciaAlSol;
        this.orbitaAlSol = orbitaAlSol;
        this.tieneSatelites = tieneSatelites;
    }

    @Override
    public void muestra() {
        System.out.printf("""
                Planeta: %s
                Distancia al sol: %.2f
                Orbita al sol: %.2f
                Tiene satelites: %b
                Radio Ecuatorial: %.2f
                Rotacion sobre su eje: %.2f
                Masa: %.2f
                Temperatura media: %.2f
                Gravedad: %.2f

                """, nombre, distanciaAlSol, orbitaAlSol, tieneSatelites, radioEcuatorial,
                rotacionSobreSuEje, masa,
                temperaturaMedia, gravedad);
    }
}
