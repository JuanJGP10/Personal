package programacion.tema9.EjercicioZoo;

public class Triatleta implements InterfazNadador, InterfazSaltador {
    private String nombre;
    private int velCorriendo;
    private int velNadando;
    private int velBicicleta;

    public String getNombre() {
        return nombre;
    }

    public Triatleta(String nombre, int velCorriendo, int velNadando, int velBicicleta) {
        this.nombre = nombre;
        this.velCorriendo = velCorriendo;
        this.velNadando = velNadando;
        this.velBicicleta = velBicicleta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelCorriendo() {
        return velCorriendo;
    }

    public void setVelCorriendo(int velCorriendo) {
        this.velCorriendo = velCorriendo;
    }

    public int getVelNadando() {
        return velNadando;
    }

    public void setVelNadando(int velNadando) {
        this.velNadando = velNadando;
    }

    public int getVelBicicleta() {
        return velBicicleta;
    }

    public void setVelBicicleta(int velBicicleta) {
        this.velBicicleta = velBicicleta;
    }

    @Override
    public int nada(int metros) {
        double metrosSegundo = this.velNadando * 0.2777778;
        return (int) (metros / metrosSegundo);
    }

    @Override
    public boolean saltar(int centimetros) {
        return false;
    }

}
