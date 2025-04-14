package programacion.tema9.MaratonEjercicios.ej917;

public class Main {
    public static void main(String[] args) {
        Esfera_v4 esfera = new Esfera_v4(5);
        PrismaRectangular_v4 prisma = new PrismaRectangular_v4(4, 6, 8);
        Cilindro_v4 cilindro_v4 = new Cilindro_v4(5, 6);
        System.out.println("Esfera Superficie:" + esfera.superficie());
        System.out.println("Prisma Superficie:" + prisma.superficie());
        System.out.println("Cilindro Superficie:" + cilindro_v4.superficie());

    }

}
