package programacion.tema10.Ejercicio9;

public class ValorIncorrecto extends Exception {
    private String valor;

    public ValorIncorrecto(String valor) {
        // No me lo pide
        // super("Valor incorrecto -->" + valor);
        super();
        this.valor = valor;
    }

    public ValorIncorrecto(String valor, String message) {
        super(message);
        this.valor = valor;
    }

    @Override
    public String toString() {
        return " Excepcion ValorIncorrecto : valor: " + valor + ",  Mensaje: " + getMessage();
    }

}
