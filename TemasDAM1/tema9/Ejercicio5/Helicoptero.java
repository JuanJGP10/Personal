package programacion.tema9.Ejercicio5;

public class Helicoptero extends VehiculoAereo {
    private int numeroHelices;

    public Helicoptero(String matricula, String modelo, int numAsientos, int numeroHelices) {
        super(matricula, modelo, numAsientos);
        this.numeroHelices = numeroHelices;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Numero de asientos: %d Numero de helices: %d
                """, getMatricula(), getModelo(), getNumAsientos(), numeroHelices);

    }
}
