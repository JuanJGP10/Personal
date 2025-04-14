package programacion.tema9.MaratonEjercicios.ej914;

public class Main {
    public static void main(String[] args) {
        Esfera_v1 esfera = new Esfera_v1(5); // Radio de 5 unidades
        PrismaRectangular_v1 prisma = new PrismaRectangular_v1(4, 6, 8); // Largo=4, Ancho=6, Alto=8

        double volumenEsfera = esfera.volumen();
        double volumenPrisma = prisma.volumen();

        System.out.printf("Volumen de la esfera: %.2f\n", volumenEsfera);
        System.out.printf("Volumen del prisma rectangular: %.2f\n", volumenPrisma);

        if (volumenEsfera > volumenPrisma) {
            System.out.println("La esfera ocupa más volumen.");
        } else if (volumenEsfera < volumenPrisma) {
            System.out.println("El prisma rectangular ocupa más volumen.");
        } else {
            System.out.println("Ambas figuras tienen el mismo volumen.");
        }
    }
}
