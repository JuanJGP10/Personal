package programacion.tema8.EticalBank;

import java.util.ArrayList;

import programacion.tema8.Factura.Movimientos;

public class CuentaBancaria {

    private String iban;
    private double saldo = 0;
    private String titular;

    private ArrayList<Movimientos> movimientos = new ArrayList<>();

    public CuentaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
    }

    public void ingreso(double importe) {
        if (importe > 0) {
            this.saldo += importe;
            if (importe > 3000) {
                System.out.println("AVISO:Notificar a hacienda");
            }
            Movimientos m1 = new Movimientos("Ingreso", importe);
            movimientos.add(m1);
        }

    }

    public void retirada(double importe) {
        if (importe > 0) {

            this.saldo -= importe;
            if (this.saldo < 0 && this.saldo > -50) {
                System.out.println("AVISO:Saldo negativo");
            } else if (this.saldo < -50) {
                this.saldo += importe;
            }
            Movimientos m1 = new Movimientos("Retiro", importe);
            movimientos.add(m1);
        }

    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public ArrayList<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

}
