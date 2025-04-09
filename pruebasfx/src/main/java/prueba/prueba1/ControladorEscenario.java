package prueba.prueba1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class ControladorEscenario {
    @FXML
    Pane panel;
    @FXML
    Button botonVerde;
    @FXML
    Button botonRojo;
    @FXML
    Slider selector;
    @FXML
    Label etiqueta;

    @FXML
    private void pulsarBotonVerde() {
        panel.setStyle("-fx-background-color: green;");
    }

    @FXML
    private void pulsarBotonRojo() {
        panel.setStyle("-fx-background-color: red;");
    }

    @FXML
    private void cambioDeslizante() {
        etiqueta.setText(String.valueOf(selector.getValue()));
    }

    @FXML
    private void initialize() {
        selector.valueProperty().addListener(observable -> cambioDeslizante());
    }
}
