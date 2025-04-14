package programacion.tema9.Ejercicio5;

public class VehiculoTerrestre extends Vehiculo {
    private final int numeroRuedas;

    public VehiculoTerrestre(String matricula, String modelo, int numeroRuedas) {
        super(matricula, modelo);
        if (matricula.matches("\\d{4}[A-Za-z]{3}")) {
            this.numeroRuedas = numeroRuedas;
        } else {
            this.numeroRuedas = 0;
            System.out.println("Matricula invalida");
        }

    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Numero de ruedas: %d
                """, getMatricula(), getModelo(), getNumeroRuedas());

    }

}
