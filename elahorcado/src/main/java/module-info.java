module project.ahorcado {
    requires javafx.controls;
    requires javafx.fxml;

    opens project.ahorcado to javafx.fxml;
    exports project.ahorcado;
}
