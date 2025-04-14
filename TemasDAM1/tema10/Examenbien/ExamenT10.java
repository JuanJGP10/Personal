package programacion.tema10.Examenbien;

public class ExamenT10 {
        public static void main(String[] args) {
                String[] proyectos = { "Web", "App Movil", "Sistema de Gestión Empresarial", "Dashboard", "API Rest" };
                String[] nombresProyectos = { "GestorTareas", "SaludTotal", "RecetarioFácil", "ViajePerfecto",
                                "PlanificadorEjercicios", "AhorroInteligente", "EstudioOrganizado", "EventosExpress",
                                "ClimaAlert",
                                "RedSocialLocal" };
                EmpleadoDesarrollo empleadoDesarrollo1 = new EmpleadoDesarrollo("49626497H", "Juan",
                                new Direccion("Calle Ebro", 3, "Orihuela Costa"), Especialidad.DESARROLLO, proyectos);
                EmpleadoDesarrollo empleadoDesarrollo2 = new EmpleadoDesarrollo("34567891J", "Melo",
                                new Direccion("Calle Escorpiones", 3, "Pilar"), Especialidad.DISEÑO, nombresProyectos);

                EmpleadoAdministrativo empAdmin = new EmpleadoAdministrativo("91631991L", "Jesus",
                                new Direccion("Calle Jerusalen", 2, "Valencia"), 4);
                EmpleadoAdministrativo empAdmin1 = new EmpleadoAdministrativo("01371944K", "Adriel",
                                new Direccion("Calle Batistuta", 5, "Alicante"));

                GestorEmpleados gestor = new GestorEmpleados();

                gestor.añadirEmpleado(empAdmin1);
                gestor.añadirEmpleado(empAdmin);
                gestor.añadirEmpleado(empleadoDesarrollo1);
                gestor.añadirEmpleado(empleadoDesarrollo2);

                System.out.println("Total de salarios de los empleados = " + gestor.calcularTotalSalarios());

                System.out.println("Empleado " + empleadoDesarrollo1.getNombre() + " Proyecto mas importante: "
                                + empleadoDesarrollo1.obtenerProyectosMasComplejos(2)[0]);
                System.out.println("Empleado " + empleadoDesarrollo2.getNombre() + " Proyecto mas importante: "
                                + empleadoDesarrollo2.obtenerProyectosMasComplejos(2)[0]);

        }

}
