package programacion.tema9.MaratonEjercicios.ej913;

public class Rectangulo_v9 extends Figura2D_v9 {

    public Rectangulo_v9(double alto, double ancho, String nombre) {
        super(ancho, alto, nombre);
    }

    public Rectangulo_v9(double lado, String nombre) {
        super(lado, nombre);
    }

    public boolean esCuadrado() {
        if (this.getAlto() == this.getAncho())
            return true;
        else
            return false;
    }

    @Override
    public double area() {
        return this.getAncho() * this.getAlto();
    }

    @Override
    public double precio(float precioMetroCuadrado) {
        return area() * precioMetroCuadrado;
    }
}
