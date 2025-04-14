package programacion.tema9.Ejercicio4;

import java.util.ArrayList;

public class Empresa {
    private final String nombre;
    private final String cif;
    private int telefono;
    private String direccion;
    private ArrayList<Empleado> empleados;

    public Empresa(String nombre, String cif, int telefono, String direccion) {
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
        this.direccion = direccion;
        empleados = new ArrayList<>();
    }

    public void añadirEmpleados(Empleado empleado) {
        if (empleados.contains(empleado))
            System.out.println("Ya hay un empleado igual");
        else
            empleados.add(empleado);
    }

    public void eliminarEmpleados(String nombre) {
        if (buscarEmpleado(nombre) != -1) {
            empleados.remove(buscarEmpleado(nombre));
        }
    }

    public int buscarEmpleado(String nombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre))
                return empleados.indexOf(empleado);
        }
        return -1;
    }

    public void mostrarInformacionImportante() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    public void mostrarInformacionEmpleados() {
        for (Empleado empleado : empleados) {
            empleado.mostrar();
        }
    }

    public double sumaSueldosBrutos() {
        int suma = 0;
        for (Empleado empleado : empleados) {
            suma += empleado.getSueldoBrutoMensual();
        }

        return suma;
    }

    public double sumaSueldosNetos() {
        int suma = 0;
        for (Empleado empleado : empleados) {
            suma += empleado.calcularSueldoNeto();
        }

        return suma;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

}
