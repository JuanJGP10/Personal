package proyecto.bdoo;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import proyecto.bdoo.persona.Persona;

public class LibretaDirecciones extends Application {

    private Stage escenarioPrincipal;
    private BorderPane contenedorPrincipal;

    /**
     * Lista observable con los datos de personas.
     * Esta lista se puede vincular a una TableView.
     */
    private ObservableList<Persona> datosPersona = FXCollections.observableArrayList();

    /**
     * Constructor: inicializa la libreta con datos de ejemplo.
     */
    public LibretaDirecciones() {
        datosPersona.add(new Persona("Aitor", "Tilla"));
        datosPersona.add(new Persona("Paco", "Jones"));
        datosPersona.add(new Persona("Victor", "Tazo"));
        datosPersona.add(new Persona("Aquiles", "Castro"));
        datosPersona.add(new Persona("Elton", "Tito"));
        datosPersona.add(new Persona("Aitor", "Menta"));
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
