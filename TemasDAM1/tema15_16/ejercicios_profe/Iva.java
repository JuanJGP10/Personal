package programacion.tema15_16.ejercicios_profe;

public class Iva implements IImpuesto {

    @Override
    public double aplicar(double importe, float impuesto) {
        return importe + importe * impuesto / 100;
    }

}
