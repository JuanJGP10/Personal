package proyecto.bdoo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyecto.bdoo.persona.EditorPersonaControlador;
import proyecto.bdoo.persona.Persona;
import proyecto.bdoo.persona.VistaPersonaControlador;

public class LibretaDirecciones extends Application {

    private Stage escenarioPrincipal;
    private BorderPane contenedorPrincipal;
    private static SistemaGestionPersonas sp = new SistemaGestionPersonas();
    /**
     * Lista observable con los datos de personas.
     * Esta lista se puede vincular a una TableView.
     */
    private ObservableList<Persona> datosPersona = FXCollections.observableArrayList();

    /**
     * Constructor: inicializa la libreta con datos de ejemplo.
     */
    public LibretaDirecciones() {

        List<Persona> listaPDB = sp.obtenerTodasLasPersonas();
        for (Persona p : listaPDB) {
            p.allSetters(p.getNombreDB(), p.getApellidosDB(), p.getDireccionDB(), p.getCodigoPostalDB(),
                    p.getCiudadDB(),
                    p.getFechaNacimientoDB());
        }
        datosPersona.addAll(listaPDB);

    }

    /**
     * Devuelve la lista observable de personas.
     * 
     * @return lista de personas
     */
    public ObservableList<Persona> getDatosPersona() {

        return datosPersona;
    }

    @Override
    public void start(Stage escenarioPrincipal) {
        // Guardamos una referencia al escenario principal
        this.escenarioPrincipal = escenarioPrincipal;

        // Establecemos el título de la ventana
        this.escenarioPrincipal.setTitle("Libreta de direcciones");

        // Icono de aplicacion
        this.escenarioPrincipal.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.png")));

        // Alerta al salir
        escenarioPrincipal.setOnCloseRequest(ventana -> {
            Alert alertaCierre = new Alert(AlertType.CONFIRMATION);

            // Cambiar ícono del diálogo
            Stage stage = (Stage) alertaCierre.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(LibretaDirecciones.class.getResourceAsStream("images/exit.png")));

            alertaCierre.getDialogPane().getStylesheets()
                    .add(getClass().getResource("css/darkTheme.css").toExternalForm());
            alertaCierre.getDialogPane().getStyleClass().add("alertas");

            alertaCierre.setTitle("Exit");
            alertaCierre.setHeaderText("Intentando salir. Los datos se guardarán en la base de datos");
            alertaCierre.setContentText("Estas seguro de que quieres salir?");
            Optional<ButtonType> resultado = alertaCierre.showAndWait();
            if (resultado.isPresent() && resultado.get() != ButtonType.OK) {
                ventana.consume();
            }
        });

        // Inicializamos el contenedor principal
        initContenedorPrincipal();

        // Mostramos la vista de personas en el centro del contenedor principal
        mostrarVistaPersona();
    }

    /**
     * Inicializa el contenedor raíz (BorderPane) desde el archivo FXML.
     */
    public void initContenedorPrincipal() {
        try {
            // Cargamos el archivo FXML del contenedor principal
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LibretaDirecciones.class.getResource("vistaPrincipal.fxml"));
            contenedorPrincipal = (BorderPane) loader.load();

            // Creamos la escena con el contenedor y la asignamos al escenario principal
            Scene scene = new Scene(contenedorPrincipal);
            escenarioPrincipal.setMinHeight(450);
            escenarioPrincipal.setMinWidth(675);
            escenarioPrincipal.setScene(scene);
            escenarioPrincipal.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga y muestra la vista de persona dentro del centro del contenedor
     * principal.
     */
    public void mostrarVistaPersona() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LibretaDirecciones.class.getResource("persona/vistaPersona.fxml"));
            AnchorPane personOverview = loader.load();

            contenedorPrincipal.setCenter(personOverview);

            VistaPersonaControlador controlador = loader.getController();
            controlador.setLibretaDirecciones(this);
        } catch (IOException e) {
            System.err.println("Error al cargar vistaPersona.fxml:");
            e.printStackTrace();
        }
    }

    // Vista editarPersona
    public boolean muestraEditarPersona(Persona persona, boolean crear) {
        // Cargo la vista persona a partir de VistaPersona.fxml
        AnchorPane editarPersona = null;
        FXMLLoader loader = new FXMLLoader();

        try {
            URL location = LibretaDirecciones.class.getResource("persona/editarPersona.fxml");
            loader.setLocation(location);
            editarPersona = (AnchorPane) loader.load();
        } catch (IOException ex) {
            // ex.printStackTrace();
            System.err.println("---------------------------------------");
            return false;
        }

        // Creo el escenario de edición (con modal) y establezco la escena
        Stage escenarioEdicion = new Stage();
        escenarioEdicion.setTitle("Editar Persona");
        escenarioEdicion.initModality(Modality.WINDOW_MODAL);
        escenarioEdicion.initOwner(escenarioPrincipal);
        Scene escena = new Scene(editarPersona);
        escenarioEdicion.setScene(escena);
        escenarioEdicion.getIcons().add(new Image(LibretaDirecciones.class.getResourceAsStream("images/editar.png")));
        escenarioEdicion.setResizable(false);

        // Asigno el escenario de edición y la persona seleccionada al controlador
        EditorPersonaControlador controlador = loader.getController();
        controlador.setEscenarioEdicion(escenarioEdicion);
        controlador.setPersona(persona);

        // Muestro el diálogo hasta que el usuario lo cierre
        escenarioEdicion.showAndWait();

        if (controlador.isGuardarClicked() && !crear) {

            sp.actualizarPersona(persona.getId(), persona.getNombre(), persona.getApellidos(),
                    persona.getDireccion(),
                    persona.getCodigoPostal(), persona.getCiudad(),
                    persona.getFechaNacimiento());
        }

        if (controlador.isGuardarClicked() && crear) {

            sp.crearPersona(persona.getNombre(), persona.getApellidos(),
                    persona.getDireccion(),
                    persona.getCodigoPostal(), persona.getCiudad(),
                    persona.getFechaNacimiento());
        }

        // devuelvo el botón pulsado
        return controlador.isGuardarClicked();
    }

    /**
     * Devuelve el escenario principal.
     */
    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
