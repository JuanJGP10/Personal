package programacion.tema9.Ejercicio6;

public class Triangulo implements iFigura2D {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double perimetro() {
        double hipotenusa = Math.sqrt((base / 2) * (base / 2) + altura * altura);
        return base + 2 * hipotenusa;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public void escalar(double escala) {
        if (escala > 0) {
            base *= escala;
            altura *= escala;
        }
    }

    @Override
    public void imprimir() {
        System.out.printf("Triángulo - Base: %.2f, Altura: %.2f, Perímetro: %.2f, Área: %.2f\n",
                base, altura, perimetro(), area());
    }
}
