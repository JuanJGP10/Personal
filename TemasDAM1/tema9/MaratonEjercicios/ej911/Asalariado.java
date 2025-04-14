package programacion.tema9.MaratonEjercicios.ej911;

public class Asalariado extends Trabajador {
    private double salarioFinal;
    private int horasExtras;

    public static final double precioHoraExt = 20;

    @Override
    public String toString() {
        return super.toString() + " SalarioFinal:" + salarioFinal + " HorasExtras:" + horasExtras;
    }

    public Asalariado(String nombre, int id, String fechaNacimiento,
            double salarioBase) {
        super(nombre, id, fechaNacimiento, salarioBase);
        this.salarioFinal = salarioBase;
        this.horasExtras = 0;
    }

    public void calcularSalarioFinal() {
        salarioFinal += (horasExtras * precioHoraExt);
    }

    public double getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

}
