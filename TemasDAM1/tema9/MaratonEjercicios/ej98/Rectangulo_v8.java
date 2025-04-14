package programacion.tema9.MaratonEjercicios.ej98;

public class Rectangulo_v8 extends Figura2D_v8 {

    public Rectangulo_v8(double alto, double ancho, String nombre) {
        super(ancho, alto, nombre);
    }

    public Rectangulo_v8(double lado, String nombre) {
        super(lado, nombre);
    }

    public boolean esCuadrado() {
        if (this.getAlto() == this.getAncho())
            return true;
        else
            return false;
    }
}
