package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import models.BookCollection;
import models.Book;
import models.BookSample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppView implements Initializable {

    // importing fields from the fxml file
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label viewLabel;
    @FXML
    private FlowPane bookCollectionPane;

    // mocked data book collection
    private BookCollection collection;

    // showing the profile view
    public void showProfile() throws IOException {
        // loading the profile view's fxml file
        FXMLLoader profileLoader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        // creating the profile view
        AnchorPane profileView = profileLoader.load();
        // creating the stage that will show our profile
        Stage profileStage = new Stage();
        // some stage styling
        profileStage.setResizable(false);
        Image icon = new Image("C:\\Users\\ASUS\\Pictures\\Camera Roll\\book-review-icon.png");
        profileStage.getIcons().add(icon);
        profileStage.setTitle("Welcome to your Profile :)");
        // adding the view to a scene and linking it to the profile view
        profileStage.setScene(new Scene(profileView));
        // showing the newly created stage
        profileStage.show();
    }

    // displaying all the books
    public void displayAll() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            // loading the book card view from the appropriate fxml file
            bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
            // creating the card element from the fxml loader
            bookCard = bookCardLoader.load();
            // adding the card to the collection
            this.bookCollectionPane.getChildren().add(bookCard);
            // getting the newly created card's controller
            bookCardController = bookCardLoader.getController();
            // populating the empty card with books
            bookCardController.setBookCard(book);
            // increment the books counter
            booksNumber++;
        }
        // updating the text label
        this.viewLabel.setText("Books List - all - " + booksNumber);
    }

    // displaying favourite books
    public void displayFavourites() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            if (book.getIsFavourite()) {
                // loading the book card view from the appropriate fxml file
                bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
                // creating the card element from the fxml loader
                bookCard = bookCardLoader.load();
                // adding the card to the collection
                this.bookCollectionPane.getChildren().add(bookCard);
                // getting the newly created card's controller
                bookCardController = bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List - favs - " + booksNumber);
    }

    // displaying to read books
    public void displayToRead() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            if (book.getStatus() == Book.Status.TO_READ) {
                // loading the book card view from the appropriate fxml file
                bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
                // creating the card element from the fxml loader
                bookCard = bookCardLoader.load();
                // adding the card to the collection
                this.bookCollectionPane.getChildren().add(bookCard);
                // getting the newly created card's controller
                bookCardController = bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List - to read - " + booksNumber);
    }

    // displaying currently reading books
    public void displayReading() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            if (book.getStatus() == Book.Status.READING) {
                // loading the book card view from the appropriate fxml file
                bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
                // creating the card element from the fxml loader
                bookCard = bookCardLoader.load();
                // adding the card to the collection
                this.bookCollectionPane.getChildren().add(bookCard);
                // getting the newly created card's controller
                bookCardController = bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List - reading - " + booksNumber);
    }

    // displaying read books
    public void displayRead() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            if (book.getStatus() == Book.Status.READ) {
                // loading the book card view from the appropriate fxml file
                bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
                // creating the card element from the fxml loader
                bookCard = bookCardLoader.load();
                // adding the card to the collection
                this.bookCollectionPane.getChildren().add(bookCard);
                // getting the newly created card's controller
                bookCardController = bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List - read - " + booksNumber);
    }

    // exit method
    public void exit() {
        // popup alert window
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit");
        // exit confirmation
        if (alert.showAndWait().get() == ButtonType.OK) {
            // getting the current stage to exit
            Stage stage = (Stage) this.scenePane.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            displayAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}