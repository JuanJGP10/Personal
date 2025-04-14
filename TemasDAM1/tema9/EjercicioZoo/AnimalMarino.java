package programacion.tema9.EjercicioZoo;

public class AnimalMarino extends Animal implements InterfazNadador {
    private TipoAgua tipoAgua;
    private int velocidad;

    public AnimalMarino(String nombre, int estancia, TipoAgua tipoAgua, int velocidad) {
        super(nombre, estancia);
        this.tipoAgua = tipoAgua;
        this.velocidad = velocidad;
    }

    public TipoAgua getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(TipoAgua tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void ejercicio() {
        this.velocidad = velocidad + 1;
    }

    @Override
    public int nada(int metros) {
        double metrosSegundo = this.velocidad * 0.2777778;
        return (int) (metros / metrosSegundo);
    }
}
