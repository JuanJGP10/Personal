package programacion.tema9.MaratonEjercicios.ej916;

public class Main {
    public static void main(String[] args) {
        Esfera_v3 esfera = new Esfera_v3(5);
        PrismaRectangular_v3 prisma = new PrismaRectangular_v3(4, 6, 8);

        System.out.println("Esfera Superficie:" + esfera.superficie());
        System.out.println("Prisma Superficie:" + prisma.superficie());

    }

}
