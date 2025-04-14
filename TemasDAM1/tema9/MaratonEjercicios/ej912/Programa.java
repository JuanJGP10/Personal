package programacion.tema9.MaratonEjercicios.ej912;

import programacion.tema9.MaratonEjercicios.ej98.Figura2D_v8;
import programacion.tema9.MaratonEjercicios.ej98.Triangulo_v8;

public class Programa {
    public static void main(String[] args) {
        Figura2D_v8 fig = new Triangulo_v8("escaleno", 5.6, 6.7, "triang 1");

        fig.verDim();
        if (fig instanceof Triangulo_v8 triang) {
            System.out.println(triang.area());
        }
    }
}
