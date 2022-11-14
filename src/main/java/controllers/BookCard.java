package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Book;

public class BookCard {

    // importing fields from the fxml view
    @FXML
    public Label bookTitle, bookAuthor;

    // populating the book card (with image)


    // populating the book card (if image isn't available)
    public void setBookCard(Book book) {
        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
    }
}
