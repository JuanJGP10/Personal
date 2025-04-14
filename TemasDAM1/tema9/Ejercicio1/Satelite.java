package programacion.tema9.Ejercicio1;

public class Satelite extends Astros {

    private double distanciaAlPlaneta;
    private double orbitaPlanetaria;
    private String planetaPerteneciente;

    public Satelite(double radioEcuatorial, double rotacionSobreSuEje, double masa, double temperaturaMedia,
            double gravedad, double distanciaAlPlaneta, double orbitaPlanetaria, String planetaPerteneciente,
            String nombre) {

        super(radioEcuatorial, rotacionSobreSuEje, masa, temperaturaMedia, gravedad, nombre);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planetaPerteneciente = planetaPerteneciente;

    }

    @Override
    public void muestra() {
        System.out.printf("""
                Satelite: %s
                Distancia al planeta: %.2f
                Orbita planetaria: %.2f
                Pertenece al planeta: %s
                Radio Ecuatorial: %.2f
                Rotacion sobre su eje: %.2f
                Masa: %.2f
                Temperatura media: %.2f
                Gravedad: %.2f
                """, nombre, distanciaAlPlaneta, orbitaPlanetaria, planetaPerteneciente, radioEcuatorial,
                rotacionSobreSuEje, masa,
                temperaturaMedia, gravedad);
    }
}
