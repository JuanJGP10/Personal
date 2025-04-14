package programacion.tema9.Ejercicio1;

public abstract class Astros {
    protected String nombre;
    protected double radioEcuatorial;
    protected double rotacionSobreSuEje;
    protected double masa;
    protected double temperaturaMedia;
    protected double gravedad;

    public Astros(double radioEcuatorial, double rotacionSobreSuEje, double masa, double temperaturaMedia,
            double gravedad, String nombre) {
        this.nombre = nombre;
        this.radioEcuatorial = radioEcuatorial;
        this.rotacionSobreSuEje = rotacionSobreSuEje;
        this.masa = masa;
        this.temperaturaMedia = temperaturaMedia;
        this.gravedad = gravedad;
    }

    public abstract void muestra();
}
