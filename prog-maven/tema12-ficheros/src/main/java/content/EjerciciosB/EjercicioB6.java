package content.EjerciciosB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class EjercicioB6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File rutaPi = new File(
                "C:/Users/Juan/Desktop/Grado/1GradoSuperior/Programacion/src/main/java/programacion/tema12/EjerciciosB/Documentos/pi-million.txt");

        System.out.println("Que numero quieres buscar en el numero PI");
        String numero = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaPi))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        int contador = 0;
        String pi = sb.toString().trim();
        // Recorremos pi buscando el número
        for (int i = 0; i <= pi.length() - numero.length(); i++) {
            int j;
            // Comparamos carácter por carácter cada digito de la cadena que buscamos con
            // la cadena que estamos leyendo de la misma longitud que la q buscamos
            for (j = 0; j < numero.length(); j++) {
                if (pi.charAt(i + j) != numero.charAt(j)) {
                    break; // Si hay una diferencia, terminamos la comparación
                }
            }
            if (j == numero.length()) { // Si j llega al final, hemos encontrado el número
                contador++;
            }
        }

        if (contador > 0) {
            System.out.println("El número " + numero + " aparece " + contador
                    + " veces en los primeros 1M de decimales de π.");
        } else {
            System.out.println("El número " + numero + " no aparece en los primeros 1M de decimales de π.");
        }
    }
}
