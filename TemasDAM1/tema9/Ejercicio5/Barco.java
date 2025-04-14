package programacion.tema9.Ejercicio5;

public class Barco extends VehiculoAcuatico {
    private boolean motor;

    public Barco(String matricula, String modelo, double eslora, boolean motor) {
        super(matricula, modelo, eslora);
        this.motor = motor;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Eslora: %.2f Tiene motor?: %b
                """, getMatricula(), getModelo(), getEslora(), motor);

    }
}
