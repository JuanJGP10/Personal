package programacion.tema8.Factura;

public class Movimientos {
    private String tipoMovimiento;
    private double importe;

    public Movimientos(String tipoMovimiento, double importe) {
        this.tipoMovimiento = tipoMovimiento;
        this.importe = importe;

    }

    @Override
    public String toString() {
        return tipoMovimiento + "| importe:" + importe + "\n";
    }

}
