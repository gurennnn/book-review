package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextField bookSearchBar;
    @FXML
    private Button bookSearchButton;

    // mocked data book collection
    private BookCollection collection;

    // displaying the collection
    public void displayCollection() throws IOException {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.collection = new BookCollection();
        this.collection.addBook(BookSample.Candide.getBook());
        this.collection.addBook(BookSample.ThePerfume.getBook());
        this.collection.addBook(BookSample.TheSupplication.getBook());
        try {
            displayCollection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}