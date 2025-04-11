package project.ahorcado;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class controladorAhorcado {

    private int fallos = 0;
    private ArrayList<Character> letrasPulsadas = new ArrayList<>();
    private String palabraAdivinar;
    public static final int MAX_FALLOS = 6;

    @FXML
    SplitPane panel;

    @FXML
    AnchorPane panelDerecho;

    @FXML
    Label titulo;

    @FXML
    Label palabra;

    @FXML
    ImageView imagen;

    @FXML
    ImageView imagenJuego;

    @FXML
    private void initialize() {
        elegirPalabraRandom();
        codificarPalabra();
        imagen.setImage(new Image(
                controladorAhorcado.class.getResourceAsStream("/project/ahorcado/Hangman-0.png")));
        imagenJuego.setImage(new Image(
                controladorAhorcado.class.getResourceAsStream("/project/ahorcado/ahorcado.png")));
        generarLetras();

    }

    int ejeX = 60;
    int ejeY = 200;

    private void generarLetras() {

        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        for (char i : letras.toCharArray()) {

            Button boton = new Button("" + i);
            boton.setLayoutX(ejeX);
            boton.setLayoutY(ejeY);
            boton.setFocusTraversable(false);

            boton.setOnAction(acciones -> pulsarBoton(boton.getText(), boton));

            ejeX += 40;
            if (ejeX > 360) {
                ejeX = 60;
                ejeY += 30;
            }

            panelDerecho.getChildren().add(boton);
        }

    }

    private void pulsarBoton(String c, Button boton) {
        boton.setDisable(true);
        boolean acertada = true;
        letrasPulsadas.add(c.charAt(0));
        if (palabraAdivinar.contains(c)) {

            String formaSecreto = "";
            for (int i = 0; i < palabraAdivinar.length(); i++) {
                if (letrasPulsadas.contains(palabraAdivinar.charAt(i))) {
                    formaSecreto = formaSecreto + palabraAdivinar.charAt(i) + " ";
                } else {

                    acertada = false;
                    formaSecreto += "_ ";
                }
            }
            palabra.setText(formaSecreto.trim());
        } else {

            fallos++;
            acertada = false;

            imagen.setImage(
                    new Image(controladorAhorcado.class
                            .getResourceAsStream("/project/ahorcado/Hangman-" + fallos + ".png")));
        }

        if (acertada) {
            Alert alertaGanado = new Alert(AlertType.INFORMATION);
            alertaGanado.setTitle("La partida ha acabado");
            alertaGanado.setContentText("Has ganado");
            alertaGanado.setHeaderText(null);
            alertaGanado.showAndWait();
            alertaVolverAJugar();
        }
        if (fallos == MAX_FALLOS) {
            Alert alertaPerdido = new Alert(AlertType.INFORMATION);
            alertaPerdido.setTitle("La partida ha acabado");
            alertaPerdido.setContentText("Has perdido");
            alertaPerdido.setHeaderText(null);
            alertaPerdido.showAndWait();
            alertaVolverAJugar();
        }
    }

    private void codificarPalabra() {

        String palabraAdivinarCodificada = "";
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            palabraAdivinarCodificada += "_ ";
        }

        palabra.setText(palabraAdivinarCodificada);
    }

    private void reiniciarJuego() {
        fallos = 0;
        letrasPulsadas.clear();
        ejeX = 60;
        ejeY = 200;
        panelDerecho.getChildren().removeIf(s -> s instanceof Button);
        elegirPalabraRandom();
        codificarPalabra();
        imagen.setImage(new Image(
                controladorAhorcado.class.getResourceAsStream("/project/ahorcado/Hangman-0.png")));
        generarLetras();

    }

    private void alertaVolverAJugar() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("¿Quieres jugar otra?");
        alert.setHeaderText("Partida nueva");

        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            reiniciarJuego();
        } else {
            System.exit(0);
        }

    }

    private void elegirPalabraRandom() {
        try {
            Path path = Paths.get(controladorAhorcado.class
                    .getResource("/project/ahorcado/palabras.txt").toURI());

            List<String> listaPalabras = Files.readAllLines(path);
            palabraAdivinar = listaPalabras.get(ThreadLocalRandom.current().nextInt(0, listaPalabras.size() + 1))
                    .toUpperCase();
        } catch (URISyntaxException | IOException e) {
            System.out.println("Ruta no existe");
        }
        System.out.println(palabraAdivinar);
    }

}
