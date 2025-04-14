package programacion.tema9.MaratonEjercicios.ej911;

import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        ArrayList<ConsultorExterno> consultores = new ArrayList<>();
        ArrayList<Asalariado> asalariados = new ArrayList<>();

        Asalariado asalariado1 = new Asalariado("María López", 201, "1995-11-05", 2500.00);
        Asalariado asalariado2 = new Asalariado("Jorge Fernández", 202, "1988-07-19", 2700.50);
        Asalariado asalariado3 = new Asalariado("Elena Ramírez", 203, "1992-02-28", 2600.75);

        // Objetos de ConsultorExterno
        ConsultorExterno consultor1 = new ConsultorExterno("Fernando Díaz", 301, "1980-09-15", 3000.00, 40, 3500.00);
        ConsultorExterno consultor2 = new ConsultorExterno("Gabriela Torres", 302, "1987-04-22", 3200.50, 38, 3600.75);
        ConsultorExterno consultor3 = new ConsultorExterno("Ricardo Morales", 303, "1993-12-30", 2900.00, 42, 3300.50);

        consultores.add(consultor3);
        consultores.add(consultor2);
        consultores.add(consultor1);

        asalariados.add(asalariado3);
        asalariados.add(asalariado2);
        asalariados.add(asalariado1);

        consultor1.setHorasTrabajadas(200);
        consultor2.setHorasTrabajadas(250);
        consultor3.setHorasTrabajadas(150);

        asalariado1.setHorasExtras(50);
        asalariado2.setHorasExtras(60);
        asalariado3.setHorasExtras(70);

        consultor1.calcularSalarioFinal();
        consultor2.calcularSalarioFinal();
        consultor3.calcularSalarioFinal();

        asalariado1.calcularSalarioFinal();
        asalariado2.calcularSalarioFinal();
        asalariado3.calcularSalarioFinal();

        double totalEmpresaGastos = 0;

        for (Asalariado asalariado : asalariados) {
            System.out.println(asalariado);
            totalEmpresaGastos += asalariado.getSalarioFinal();
        }

        for (ConsultorExterno consultorExterno : consultores) {
            System.out.println(consultorExterno);
            totalEmpresaGastos += consultorExterno.getSalarioFinal();
        }

        System.out.println("Gastos de pagar a los empleados: " + totalEmpresaGastos);
    }
}
