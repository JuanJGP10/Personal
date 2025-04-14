package programacion.tema9.Ejercicio5;

public class Avion extends VehiculoAereo {

    private double tiempoVueloMaximo;

    public Avion(String matricula, String modelo, int numAsientos, double tiempoVueloMaximo) {
        super(matricula, modelo, numAsientos);
        this.tiempoVueloMaximo = tiempoVueloMaximo;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Numero de asientos: %d Tiempo de vuelo maximo: %.2f
                """, getMatricula(), getModelo(), getNumAsientos(), tiempoVueloMaximo);

    }
}
