package programacion.tema9.Ejercicio4;

public class Programa {
    public static void main(String[] args) {
        // Crear una empresa
        Empresa miEmpresa = new Empresa("TechSolutions", "A12345678", 912345678, "Calle Falsa 123");

        // Crear empleados
        Empleado emp1 = new Empleado("12345678A", "Juan Perez", 3000);
        Empleado emp2 = new Empleado("87654321B", "Ana Lopez", 2500);

        // Añadir empleados a la empresa
        miEmpresa.añadirEmpleados(emp1);
        miEmpresa.añadirEmpleados(emp2);

        // Listar empleados
        System.out.println("Empleados en la empresa:");
        miEmpresa.mostrarInformacionImportante();

        // Mostrar total de sueldos brutos y netos
        System.out.println("Total sueldos brutos: " + miEmpresa.sumaSueldosBrutos());
        System.out.println("Total sueldos netos: " + miEmpresa.sumaSueldosNetos());

        // Eliminar un empleado
        miEmpresa.eliminarEmpleados("Juan Perez");
        System.out.println("Empleados después de eliminar a Juan Perez:");

        miEmpresa.mostrarInformacionEmpleados();

        // Mostrar total de sueldos brutos y netos después de la eliminación
        System.out.println("Total sueldos brutos después de eliminar: " + miEmpresa.sumaSueldosBrutos());
        System.out.println("Total sueldos netos después de eliminar: " + miEmpresa.sumaSueldosNetos());
    }
}
