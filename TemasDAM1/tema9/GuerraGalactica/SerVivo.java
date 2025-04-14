package programacion.tema9.GuerraGalactica;

public abstract class SerVivo {
    protected boolean vivo;
    protected final int id;

    public SerVivo(int id) {
        this.id = id;
        this.vivo = true;
    }

    public boolean estoyVivo() {
        return vivo;
    }

    public int getId() {
        return id;
    }

}
