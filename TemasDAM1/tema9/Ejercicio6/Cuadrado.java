package programacion.tema9.Ejercicio6;

public class Cuadrado implements iFigura2D {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double perimetro() {
        return lado * 4;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public void escalar(double escala) {
        this.lado *= escala;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Lado: %.2f Perimetro: %.2f Area: %.2f
                """, lado, perimetro(), area());
    }
}
