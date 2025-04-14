package programacion.tema8.EjerciciosNormales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Productos {

    private String nombre;
    private int cantidad;

    public Productos(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Productos [nombre=" + nombre + ", cantidad=" + cantidad + "]";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Productos p1 = new Productos("a", 5);
        Productos p2 = new Productos("b", 5);
        Productos p3 = new Productos("c", 5);
        Productos p4 = new Productos("d", 5);
        Productos p5 = new Productos("e", 5);

        ArrayList<Productos> lista = new ArrayList<>();

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);

        Iterator<Productos> it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        lista.remove(p2);
        lista.remove(p4);

        lista.set(lista.size() / 2, p5);

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (int i = 0; i < lista.size(); i++) {
            lista.remove(i);
        }

        scanner.close();
    }
}
