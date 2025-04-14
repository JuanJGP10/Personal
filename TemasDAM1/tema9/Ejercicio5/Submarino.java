package programacion.tema9.Ejercicio5;

public class Submarino extends VehiculoAcuatico {
    private double profundidadMaxima;

    public Submarino(String matricula, String modelo, double eslora, double profundidadMaxima) {
        super(matricula, modelo, eslora);
        this.profundidadMaxima = profundidadMaxima;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Matricula: %s Modelo: %s Eslora: %.2f Tiene motor?: %b
                """, getMatricula(), getModelo(), getEslora(), profundidadMaxima);

    }
}
