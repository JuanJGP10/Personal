package programacion.tema9.EjercicioZoo;

public class AnimalTerrestre extends Animal implements InterfazSaltador {
    private int metrosRecinto;
    private int longitudSalto;

    public AnimalTerrestre(String nombre, int estancia, int metrosRecinto, int longitudSalto) {
        super(nombre, estancia);
        this.metrosRecinto = metrosRecinto;
        this.longitudSalto = longitudSalto;
    }

    public int getMetrosRecinto() {
        return metrosRecinto;
    }

    public void setMetrosRecinto(int metrosRecinto) {
        this.metrosRecinto = metrosRecinto;
    }

    public int getLongitudSalto() {
        return longitudSalto;
    }

    public void setLongitudSalto(int longitudSalto) {
        this.longitudSalto = longitudSalto;
    }

    @Override
    public void ejercicio() {
        this.longitudSalto = longitudSalto + 1;
    }

    @Override
    public boolean saltar(int centimetros) {
        return this.longitudSalto > centimetros;
    }

}
