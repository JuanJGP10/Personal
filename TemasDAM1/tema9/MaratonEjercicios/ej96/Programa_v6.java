package programacion.tema9.MaratonEjercicios.ej96;

public class Programa_v6 {
    public static void main(String[] args) {
        Triangulo_v6 t1 = new Triangulo_v6("escaleno", 8.9, 5.8);
        Triangulo_v6 t2 = new Triangulo_v6(6.5);
        Triangulo_v6 t3 = new Triangulo_v6();

        System.out.println(t1.area());
        System.out.println(t2.area());
        System.out.println(t3.area());
        t1.verEstilo();
        t2.verEstilo();
        t3.verEstilo();
        t1.verDim();

        t2.verDim();

        t3.verDim();

        TrianColor_v6 t4 = new TrianColor_v6("escaleno", 8.9, 10, "Azul");

        System.out.println(t4.area());
        t4.verDim();
        t4.verEstilo();
    }
}
