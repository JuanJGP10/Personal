package programacion.tema9.MaratonEjercicios.ej911;

public class ConsultorExterno extends Trabajador {
    private int horasTrabajadas;
    private double salarioFinal;

    public static final double precioHora = 100;

    public ConsultorExterno(String nombre, int id, String fechaNacimiento, double salarioBase, int horasTrabajadas,
            double salarioFinal) {
        super(nombre, id, fechaNacimiento, salarioBase);
        this.horasTrabajadas = 0;
        this.salarioFinal = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " HorasTrabajadas:" + horasTrabajadas + " salarioFinal:" + salarioFinal;
    }

    public void calcularSalarioFinal() {
        salarioFinal += (horasTrabajadas * precioHora);
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

}
