package programacion.tema10.Ejercicios.Ejercicio8;

import java.util.ArrayList;

public class CuentaBancaria {
    private final String iban;
    private final String titular;
    private double saldo;
    private ArrayList<Movimientos> movimientos;

    public static final double MAXIMO_DINERO_MOVIMIENTO = 3000;
    public static final double MINIMO_DINERO_CUENTA = -50;

    public CuentaBancaria(String iban, String titular) throws CuentaException {
        if (!iban.matches("[A-Z]{2}[0-9]{22}"))
            throw new CuentaException("Iban invalido");
        else
            this.iban = iban;
        this.titular = titular;
        saldo = 0;
        movimientos = new ArrayList<>();
    }

    public void ingreso(double ingreso) throws AvisarHaciendaException {
        if (ingreso > 0) {
            saldo += ingreso;
            movimientos.add(new Movimientos("Ingreso", ingreso));
            if (ingreso > MAXIMO_DINERO_MOVIMIENTO) {
                throw new AvisarHaciendaException("Notificar a hacienda");
            }
        }

    }

    public void retirada(double retirada) throws AvisarHaciendaException, CuentaException {
        if (retirada > 0) {
            if (retirada > saldo + 50)
                throw new CuentaException("Error: Saldo negativo");
            saldo -= retirada;
            movimientos.add(new Movimientos("Retiro", retirada));
            if (retirada > MAXIMO_DINERO_MOVIMIENTO) {
                throw new AvisarHaciendaException("Notificar a hacienda");
            }
        }
    }

    public void mostrarMovimientos() {
        for (Movimientos movements : movimientos) {
            System.out.println(movements);
        }
    }

    public String getIban() {
        return iban;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

}
