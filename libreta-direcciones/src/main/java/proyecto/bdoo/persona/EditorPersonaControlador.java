package proyecto.bdoo.persona;

import java.net.URL;
import java.util.ResourceBundle;

import proyecto.bdoo.LibretaDirecciones;
import proyecto.bdoo.util.UtilidadDeFechas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EditorPersonaControlador implements Initializable {

    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField apellidosTextField;
    @FXML
    private TextField direccionTextField;
    @FXML
    private TextField codigoPostalTextField;
    @FXML
    private TextField ciudadTextField;
    @FXML
    private TextField fechaNacimientoTextField;

    private Stage escenarioEdicion;
    private Persona persona;
    private boolean guardarClicked = false;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

    public void setEscenarioEdicion(Stage escenarioEdicion) {
        this.escenarioEdicion = escenarioEdicion;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        nombreTextField.setText(persona.getNombre());
        apellidosTextField.setText(persona.getApellidos());
        direccionTextField.setText(persona.getDireccion());
        codigoPostalTextField.setText(String.valueOf(persona.getCodigoPostal()));
        ciudadTextField.setText(persona.getCiudad());
        fechaNacimientoTextField.setText(UtilidadDeFechas.formato(persona.getFechaNacimiento()));
        fechaNacimientoTextField.setPromptText("dd/mm/yyyy");
    }

    public boolean isGuardarClicked() {
        return guardarClicked;
    }

    @FXML
    private void guardar() {
        if (datosValidos()) {
            persona.setNombreProperty(nombreTextField.getText());
            persona.setApellidosProperty(apellidosTextField.getText());
            persona.setDireccionProperty(direccionTextField.getText());
            persona.setCodigoPostalProperty(Integer.parseInt(codigoPostalTextField.getText()));
            persona.setCiudadProperty(ciudadTextField.getText());
            persona.setFechaNacimientoProperty(UtilidadDeFechas.convertir(fechaNacimientoTextField.getText()));
            guardarClicked = true;
            escenarioEdicion.close();
        }
    }

    @FXML
    private void cancelar() {
        escenarioEdicion.close();
    }

    private boolean datosValidos() {
        String mensajeError = "";

        if (nombreTextField.getText() == null || nombreTextField.getText().length() == 0) {
            mensajeError += "Nombre no válido.\n";
        }
        if (apellidosTextField.getText() == null || apellidosTextField.getText().length() == 0) {
            mensajeError += "Apellidos no válidos.\n";
        }
        if (direccionTextField.getText() == null || direccionTextField.getText().length() == 0) {
            mensajeError += "Dirección no válida.\n";
        }
        if (codigoPostalTextField.getText() == null || codigoPostalTextField.getText().length() == 0) {
            mensajeError += "Código postal no válido.\n";
        } else {
            try {
                Integer.parseInt(codigoPostalTextField.getText());
            } catch (NumberFormatException e) {
                mensajeError += "Código postal no válido (debe ser un entero).\n";
            }
        }
        if (ciudadTextField.getText() == null || ciudadTextField.getText().length() == 0) {
            mensajeError += "Ciudad no válida.\n";
        }
        if (fechaNacimientoTextField.getText() == null || fechaNacimientoTextField.getText().length() == 0) {
            mensajeError += "Fecha de nacimiento no válida.\n";
        } else {
            if (!UtilidadDeFechas.fechaValida(fechaNacimientoTextField.getText())) {
                mensajeError += "Fecha de nacimiento no válida (debe tener formato dd/mm/yyyy).\n";
            }
        }

        if (mensajeError.length() == 0) {
            return true;
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);

            // Cambiar ícono del diálogo
            Stage stage = (Stage) alerta.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(LibretaDirecciones.class.getResourceAsStream("images/alert.png")));

            alerta.getDialogPane().getStylesheets()
                    .add(LibretaDirecciones.class.getResource("css/darkTheme.css").toExternalForm());
            alerta.getDialogPane().getStyleClass().add("alertas");

            alerta.setTitle("Error");
            alerta.setHeaderText("Datos no válidos");
            alerta.setContentText("Por favor, corrige los errores");
            alerta.showAndWait();
            return false;
        }
    }
}
