module proyecto.bdoo {
    requires javafx.controls;
    requires javafx.fxml;

    opens proyecto.bdoo to javafx.fxml;
    exports proyecto.bdoo;
}
