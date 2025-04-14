package programacion.tema8.EjerciciosNormales;

public class Ej11 {
    public static void main(String[] args) {
        int array1[] = new int[100];
        int array2[] = new int[100];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1;
        }

        int contador = 0;

        for (int i = array1.length - 1; i >= 0; i--) {
            array2[i] = array1[contador];
            contador++;
        }

        System.out.println("Array 1");
        for (int i : array1) {
            System.out.println(i);
        }

        System.out.println("Array 2");
        for (int i : array2) {
            System.out.println(i);
        }
    }
}
