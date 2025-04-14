package programacion.estudiarExamenTema11_15.examen2023;

public class Mago extends Personaje {

    public Mago(String nombre, int fuerza) {
        super(nombre);
        if (fuerzaCorrecta(fuerza))
            setFuerza(fuerza);
        else
            setFuerza(FUERZA_DEFECTO);

    }

    @Override
    public boolean retirada() throws Exception {
        if (isMuerto())
            throw new Exception("El mago esta muerto");
        if (!isHerido())
            throw new Exception("El mago no esta herido");
        return true;
    }

}
