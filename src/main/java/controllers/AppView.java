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

        // loading the book card view from the appropriate fxml file
        FXMLLoader bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));

        // getting the newly created card's controller
        BookCard bookCardController = new BookCard();
        //bookCardLoader.setController(bookCardController);

        // populating the empty card with books
        //bookCardController.setBookCard(BookSample.Candide.getBook());

        // adding the card to our cards container
        AnchorPane pane = bookCardLoader.load();
        bookCollectionPane.getChildren().add(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.collection = new BookCollection();
        this.collection.addBook(BookSample.Candide.getBook());
        this.collection.addBook(BookSample.ThePerfume.getBook());
        this.collection.addBook(BookSample.TheSupplication.getBook());
        try {
            this.displayCollection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}