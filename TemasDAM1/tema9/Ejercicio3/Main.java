package programacion.tema9.Ejercicio3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        CuentaCorriente cc = new CuentaCorriente("ES1234567890123456789012", 1000);
        CuentaAhorro ca = new CuentaAhorro("ES9876543210987654321098", 500);

        cuentas.add(cc);
        cuentas.add(ca);

        cc.ingresarDinero(200);
        ca.retirarDinero(100);
        cc.traspasarDinero(300, ca);

        for (CuentaBancaria cuenta : cuentas) {
            cuenta.calcularIntereses();
            cuenta.mostrarAtributos();
        }
    }
}
