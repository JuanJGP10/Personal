package proyecto.bdoo.persona;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Access(AccessType.FIELD)
public class Persona {

    @Id
    @GeneratedValue
    public long id;

    public String nombre;
    public String apellidos;
    public String direccion;
    public int codigoPostal;
    public String ciudad;
    public LocalDate fechaNacimiento;

    @Transient
    private StringProperty nombreProperty = new SimpleStringProperty();
    @Transient
    private StringProperty apellidosProperty = new SimpleStringProperty();
    @Transient
    private StringProperty direccionProperty = new SimpleStringProperty();
    @Transient
    private IntegerProperty codigoPostalProperty = new SimpleIntegerProperty();
    @Transient
    private StringProperty ciudadProperty = new SimpleStringProperty();
    @Transient
    private ObjectProperty<LocalDate> fechaNacimientoProperty = new SimpleObjectProperty<>();

    /**
     * Constructor por defecto.
     */
    public Persona() {

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
        this.nombre = nombre;
        this.apellidos = apellidos;
        // Datos de prueba por defecto
        this.setDireccionProperty("tu calle");
        this.setCodigoPostalProperty(3190);
        this.setCiudadProperty("Pilar de la Horadada");
        this.setFechaNacimientoProperty(LocalDate.of(2002, 2, 20));
    }

    public Persona(String nombre, String apellidos, String direccion, int codigoPostal, String ciudad,
            LocalDate fechaNacimiento) {
        this.setNombreProperty(nombre);
        this.setApellidosProperty(apellidos);
        this.setDireccionProperty(direccion);
        this.setCodigoPostalProperty(codigoPostal);
        this.setCiudadProperty(ciudad);
        this.setFechaNacimientoProperty(fechaNacimiento);
    }

    // Sincronizar las propiedades JavaFX con los campos persistentes
    @PostLoad
    private void onLoad() {
        System.out.println("ONLOAD");
        nombreProperty.set(nombre);
        apellidosProperty.set(apellidos);
        direccionProperty.set(direccion);
        codigoPostalProperty.set(codigoPostal);
        ciudadProperty.set(ciudad);
        fechaNacimientoProperty.set(fechaNacimiento);
    }

    @PrePersist
    @PreUpdate
    private void onSave() {
        System.out.println("ONSAVE");
        nombre = nombreProperty.get();
        apellidos = apellidosProperty.get();
        direccion = direccionProperty.get();
        codigoPostal = codigoPostalProperty.get();
        ciudad = ciudadProperty.get();
        fechaNacimiento = fechaNacimientoProperty.get();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombreProperty.get();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombreProperty(String nombre) {
        this.nombreProperty.set(nombre);
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidosProperty.get();
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setApellidosProperty(String apellidos) {
        this.apellidosProperty.set(apellidos);
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccionProperty.get();
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDireccionProperty(String direccion) {
        this.direccionProperty.set(direccion);
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostalProperty.get();
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setCodigoPostalProperty(int codigoPostal) {
        this.codigoPostalProperty.set(codigoPostal);
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudadProperty.get();
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCiudadProperty(String ciudad) {
        this.ciudadProperty.set(ciudad);
        this.ciudad = ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimientoProperty.get();
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaNacimientoProperty(LocalDate fecha) {
        this.fechaNacimientoProperty.set(fecha);
        this.fechaNacimiento = fecha;
    }

}
