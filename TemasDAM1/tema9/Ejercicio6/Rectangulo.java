package programacion.tema9.Ejercicio6;

public class Rectangulo implements iFigura2D {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double perimetro() {
        return (base * 2) + (altura * 2);
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public void escalar(double escala) {
        this.base *= escala;
        this.altura *= escala;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Base: %.2f Altura: %.2f Perimetro: %.2f Area: %.2f
                """, base, altura, perimetro(), area());
    }
}
