module book_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.sql;
    requires java.desktop;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    opens viewmodels to javafx.fxml;
    exports models;
    exports services;
    exports viewmodels;
}