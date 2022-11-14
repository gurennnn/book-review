package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Popup;
import models.BookCollection;
import models.Book;
import models.BookSample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppView implements Initializable {

    // importing fields from the fxml view files
    @FXML
    private FlowPane bookCollectionPane;
    @FXML
    private Button displayFavouritesButton;
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
        }
    }

    // displaying favourite books
    public void displayFavourites() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

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
            }
        }
    }

    // displaying to read books
    public void displayToRead() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

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
            }
        }
    }

    // displaying currently reading books
    public void displayReading() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

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
            }
        }
    }

    // displaying read books
    public void displayRead() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

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
            }
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