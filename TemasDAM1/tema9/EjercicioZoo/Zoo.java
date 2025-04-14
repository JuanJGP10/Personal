package programacion.tema9.EjercicioZoo;

import java.util.ArrayList;

public class Zoo {
    private ArrayList<Animal> listaAnimales;

    public Zoo() {
        listaAnimales = new ArrayList<>();
    }

    public boolean añadirAnimal(Animal a) {
        if (listaAnimales.contains(a))
            return false;
        return listaAnimales.add(a);

    }

    public boolean eliminarAnimal(String nombre) {
        int indiceAnimal = buscarAnimal(nombre);
        if (indiceAnimal != -1) {
            // Puedes borrar sin iterator si borras por indice
            listaAnimales.remove(indiceAnimal);
            return true;
        }
        return false;
    }

    public int buscarAnimal(String nombre) {
        for (Animal animal : listaAnimales) {
            if (animal.getNombre().equals(nombre))
                return listaAnimales.indexOf(animal);
        }
        return -1;
    }

    public void listaAnimales() {
        for (Animal animal : listaAnimales) {
            System.out.println(animal);
        }
    }

}
