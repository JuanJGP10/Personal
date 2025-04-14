package programacion.tema9.Ejercicio5;

public class Moto extends VehiculoTerrestre {
    private String color;

    public Moto(String matricula, String modelo, int numeroRuedas, String color) {
        super(matricula, modelo, numeroRuedas);
        this.color = color;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Numero de ruedas: %d Color: %s
                """, getMatricula(), getModelo(), getNumeroRuedas(), color);

    }
}
