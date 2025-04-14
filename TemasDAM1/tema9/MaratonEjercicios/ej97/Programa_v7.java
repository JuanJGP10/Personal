package programacion.tema9.MaratonEjercicios.ej97;

public class Programa_v7 {
    public static void main(String[] args) {
        Triangulo_v7 t1 = new Triangulo_v7("escaleno", 8.9, 5.8);
        Triangulo_v7 t2 = new Triangulo_v7(6.5);
        Triangulo_v7 t3 = new Triangulo_v7();

        System.out.println(t1.area());
        System.out.println(t2.area());
        System.out.println(t3.area());
        t1.verEstilo();
        t2.verEstilo();
        t3.verEstilo();
        t1.verDim();

        t2.verDim();

        t3.verDim();

        TrianColor_v7 t4 = new TrianColor_v7("escaleno", 8.9, 10, "Azul");

        System.out.println(t4.area());
        t4.verDim();
        t4.verEstilo();

        Triangulo_v7 t5 = new Triangulo_v7(t4);

        System.out.println(t5.area());
        t5.verDim();
        t5.verEstilo();
    }
}
