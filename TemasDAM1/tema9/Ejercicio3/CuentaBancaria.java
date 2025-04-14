package programacion.tema9.Ejercicio3;

public abstract class CuentaBancaria {
    protected String iban;
    protected double saldo;
    public static double interesAnualBasico = 0.01;

    public CuentaBancaria(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public void mostrarAtributos() {
        System.out.printf("""
                IBAN: %s
                Saldo: %.2f
                """, iban, saldo);
    }

    public void ingresarDinero(double dinero) {
        añadir(dinero);
    }

    public void retirarDinero(double dinero) {
        añadir(-dinero);
    }

    public void traspasarDinero(double dinero, CuentaBancaria cuenta) {
        if (this.saldo >= dinero) {
            retirarDinero(dinero);
            cuenta.ingresarDinero(dinero);
        } else {
            System.out.println("Sin saldo suficiente para realizar la transcaccion");
        }
    }

    private void añadir(double dinero) {
        this.saldo += dinero;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void calcularIntereses();
}
