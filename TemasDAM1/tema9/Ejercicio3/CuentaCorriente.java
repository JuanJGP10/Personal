package programacion.tema9.Ejercicio3;

public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(String iban, double saldo) {
        super(iban, saldo);
    }

    @Override
    public void calcularIntereses() {
        double intereses = saldo * interesAnualBasico;
        ingresarDinero(intereses);
    }
}
