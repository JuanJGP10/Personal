package programacion.tema9.Ejercicio5;

public class Coche extends VehiculoTerrestre {
    private boolean aireAcondicionado;

    public Coche(String matricula, String modelo, int numeroRuedas, boolean aireAcondicionado) {
        super(matricula, modelo, numeroRuedas);
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Numero de ruedas: %d Aire acondicionado?: %b
                """, getMatricula(), getModelo(), getNumeroRuedas(), aireAcondicionado);

    }
}
