package programacion.tema9.Ejercicio6;

public class Circulo implements iFigura2D {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double perimetro() {
        return (2 * Math.PI) * radio;
    }

    @Override
    public double area() {
        return Math.PI * (radio * radio);
    }

    @Override
    public void escalar(double escala) {
        this.radio *= escala;
    }

    @Override
    public void imprimir() {
        System.out.printf("""
                Radio %.2f Perimetro: %.2f Area: %.2f
                """, radio, perimetro(), area());
    }
}
