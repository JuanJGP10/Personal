package project.ahorcado;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("ahorcado"), 500, 850);
        stage.setScene(scene);
        stage.setTitle("El ahorcado - Juan");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("ahorcadoLogo.png")));
        stage.setMinHeight(800);
        stage.setMinWidth(425);
        stage.setOnCloseRequest(ventana -> {
            Alert alertaCierre = new Alert(AlertType.CONFIRMATION);
            alertaCierre.getDialogPane().getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            alertaCierre.getDialogPane().getStyleClass().add("alertas");
            alertaCierre.setTitle("Exit");
            alertaCierre.setHeaderText("Intentando salir. Se perderá el progreso");
            alertaCierre.setContentText("Quieres salir del juego?");
            Image imagen = new Image(controladorAhorcado.class.getResourceAsStream("adios.png"));
            ImageView vista = new ImageView(imagen);
            vista.setFitWidth(150);
            vista.setFitHeight(150);
            alertaCierre.setGraphic(vista);
            Optional<ButtonType> resultado = alertaCierre.showAndWait();
            if (resultado.isPresent() && resultado.get() != ButtonType.OK) {
                ventana.consume();
            }
        });
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}