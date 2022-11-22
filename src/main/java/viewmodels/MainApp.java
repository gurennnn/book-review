package viewmodels;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        // launching the app
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("app-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Book Review");
        stage.setResizable(false);
        stage.show();
        // linking the exit method with the closing 'x' button
        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });
    }

    public void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }
}