package programacion.tema9.MaratonEjercicios.ej922;

public abstract class PoligonoRegular {
    double tamañoLado;

    abstract double area();

    abstract int getCantidadLados();

    double perimetro() {
        return getCantidadLados() * this.tamañoLado;
    }

    PoligonoRegular(double tl) {
        this.tamañoLado = tl;

    }

    class Pentagono extends PoligonoRegular {

        Pentagono(double t) {
            super(t);

        }

        @Override
        int getCantidadLados() {
            return 5;

        }

        @Override
        double area() {
            return 1.72048 * Math.pow(this.tamañoLado, 2);

        }

    }

    class Hexagono extends PoligonoRegular {

        Hexagono(double t) {
            super(t);

        }

        @Override
        int getCantidadLados() {
            return 6;

        }

        @Override
        double area() {
            double lado = this.tamañoLado;
            double apotema = Math.sqrt((lado * lado) - ((lado / 2) * (lado / 2)));
            return lado * apotema * 3;

        }
    }
}