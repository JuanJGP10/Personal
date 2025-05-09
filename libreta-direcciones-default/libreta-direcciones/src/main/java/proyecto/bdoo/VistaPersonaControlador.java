package proyecto.bdoo;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import proyecto.bdoo.persona.Persona;
import proyecto.bdoo.util.UtilidadDeFechas;

public class VistaPersonaControlador implements Initializable {

    @FXML
    private TableView<Persona> personaTabla;

    @FXML
    private TableColumn<Persona, String> nombreColumna;

    @FXML
    private TableColumn<Persona, String> apellidosColumna;

    @FXML
    private Label nombreEtiqueta;

    @FXML
    private Label apellidosEtiqueta;

    @FXML
    private Label direccionEtiqueta;

    @FXML
    private Label codigoPostalEtiqueta;

    @FXML
    private Label ciudadEtiqueta;

    @FXML
    private Label fechaNacimientoEtiqueta;

    // Referencia a la clase principal
    private LibretaDirecciones libretaDirecciones;

    /**
     * Constructor vacío. Se llama antes de initialize().
     */
    public VistaPersonaControlador() {
    }

    /**
     * Este método se ejecuta automáticamente después de que el FXML haya sido
     * cargado.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidosColumna.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());

        // Borramos los textos de los datos de una persona
        mostrarDetallesPersona(null);

        // Escuchamos cambios en la selección de la tabla para mostrar los detalles
        personaTabla.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetallesPersona(newValue));
    }

    /**
     * Se llama desde la clase principal para pasarle la referencia del modelo
     * principal.
     * 
     * @param libretaD Referencia a LibretaDirecciones
     */
    public void setLibretaDirecciones(LibretaDirecciones libretaD) {
        this.libretaDirecciones = libretaD;

        // Carga los datos en la tabla
        personaTabla.setItems(libretaD.getDatosPersona());
    }

    /**
     * Rellena todos los textos para mostrar los detalles de una persona
     * Si la persona es null, los textos se borran
     *
     * @param persona la persona o null
     */
    private void mostrarDetallesPersona(Persona persona) {
        if (persona != null) {
            // Fill the labels with info from the person object.
            nombreEtiqueta.setText(persona.getNombre());
            apellidosEtiqueta.setText(persona.getApellidos());
            direccionEtiqueta.setText(persona.getDireccion());
            codigoPostalEtiqueta.setText(Integer.toString(persona.getCodigoPostal()));
            ciudadEtiqueta.setText(persona.getCiudad());
            fechaNacimientoEtiqueta.setText(UtilidadDeFechas.formato(persona.getFechaNacimiento()));

        } else {
            // Person is null, remove all the text.
            nombreEtiqueta.setText("");
            apellidosEtiqueta.setText("");
            direccionEtiqueta.setText("");
            codigoPostalEtiqueta.setText("");
            ciudadEtiqueta.setText("");
            fechaNacimientoEtiqueta.setText("");
        }
    }

    @FXML
    private void borrarPersona() {
        int indiceSeleccionado = personaTabla.getSelectionModel().getSelectedIndex();
        if (indiceSeleccionado >= 0)
            personaTabla.getItems().remove(indiceSeleccionado);
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Atención");
            alert.setHeaderText("Persona no seleccionada");
            alert.setContentText("Porfavor, selecciona una persona para borrar");
            alert.showAndWait();
        }

    }

    // Muestro el diálogo editar persona cuando el usuario hace clic en el botón de
    // Crear

    @FXML
    private void crearPersona() {
        Persona temporal = new Persona();
        boolean guardarClicked = libretaDirecciones.muestraEditarPersona(temporal);
        if (guardarClicked) {
            libretaDirecciones.getDatosPersona().add(temporal);
        }
    }

    // Muestro el diálogo editar persona cuando el usuario hace clic en el botón de
    // Editar

    @FXML
    private void editarPersona() {
        Persona seleccionada = personaTabla.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            boolean guardarClicked = libretaDirecciones.muestraEditarPersona(seleccionada);
            if (guardarClicked) {
                mostrarDetallesPersona(seleccionada);
            }
        } else {
            // Muestro alerta
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Alerta");
            alerta.setHeaderText("Persona no seleccionada");
            alerta.setContentText("Por favor, selecciona una persona");
            alerta.showAndWait();
        }
    }

}
