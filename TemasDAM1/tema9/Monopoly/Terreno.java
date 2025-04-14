package programacion.tema9.Monopoly;

public class Terreno extends Propiedad {

    // public enum ColorTerreno {
    // ROJO, AMARILLO, VERDE
    // };
    // Clase interna (usar si solo se usa la enumeracion aqui, ocmo en este caso)
    // private Terreno.ColorTerreno color
    private ColorTerreno color;
    private int precioAlquiler;

    public Terreno(String nombre, int precio, int hipoteca, ColorTerreno color,
            int precioAlquiler) {
        super(nombre, precio, hipoteca);
        this.color = color;
        this.precioAlquiler = precioAlquiler;
    }

    public ColorTerreno getColor() {
        return color;
    }

    public void setColor(ColorTerreno color) {
        this.color = color;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public int getAlquiler(int modificador) {

        if (modificador > 4) {
            return precioAlquiler * 10;
        } else {

            return precioAlquiler + (modificador * precioAlquiler);
        }

    }

    @Override
    public String toString() {
        return super.toString() + " Color=" + color + ", PrecioAlquiler=" + precioAlquiler;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + precioAlquiler;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Terreno other = (Terreno) obj;
        if (color != other.color)
            return false;
        if (precioAlquiler != other.precioAlquiler)
            return false;
        return true;
    }

}
