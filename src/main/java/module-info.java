module controllers {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.sql;
    requires java.desktop;

    opens viewmodels to javafx.fxml;
    exports viewmodels;
}