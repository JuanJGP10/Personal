package project.ahorcado;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Controlador principal del juego del Ahorcado en JavaFX.
 * Controla la lógica del juego, interfaz gráfica y eventos de usuario.
 */
public class controladorAhorcado {

    /** Número de fallos cometidos por el jugador. */
    private int fallos = 0;

    /** Lista de letras que el jugador ya ha pulsado. */
    private ArrayList<Character> letrasPulsadas = new ArrayList<>();

    /** Palabra que el jugador debe adivinar. */
    private String palabraAdivinar;

    /** Número máximo de fallos permitidos antes de perder. */
    public static final int MAX_FALLOS = 6;

    @FXML
    BorderPane borderPanel;

    @FXML
    TilePane panelBotones;

    @FXML
    Label titulo;

    @FXML
    Label palabra;

    @FXML
    ImageView imagen;

    @FXML
    ImageView imagenJuego;

    /**
     * Método que se llama automáticamente al inicializar el controlador.
     * Prepara la interfaz y comienza una nueva partida.
     */
    @FXML
    private void initialize() {
        elegirPalabraRandom();
        codificarPalabra();
        imagen.setImage(new Image(
                controladorAhorcado.class.getResourceAsStream("Hangman-0.png")));
        imagenJuego.setImage(new Image(
                controladorAhorcado.class.getResourceAsStream("ahorcado.png")));
        generarLetras();

    }

    /**
     * Genera los botones de la A a la Z y los coloca en el panel.
     */
    private void generarLetras() {
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        panelBotones.setHgap(10);
        panelBotones.setVgap(10);
        panelBotones.setPrefColumns(5);
        panelBotones.setAlignment(Pos.CENTER);

        for (int i = 0; i < letras.length(); i++) {
            Button boton = new Button("" + letras.charAt(i));
            boton.setFocusTraversable(false);
            boton.setMinSize(30, 30);
            boton.setOnAction(acciones -> pulsarBoton(boton.getText(), boton));
            boton.getStyleClass().add("boton-letra");
            panelBotones.getChildren().add(boton);

        }
    }

    /**
     * 
     * Método que se ejecuta al pulsar un botón/letra.
     *
     * @param c     Letra pulsada.
     * @param boton Botón correspondiente (se desactiva tras usarse).
     */
    private void pulsarBoton(String c, Button boton) {
        boton.getStyleClass().remove("boton-letra");
        boton.getStyleClass().add("boton-pulsado");
        boton.setDisable(true);
        boolean acertada = true;
        letrasPulsadas.add(c.charAt(0));

        if (palabraAdivinar.contains(c)) {
            String formaSecreto = "";
            for (int i = 0; i < palabraAdivinar.length(); i++) {
                if (letrasPulsadas.contains(palabraAdivinar.charAt(i))) {
                    formaSecreto += palabraAdivinar.charAt(i) + " ";
                } else {
                    acertada = false;
                    formaSecreto += "_ ";
                }
            }
            palabra.setText(formaSecreto.trim());
        } else {
            fallos++;
            acertada = false;
            imagen.setImage(new Image(controladorAhorcado.class
                    .getResourceAsStream("Hangman-" + fallos + ".png")));
        }

        if (acertada) {
            alertaInformacion("La partida ha acabado", null, "Has ganado", "has_ganado.png");
            alertaVolverAJugar();
        }

        if (fallos == MAX_FALLOS) {
            alertaInformacion("La partida ha acabado", null, "Has perdido, la palabra era " + palabraAdivinar,
                    "Hangman-6.png");
            alertaVolverAJugar();
        }
    }

    /**
     * Codifica la palabra a adivinar en formato "_ _ _" para mostrar al jugador.
     */
    private void codificarPalabra() {
        String palabraAdivinarCodificada = "";
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            palabraAdivinarCodificada += "_ ";
        }
        palabra.setText(palabraAdivinarCodificada);
    }

    /**
     * Reinicia el juego completamente, eligiendo nueva palabra y limpiando estado.
     */
    private void reiniciarJuego() {
        fallos = 0;
        letrasPulsadas.clear();
        panelBotones.getChildren().clear();
        initialize();
    }

    /**
     * Muestra una alerta de confirmación preguntando si el jugador quiere jugar de
     * nuevo.
     * Si acepta, reinicia el juego. Si no, cierra la aplicación.
     */
    private void alertaVolverAJugar() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("New Game");
        alert.setHeaderText("¿Deseas jugar otra partida?");
        alert.setContentText("Dale a aceptar para empezar de nuevo");
        alert.getDialogPane().getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        alert.getDialogPane().getStyleClass().add("alertas");
        Image imagen = new Image(controladorAhorcado.class.getResourceAsStream("partida_nueva.png"));
        ImageView vista = new ImageView(imagen);
        vista.setFitWidth(150);
        vista.setFitHeight(150);
        alert.setGraphic(vista);

        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            reiniciarJuego();
        } else {
            // Menos forzoso que un System.exit(0);
            ((Stage) borderPanel.getScene().getWindow()).close();
        }
    }

    /**
     * Muestra una alerta informativa con imagen personalizada.
     *
     * @param title      Título de la alerta.
     * @param header     Texto del encabezado (puede ser null).
     * @param context    Texto del contenido principal.
     * @param imagenPath Ruta de la imagen a mostrar.
     */
    private void alertaInformacion(String title, String header, String context, String ruta) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.getDialogPane().setPrefWidth(300);
        alerta.getDialogPane().getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        alerta.getDialogPane().getStyleClass().add("alertas");
        alerta.setTitle(title);
        alerta.setHeaderText(header);
        alerta.setContentText(context);
        Image imagen = new Image(controladorAhorcado.class.getResourceAsStream(ruta));
        ImageView vista = new ImageView(imagen);
        vista.setFitWidth(150);
        vista.setFitHeight(150);
        alerta.setGraphic(vista);

        alerta.showAndWait();
    }

    /**
     * Elige una palabra aleatoria del archivo palabras.txt.
     * Con su correción pertinente para poder abrirse cuando sea un .jar
     */
    private void elegirPalabraRandom() {
        try {
            URI uri = controladorAhorcado.class
                    .getResource("/project/ahorcado/palabras.txt").toURI();
            Path path;

            if ("jar".equals(uri.getScheme())) {
                FileSystem fileSystem;
                try {
                    fileSystem = FileSystems.getFileSystem(uri);
                } catch (FileSystemNotFoundException e) {
                    fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
                }
                path = fileSystem.getPath("/project/ahorcado/palabras.txt");
            } else {
                path = Paths.get(uri);
            }

            List<String> listaPalabras = Files.readAllLines(path);
            palabraAdivinar = listaPalabras
                    .get(ThreadLocalRandom.current().nextInt(0, listaPalabras.size() + 1))
                    .toUpperCase();

        } catch (URISyntaxException | IOException e) {
            System.out.println("Ruta no existe o error leyendo archivo: " + e.getMessage());
        }
    }

}
