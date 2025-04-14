package programacion.tema9.MaratonEjercicios.ej98;

import java.util.ArrayList;

public class Programa_v8 {
    public static void main(String[] args) {

        ArrayList<Figura2D_v8> lista = new ArrayList<>();

        lista.add(new Rectangulo_v8(5.5, 6.6, "r1"));
        lista.add(new Rectangulo_v8(5.8, 6.9, "r2"));
        lista.add(new Rectangulo_v8(4, "ri1"));
        lista.add(new Rectangulo_v8(5, "ri2"));

        int contador = 0;
        for (Figura2D_v8 figura2d_v8 : lista) {
            if (figura2d_v8 instanceof Rectangulo_v8 rect) {
                if (rect.esCuadrado())
                    contador++;
            }
        }
        System.out.println("Estos rectangulos de la lista son cuadrados: " + contador);

        TrianColor_v8 t4 = new TrianColor_v8("escaleno", 8.9, 10, "Azul", "t1");

        System.out.println(t4.area());
        t4.verDim();
        t4.verEstilo();

    }
}
