package proyecto.bdoo.persona;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class Persona {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private String apellidos;
    private String direccion;
    private int codigoPostal;
    private String ciudad;
    private LocalDate fechaNacimiento;

    @Transient
    private final StringProperty nombreProperty;
    @Transient
    private final StringProperty apellidosProperty;
    @Transient
    private final StringProperty direccionProperty;
    @Transient
    private final IntegerProperty codigoPostalProperty;
    @Transient
    private final StringProperty ciudadProperty;
    @Transient
    private final ObjectProperty<LocalDate> fechaNacimientoProperty;

    /**
     * Constructor por defecto.
     */
    public Persona() {
        this(null, null);
    }

    /**
     * Constructor con algunos datos iniciales.
     *
     * @param nombre    el nombre de la persona
     * @param apellidos los apellidos de la persona
     */
    public Persona(String nombre, String apellidos) {
        this.nombreProperty = new SimpleStringProperty(nombre);
        this.apellidosProperty = new SimpleStringProperty(apellidos);

        // Datos de prueba por defecto
        this.direccionProperty = new SimpleStringProperty("tu calle");
        this.codigoPostalProperty = new SimpleIntegerProperty(3190);
        this.ciudadProperty = new SimpleStringProperty("Pilar de la Horadada");
        this.fechaNacimientoProperty = new SimpleObjectProperty<>(LocalDate.of(2002, 2, 20));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public StringProperty getNombreProperty() {
        return nombreProperty;
    }

    public StringProperty getApellidosProperty() {
        return apellidosProperty;
    }

    public StringProperty getDireccionProperty() {
        return direccionProperty;
    }

    public IntegerProperty getCodigoPostalProperty() {
        return codigoPostalProperty;
    }

    public StringProperty getCiudadProperty() {
        return ciudadProperty;
    }

    public ObjectProperty<LocalDate> getFechaNacimientoProperty() {
        return fechaNacimientoProperty;
    }

    // //
    public void setNombreProperty(String nombre) {
        this.nombreProperty.set(nombre);
    }

    public void setApellidosProperty(String apellidos) {
        this.apellidosProperty.set(apellidos);
    }

    public void setCiudadProperty(String ciudad) {
        this.ciudadProperty.set(ciudad);
    }

    public void setCodigoPostalProperty(int codigoPostal) {
        this.codigoPostalProperty.set(codigoPostal);
    }

    public void setFechaNacimientoProperty(LocalDate fecha) {
        this.fechaNacimientoProperty.set(fecha);
    }

    public void setDireccionProperty(String direccion) {
        this.direccionProperty.set(direccion);
    }

}
