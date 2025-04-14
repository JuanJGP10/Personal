package programacion.tema8a9;

public class CuadradoMagico {
    public static boolean esCuadradoMagico(int[][] matriz) {
        // Verifico que la matriz sea cuadrada
        int tamaño = matriz.length;
        for (int[] fila : matriz) {
            if (fila.length != tamaño) {
                return false;
            }
        }

        // Creo la suma referencial que usare para verificar que todas las sumas sean
        // iguales
        int sumaReferencia = 0;
        for (int num : matriz[0]) {
            sumaReferencia += num;
        }

        // Miro la suma de las filas y comparo con la referencia
        for (int i = 1; i < matriz.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < matriz.length; j++) {
                sumaFila += matriz[i][j];
            }
            if (sumaFila != sumaReferencia) {
                return false;
            }
        }

        // Miro la suma de las columnas y comparo con la referencia
        for (int j = 0; j < matriz.length; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < matriz.length; i++) {
                sumaColumna += matriz[i][j];
            }
            if (sumaColumna != sumaReferencia) {
                return false;
            }
        }

        // Miro la suma de la diagonal principal y comparo con la referencia
        int sumaDiagonalPrincipal = 0;
        for (int i = 0; i < matriz.length; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
        }
        if (sumaDiagonalPrincipal != sumaReferencia) {
            return false;
        }

        // Miro la suma de la diagonal contraria y comparo con la referencia
        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < matriz.length; i++) {
            sumaDiagonalSecundaria += matriz[i][matriz.length - 1 - i];
        }
        if (sumaDiagonalSecundaria != sumaReferencia) {
            return false;
        }

        return true;
    }
}
