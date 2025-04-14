package programacion.tema9.Ejercicio5;

public class VehiculoAcuatico extends Vehiculo {
    private final double eslora;

    public VehiculoAcuatico(String matricula, String modelo, double eslora) {
        super(matricula, modelo);
        if (matricula.matches("[A-Za-z]{3,10}")) {
            this.eslora = eslora;
        } else {
            this.eslora = 0;
            System.out.println("Matricula invalida");
        }
    }

    public double getEslora() {
        return eslora;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s eslora: %.2f
                """, getMatricula(), getModelo(), eslora);

    }

}
