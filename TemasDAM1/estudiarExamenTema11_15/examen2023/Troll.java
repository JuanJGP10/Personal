package programacion.estudiarExamenTema11_15.examen2023;

public class Troll extends Personaje {
    private static int contador = 1;

    public Troll() {
        super("Troll" + contador++);
        setFuerza(fuerzaAleatoria());
    }

    @Override
    public boolean retirada() throws Exception {
        throw new Exception("Un troll no puede retirarse");
    }

}
