module controllers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.swing;

    opens controllers to javafx.fxml;
    exports controllers;
}