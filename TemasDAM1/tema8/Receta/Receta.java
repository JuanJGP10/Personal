package programacion.tema8.Receta;

import java.util.ArrayList;

public class Receta {
    private String nombre;
    private String elaboracion;
    private int duracion;
    private ArrayList<Ingrediente> ingredientes;

    public Receta(String nombre, String elaboracion, int duracion, ArrayList<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.elaboracion = elaboracion;
        this.duracion = duracion;
        this.ingredientes = ingredientes;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getelaboracion() {
        return elaboracion;
    }

    public void setelaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public int getduracion() {
        return duracion;
    }

    public void setduracion(int duracion) {
        this.duracion = duracion;
    }

    public void imprimirReceta() {
        System.out.printf("""
                Nombre de la receta: %s
                Elaboracion de la receta: %s
                Duracion de la receta: %d minutos
                Ingredientes de la receta:

                """, nombre, elaboracion, duracion);
        for (int i = 0; i < ingredientes.size(); i++) {
            System.out.printf("""
                    Ingrediente: %d | Nombre: %s | Cantidad: %d | Unidades: %s
                    ____________________________________________________________________

                    """, (i + 1), ingredientes.get(i).getNombre(), ingredientes.get(i).getCantidad(),
                    ingredientes.get(i).getUnidad());
        }

    }

}
