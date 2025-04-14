package programacion.tema9.Ejercicio3;

class CuentaAhorro extends CuentaBancaria {
    private static double saldoMinimo;

    public CuentaAhorro(String iban, double saldo) {
        super(iban, saldo);

    }

    @Override
    public void calcularIntereses() {
        double intereses;
        if (this.saldo >= saldoMinimo) {
            intereses = interesAnualBasico * 2;
        } else {
            intereses = interesAnualBasico / 2;
        }

        double intereses2 = intereses * saldo;
        ingresarDinero(intereses2);
    }
}
