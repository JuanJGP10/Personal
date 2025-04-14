package programacion.nomeacuerdo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class nomeacuerdo {
    static Scanner scanner = new Scanner(System.in);
    // static: atributo comun a todas los objetos (es de la clase)
    private static int contadorIds = 0;
    // final: no se puede modificar
    private final String nombre;
    private final int identificador;
    // private: no se puede ver fuera del paquete
    private int dineros;
    // Arraylist
    private ArrayList<Integer> lineas;
    // Fecha
    private final LocalDate fecha;

    //
    // Constructor se hace asi:
    //

    public nomeacuerdo(String nombre, int dineros) {
        this.nombre = nombre;
        this.dineros = dineros;
        this.identificador = contadorIds;
        contadorIds++;
        this.fecha = LocalDate.now();
        this.lineas = new ArrayList<Integer>();
    }

    //
    // Funciones para validar formatos
    //

    public static double pedirDouble() {
        String valor;

        do {
            valor = scanner.nextLine();
            if (!valor.matches("\\d+([,]\\d+)?"))
                System.out.println("formato incorrecto (Decimal)");
        } while (!valor.matches("\\d+([,]\\d+)?"));
        valor = valor.replace(',', '.');
        return Double.parseDouble(valor);
    }

    public static int pedirInt() {
        String valor;

        do {
            valor = scanner.nextLine();
            if (!valor.matches("\\d+"))
                System.out.println("formato incorrecto (Entero)");
        } while (!valor.matches("\\d+"));

        return Integer.parseInt(valor);
    }

    public static String pedirString() {
        String valor;

        do {
            valor = scanner.nextLine();
            if (!valor.matches("[A-Za-z(\s)?]+"))
                System.out.println("Formato incorrecto (Cadena de texto)");
        } while (!valor.matches("[A-Za-z(\s)?]+"));

        return valor;
    }

    // Iterator para arraylists

    // Iterator<Objeto> nombreIterador = lista.iterator();
    // while (buscarPorIdentificador.hasNext()) {
    // Objeto objetoTemp = buscarPorIdentificador.next();
    //
    // }
    // }

    // COllections para frecuencias

    // Esto dentro de un for para que guarde ordenados los elementos
    // nt frecuencia = Collections.frequency(aleatorios, i);

    // Al indice luego habria q sumarle 1 porque la lista empieza por 0 y n por 1
    // int indiceMAximo = frecuencias.indexOf(Collections.max(frecuencias));
}
