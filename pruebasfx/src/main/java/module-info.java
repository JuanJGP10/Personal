module prueba.prueba1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens prueba.prueba1 to javafx.fxml;
    exports prueba.prueba1;
}
