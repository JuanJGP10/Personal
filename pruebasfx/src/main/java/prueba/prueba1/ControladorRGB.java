package prueba.prueba1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControladorRGB {
    @FXML
    TextField textoR;
    @FXML
    TextField textoG;
    @FXML
    TextField textoB;
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
    private void cambioDeslizantes(Slider slider, TextField tf) {
        // Setteamos el texto al valor nuevo del slider
        tf.setText(String.valueOf((int) slider.getValue()));
        // Cambiamos el color del panel
        setColorPane();
    }

    @FXML
    private void initialize() {
        /*
         * Especie de triggers que ejecutan el metodo cambioDeslizantes o
         * cambioTextFields cuando se mueve
         * un deslizador o cambia una textField
         */
        deslizadorR.valueProperty().addListener(observer -> cambioDeslizantes(deslizadorR, textoR));
        deslizadorG.valueProperty().addListener(observer -> cambioDeslizantes(deslizadorG, textoG));
        deslizadorB.valueProperty().addListener(observer -> cambioDeslizantes(deslizadorB, textoB));

        textoR.textProperty().addListener(observer -> cambioTextFields(deslizadorR, textoR));
        textoG.textProperty().addListener(observer -> cambioTextFields(deslizadorG, textoG));
        textoB.textProperty().addListener(observer -> cambioTextFields(deslizadorB, textoB));
    }

    @FXML
    private void setColorPane() {
        // Agregamos el color correspondiente al panel
        String color = "rgb(" + deslizadorR.getValue() + "," + deslizadorG.getValue() + "," + deslizadorB.getValue()
                + ")";
        panelColor
                .setStyle("-fx-background-color:" + color + ";\n -fx-border-style: solid; \n -fx-border-width: 5px}");
        // Sacamos el valor en formato web del color
        int decimalR = (int) deslizadorR.getValue();
        int decimalG = (int) deslizadorG.getValue();
        int decimalB = (int) deslizadorB.getValue();
        String hexadecimalR = Integer.toHexString(decimalR);
        String hexadecimalG = Integer.toHexString(decimalG);
        String hexadecimalB = Integer.toHexString(decimalB);
        /*
         * Agregamos a la etiqueta y la formateamos para que en caso de que el
         * hexadecimal sea solo un numero salga el 0 al lado
         */
        etiqueta.setText(("#" + (hexadecimalR.length() == 1 ? "0" : "") + hexadecimalR + (hexadecimalG.length() == 1
                ? "0"
                : "") + hexadecimalG + (hexadecimalB.length() == 1 ? "0" : "") + hexadecimalB).toUpperCase());
    }

    @FXML
    private void cambioTextFields(Slider slider, TextField tf) {
        /*
         * Validamos el valor escrito en la textField y si es valido efectuamos el
         * cambio al slider
         */
        if (validator(tf.getText())) {
            int numero = Integer.parseInt(tf.getText());
            if (numero >= 0 && numero <= 255)
                slider.setValue(numero);
        }

    }

    private boolean validator(String numero) {
        // Validamos si es un numero o tiene otro formato
        try {
            int var = Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
