package programacion.tema8.EticalBank;

import java.util.Scanner;

public class Eticalbank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean creada = false;
        boolean validString = true;
        String iban;
        String nombre;
        double importe;
        do {
            System.out.println("Creacion de cuenta /=/ IBAN:");
            iban = scanner.nextLine();
            System.out.println("Creacion de cuenta /=/ Titular:");
            nombre = scanner.nextLine();

            if (iban.length() == 24) {

                for (int i = 0; i < 2; i++) {
                    if (!Character.isLetter(iban.charAt(i))) {
                        validString = false;
                    }
                }

                for (int i = 2; i < iban.length(); i++) {
                    if (!Character.isDigit(iban.charAt(i))) {
                        validString = false;
                    }
                }

            } else if ((iban.length() != 24 && !validString)) {
                System.out.println("El IBAN esta compuesto por 2 letras y 22 numeros respectivamente");
            }

            if (nombre.length() < 17) {
                System.out.println("El nombre debe ser completo y mayor que 17 letras ocntando espacios");
            }

            if (iban.length() == 24 && validString && nombre.length() > 17) {

                creada = true;
            }

        } while (!creada);

        CuentaBancaria c1 = new CuentaBancaria(iban, nombre);

        do {
            System.out.println("""
                    1.Datos de la cuenta.
                    2.Iban
                    3.Titular
                    4.Saldo
                    5.Ingreso.
                    6.Retirada.
                    7.Lista de movimientos.
                    8.Salir
                    """);

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.printf("IBAN:%s\nTitular:%s\nSaldo:%.2f\n", c1.getIban(), c1.getTitular(),
                            c1.getSaldo());
                    break;
                case 2:
                    System.out.println("IBAN:" + c1.getIban());
                    break;
                case 3:
                    System.out.println("Titular:" + c1.getTitular());
                    break;
                case 4:
                    System.out.println("Saldo:" + c1.getSaldo());
                    break;
                case 5:
                    System.out.println("Cuanto quiere ingresar:");
                    importe = scanner.nextDouble();
                    c1.ingreso(importe);
                    break;
                case 6:
                    System.out.println("Cuanto quiere retirar:");
                    importe = scanner.nextDouble();
                    double saldoPre = c1.getSaldo();
                    c1.retirada(importe);
                    if (c1.getSaldo() == saldoPre) {
                        System.out.println("Retiro no valido ya que tu cuenta se quedaria en menos de 50 euros");
                    }
                    break;
                case 7:
                    System.out.println("Lista de movimientos");
                    System.out.println(c1.getMovimientos());
                    break;
                case 8:
                    System.out.println("Saliendo del programa");
                    break;

            }

        } while (opcion != 8);
    }
}
