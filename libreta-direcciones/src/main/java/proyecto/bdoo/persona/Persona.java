package proyecto.bdoo.persona;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellidos;
    private String direccion;
    private int codigoPostal;
    private String ciudad;
    private LocalDate fechaNacimiento;

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

    public void allSetters(String nombre, String apellidos, String direccion, int codigoPostal, String ciudad,
            LocalDate fechaNacimiento) {
        this.setNombreProperty(nombre);
        this.setApellidosProperty(apellidos);
        this.setDireccionProperty(direccion);
        this.setCodigoPostalProperty(codigoPostal);
        this.setCiudadProperty(ciudad);
        this.setFechaNacimientoProperty(fechaNacimiento);
    }

    public StringProperty getNombreProperty() {
        return nombreProperty;
    }

    public StringProperty getApellidosProperty() {
        return apellidosProperty;
    }

    public long getId() {
        return id;
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

    // getters atributos persistentes

    public String getNombreDB() {
        return nombre;
    }

    public String getApellidosDB() {
        return apellidos;
    }

    public String getDireccionDB() {
        return direccion;
    }

    public int getCodigoPostalDB() {
        return codigoPostal;
    }

    public String getCiudadDB() {
        return ciudad;
    }

    public LocalDate getFechaNacimientoDB() {
        return fechaNacimiento;
    }
}
