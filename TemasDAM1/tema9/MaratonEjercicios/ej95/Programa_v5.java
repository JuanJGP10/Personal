package programacion.tema9.MaratonEjercicios.ej95;

public class Programa_v5 {
    public static void main(String[] args) {
        Triangulo_v5 t1 = new Triangulo_v5("escaleno", 8.9, 5.8);
        Triangulo_v5 t2 = new Triangulo_v5(6.5);
        Triangulo_v5 t3 = new Triangulo_v5();

        System.out.println(t1.area());
        System.out.println(t2.area());
        System.out.println(t3.area());
        t1.verEstilo();
        t2.verEstilo();
        t3.verEstilo();
        t1.verDim();
        System.out.println();
        t2.verDim();
        System.out.println();
        t3.verDim();

        // Ahora funciona porque tenemos un constructor de la clase padre para asignar
        // los valores ancho y alto
    }
}
