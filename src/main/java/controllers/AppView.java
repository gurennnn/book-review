package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import models.BookCollection;
import models.Book;
import models.BookSample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppView implements Initializable {

    // importing fields from the fxml view files
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label viewLabel;
    @FXML
    private FlowPane bookCollectionPane;
    @FXML
    private TextField bookSearchBar;
    @FXML
    private Button bookSearchButton;

    // mocked data book collection
    private BookCollection collection;

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
            bookCardController = (BookCard) bookCardLoader.getController();
            // populating the empty card with books
            bookCardController.setBookCard(book);
            // increment the books counter
            booksNumber++;
        }
        // updating the text label
        this.viewLabel.setText("Books List (All) : " + booksNumber);
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
                bookCardController = (BookCard) bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List (Favourites) : " + booksNumber);
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
                bookCardController = (BookCard) bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List (To Read) : " + booksNumber);
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
                bookCardController = (BookCard) bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List (Reading) : " + booksNumber);
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
                bookCardController = (BookCard) bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List (Read) : " + booksNumber);
    }

    // exit method
    public void exit(Event e) {
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
        this.collection = new BookCollection();
        this.collection.addBook(BookSample.Candide.getBook());
        this.collection.addBook(BookSample.ThePerfume.getBook());
        this.collection.addBook(BookSample.TheSupplication.getBook());
        this.collection.addBook(BookSample.TheAlchemist.getBook());
        this.collection.getMyCollection().get(0).setIsFavourite(true);
        this.collection.getMyCollection().get(2).setIsFavourite(true);
        this.collection.getMyCollection().get(0).setStatus(Book.Status.READ);
        this.collection.getMyCollection().get(2).setStatus(Book.Status.READ);
        this.collection.getMyCollection().get(3).setStatus(Book.Status.READING);
        try {
            displayAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}