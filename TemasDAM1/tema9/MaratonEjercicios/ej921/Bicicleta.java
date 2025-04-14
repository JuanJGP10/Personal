package programacion.tema9.MaratonEjercicios.ej921;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bicicleta {

    private LocalDate fechaFinDescuento;
    private String marca;
    private String modelo;
    private double precio;
    private double descuento = 0;

    public Bicicleta(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public void fijarDescuento() {
        descuento = 0.1;
        fechaFinDescuento = LocalDate.now().plusDays(30);
    }

    public void fijarDescuento(double d) {
        descuento = d;
        fechaFinDescuento = LocalDate.now().plusDays(30);
    }

    public void fijarDescuento(double d, int meses) {
        descuento = d;
        fechaFinDescuento = LocalDate.now().plusDays(meses * 30);
    }

    public double precioFinal() {
        return precio - (precio * descuento);
    }

    public void informacionConDescuento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf(
                "Bicicleta {  Marca: %s  Modelo: %s  Precio: %.2f $ PrecioFinal: %.2f $ Fecha de fin de descuento: %s } \n",
                marca, modelo, precio, precioFinal(),
                fechaFinDescuento.format(formatter));
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return String.format(
                "Bicicleta {\n  Marca: %s\n  Modelo: %s\n  Precio: %.2f $\n",
                marca, modelo, precio, descuento * 100, precio - (precio * descuento));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bicicleta other = (Bicicleta) obj;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        return true;
    }

}
