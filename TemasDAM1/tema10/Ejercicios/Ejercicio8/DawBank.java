package programacion.tema10.Ejercicios.Ejercicio8;

import java.util.Scanner;

import programacion.nomeacuerdo.nomeacuerdo;

public class DawBank {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CuentaBancaria cuenta = null;
        /**
         * Pedire los datos hasta que se cree la cuenta
         */
        while (true) {
            System.out.println("Creacion de tu ceunta de banco **");
            System.out.println("IBAN:");
            String iban = scanner.nextLine();
            System.out.println("Titular:");
            String titular = scanner.nextLine();
            try {
                cuenta = new CuentaBancaria(iban, titular);
            } catch (CuentaException e) {
                e.getMessage();
                e.printStackTrace();
            }
            if (cuenta != null)
                break;
        }

        String opcion = "";
        do {
            System.out.println("""
                    1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo.
                    2. IBAN. Mostrará el IBAN.
                    3. Titular. Mostrará el titular.
                    4. Saldo. Mostrará el saldo disponible.
                    5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.
                    6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.
                    7. Movimientos. Mostrará una lista con el historial de movimientos.
                    8. Salir. Termina el programa.
                    """);

            System.out.println("Opcion:");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.printf("IBAN: %s || Titular: %s || Saldo: %.2f\n", cuenta.getIban(), cuenta.getTitular(),
                            cuenta.getSaldo());
                    break;

                case "2":
                    System.out.println("IBAN: " + cuenta.getIban());
                    break;
                case "3":
                    System.out.println("Titular: " + cuenta.getTitular());
                    break;
                case "4":
                    System.out.println("Saldo: " + cuenta.getSaldo());
                    break;
                case "5":
                    ingresar(cuenta);
                    break;
                case "6":
                    retirada(cuenta);
                    break;
                case "7":
                    cuenta.mostrarMovimientos();
                    break;
                case "8":
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Entrada no esperada");
                    break;
            }

        } while (!opcion.equals("8"));
    }

    private static void retirada(CuentaBancaria cuenta) {
        System.out.println("Cuanto quieres retirar?");
        double cuantia = nomeacuerdo.pedirDouble();

        try {
            cuenta.retirada(cuantia);
        } catch (CuentaException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (AvisarHaciendaException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

    }

    private static void ingresar(CuentaBancaria cuenta) {
        System.out.println("Cuanto quieres ingresar?");
        double cuantia = nomeacuerdo.pedirDouble();

        try {
            cuenta.ingreso(cuantia);
        } catch (AvisarHaciendaException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }
}
