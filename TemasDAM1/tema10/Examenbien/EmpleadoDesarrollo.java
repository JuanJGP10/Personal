package programacion.tema10.Examenbien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase Empleado desarrollo que representa a los empleados que so
 * desarrolladores de una empresa, hereda de la clase empleado.
 */
public class EmpleadoDesarrollo extends Empleado implements Comparable<EmpleadoDesarrollo> {
    /**
     * Esta es un atributo que sera la especialidad del empleado, viene de una
     * enumeracion Especialidad
     */
    private Especialidad especialidad;

    /**
     * Este es un atributo de tipo array de strings que almacenara los proyectos
     * realizados por los empleados
     */
    private String[] proyectosRealizados;

    /**
     * Constructor que recibe todos los parámetros del padre más la especialidad y
     * un array de proyectos.
     * La especialidad no puede ser vacía, se lanzará una excepción no capturada.
     * 
     * @param dni
     * @param nombre
     * @param direccion
     * @param especialidad
     * @param proyectosRealizados
     */
    public EmpleadoDesarrollo(String dni, String nombre, Direccion direccion, Especialidad especialidad,
            String[] proyectosRealizados) {
        super(dni, nombre, direccion);
        setEspecialidad(especialidad);
        this.proyectosRealizados = proyectosRealizados;
    }

    /**
     * Constructor adicional que use un valor por defecto de especialidad
     * (DESARROLLO) y un array de proyectos vacío.
     * Usará el primer constructor.
     * 
     * @param dni
     * @param nombre
     * @param direccion
     */
    public EmpleadoDesarrollo(String dni, String nombre, Direccion direccion) {
        this(dni, nombre, direccion, Especialidad.DESARROLLO, new String[0]);

    }

    /**
     * Getter de especialidad
     * 
     * @return Enumeracion de especialidades
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * Setter de especialidad
     * 
     * @param especialidad
     */
    public void setEspecialidad(Especialidad especialidad) {
        if (especialidad == null)
            throw new EmpleadoException("La especialidad no puede ser vacia");
        this.especialidad = especialidad;
    }

    /**
     * Getter de Proyectos realizados
     * 
     * @return array con los proyectos
     */
    public String[] getProyectosRealizados() {
        return proyectosRealizados;
    }

    /**
     * Setter de proyectos realizados
     * 
     * @param proyectosRealizados
     */
    public void setProyectosRealizados(String[] proyectosRealizados) {

        this.proyectosRealizados = proyectosRealizados;
    }

    /**
     * Metodo calcular salario que calculara el salario del empleado segun su
     * especialidad
     * 
     * @return salario
     */
    @Override
    public double calcularSalario() {
        if (especialidad.equals(Especialidad.DESARROLLO))
            return 3000;
        else if (especialidad.equals(Especialidad.DISEÑO))
            return 2800;
        else if (especialidad.equals(Especialidad.INFRAESTRUCTURA))
            return 3200;
        else if (especialidad.equals(Especialidad.GESTION))
            return 3500;
        else
            return 0;
    }

    /**
     * Metodo que obtiene los n proyectos realizados mas complejos, por complejo nos
     * referimos al tamaño del nombre del proyecto
     * 
     * @param n numero de proyectos que queremos devolver
     * @return array con los proyectos
     */
    public String[] obtenerProyectosMasComplejos(int n) { // Se ha intentado
        if (n < 0)
            return new String[0];

        if (proyectosRealizados.length == 0)
            return new String[0];

        String[] proyectosComplejos = new String[n];
        String[] proyectosCopy = Arrays.copyOf(proyectosRealizados, proyectosRealizados.length);
        Arrays.sort(proyectosCopy, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < proyectosComplejos.length; i++) {
            proyectosComplejos[i] = proyectosCopy[i];
        }
        return proyectosComplejos;

    }

    /**
     * Metodo heredado de la interfaz comparable, habiendo sido declarada la
     * implementacion en la clase padre (Empleado)
     * Lo utilizaremos para ordenar a los empleados de desarrollo
     * 
     * @param e empleado
     * @return devuelve si el objetos es mayo menor o igual
     */
    @Override
    public int compareTo(EmpleadoDesarrollo e) {
        int nombre = this.getNombre().compareTo(e.getNombre());

        if (nombre == 0)
            return (int) (this.calcularSalario() - e.calcularSalario());

        return nombre;
    }

}
