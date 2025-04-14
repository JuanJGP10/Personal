package programacion.tema9.MaratonEjercicios.ej915;

public class Main {
    public static void main(String[] args) {
        Esfera_v2 esfera = new Esfera_v2(5);
        PrismaRectangular_v2 prisma = new PrismaRectangular_v2(4, 6, 8);
        Cilindro_v2 cilindro = new Cilindro_v2(5, 8);

        System.out.println("Esfera Superficie:" + esfera.superficie());
        System.out.println("Prisma Superficie:" + prisma.superficie());
        System.out.println("Cilindro Superficie:" + cilindro.superficie());

    }

}
