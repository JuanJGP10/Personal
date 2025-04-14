package programacion.tema9.MaratonEjercicios.ej923;

import java.util.ArrayList;
import java.util.Scanner;

import programacion.nomeacuerdo.nomeacuerdo;

public class Programa {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Pacientes> cola = new ArrayList<>();
        String opcion = "";
        double totalFacturado = 0;
        do {

            System.out.println("""
                    1) Registrar consulta
                    2)Llamar a consulta
                    3)Dinero cobrado hasta el momento
                    4)Salir
                    """);
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    Pacientes paciente = registrarConsulta();
                    cola.add(paciente);
                    break;
                case "2":
                    totalFacturado += llamarAconsulta(cola);
                    break;

                case "3":
                    System.out.println("Total facturado hasta ahora: " + totalFacturado);

                    break;
                case "4":
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Entrada no esperada");
                    break;
            }
        } while (!opcion.equals("4"));

    }

    private static double llamarAconsulta(ArrayList<Pacientes> lista) {
        double totalFacturado = 0;
        if (lista.size() > 0) {
            totalFacturado += lista.get(0).facturar();
            lista.remove(0);
            System.out.println("Consulta realizada con exito");
            return totalFacturado;
        } else {
            System.out.println("La lista esta vacia");
            return 0;
        }
    }

    private static Pacientes registrarConsulta() {
        Pacientes paciente = null;
        String clase = "";
        do {
            System.out.println("Porque vienes al medico?");
            clase = scanner.nextLine();
            clase = clase.toLowerCase();
        } while (!clase.contains("consulta") && !clase.contains("revision") && !clase.contains("recetas"));

        System.out.println("Dime tu nombre");
        String nombre = scanner.nextLine();

        System.out.println("Dime tu edad");
        int edad = nomeacuerdo.pedirInt();

        if (clase.contains("consulta")) {
            System.out.println("Motivo de consulta:");
            String motivoConsulta = scanner.nextLine();
            paciente = new PacienteConsulta(nombre, edad, motivoConsulta);
        } else if (clase.contains("revision")) {
            System.out.println("Fecha ultima visita?:");
            String fecha = scanner.nextLine();
            paciente = new PacienteRevision(nombre, edad, fecha);
        } else {
            System.out.println("Cuantos medicamentos?:");
            String meds = scanner.nextLine();
            paciente = new PacienteRevision(nombre, edad, meds);
        }
        System.out.println("Registro completado");
        return paciente;
    }
}
