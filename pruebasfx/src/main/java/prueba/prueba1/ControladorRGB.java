package prueba.prueba1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControladorRGB {
    @FXML
    TextField r;
    @FXML
    TextField g;
    @FXML
    TextField b;
    @FXML
    Slider deslizadorR;
    @FXML
    Slider deslizadorG;
    @FXML
    Slider deslizadorB;
    @FXML
    Pane panelColor;
    @FXML
    Label etiqueta;

    @FXML
    private void cambioDeslizantes() {
        r.setText(String.valueOf(Math.round(deslizadorR.getValue())));
        g.setText(String.valueOf(Math.round(deslizadorG.getValue())));
        b.setText(String.valueOf(Math.round(deslizadorB.getValue())));
    }

    @FXML
    private void initialize() {
        deslizadorR.valueProperty().addListener(observable -> {
            cambioDeslizantes();
            setColorPane();
            setHexadecimal();
        });
        deslizadorG.valueProperty().addListener(observable -> {
            cambioDeslizantes();
            setColorPane();
            setHexadecimal();
        });
        deslizadorB.valueProperty().addListener(observable -> {
            cambioDeslizantes();
            setColorPane();
            setHexadecimal();

        });

    }

    @FXML
    private void setColorPane() {
        String color = "rgb(" + deslizadorR.getValue() + "," + deslizadorG.getValue() + "," + deslizadorB.getValue()
                + ")";
        panelColor.setStyle("-fx-background-color:" + color);
    }

    private void setHexadecimal() {
        int decimalR = (int) deslizadorR.getValue();
        int decimalG = (int) deslizadorG.getValue();
        int decimalB = (int) deslizadorB.getValue();
        String hexadecimalR = Integer.toHexString(decimalR);
        String hexadecimalG = Integer.toHexString(decimalG);
        String hexadecimalB = Integer.toHexString(decimalB);

        etiqueta.setText(hexadecimalR + hexadecimalG + hexadecimalB);
    }

}
