module controllers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens controllers to javafx.fxml;
    exports controllers;
}