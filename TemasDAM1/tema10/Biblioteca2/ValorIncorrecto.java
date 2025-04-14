package programacion.tema10.Biblioteca2;

public class ValorIncorrecto extends Exception {
    private String valor;

    public ValorIncorrecto(String valor) {
        super("Valor incorrecto --> " + valor);
    }

}
