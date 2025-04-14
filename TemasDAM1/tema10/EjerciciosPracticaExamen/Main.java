package programacion.tema10.EjerciciosPracticaExamen;

public class Main {
    public static void main(String[] args) {
        try {
            VideojuegoFisico fisico1 = new VideojuegoFisico("ABCADHAA", "The Last of Us", "PS5", 59.99, 10);
            VideojuegoFisico fisico2 = new VideojuegoFisico("XYZADADD", "God of War", "PS5", 49.99, 5);
            VideojuegoFisico fisico3 = new VideojuegoFisico("LMNAVGHG", "Halo Infinite", "Xbox", 54.99, 7);

            VideojuegoDigital digital1 = new VideojuegoDigital("QWERTYUIOPAS", "Cyberpunk 2077", "PC", 39.99);
            VideojuegoDigital digital2 = new VideojuegoDigital("ASDFGHJKLÑZX", "Elden Ring", "PC", 59.99);
            VideojuegoDigital digital3 = new VideojuegoDigital("ZXCVBNMASDFG", "Red Dead Redemption 2", "PC", 49.99);

            Tienda tienda = new Tienda();
            tienda.añadirProductos(digital3);
            tienda.añadirProductos(digital1);
            tienda.añadirProductos(digital2);

            tienda.añadirProductos(fisico1);
            tienda.añadirProductos(fisico2);
            tienda.añadirProductos(fisico3);

            tienda.ordenar();

        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
