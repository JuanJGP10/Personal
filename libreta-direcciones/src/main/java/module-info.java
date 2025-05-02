module proyecto.bdoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.persistence;
    requires java.sql;

    opens proyecto.bdoo to javafx.fxml;

    exports proyecto.bdoo;

    opens proyecto.bdoo.persona to javafx.fxml;

    exports proyecto.bdoo.persona;
}
