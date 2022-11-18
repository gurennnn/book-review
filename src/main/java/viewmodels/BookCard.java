package viewmodels;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Book;

import javax.swing.text.html.ImageView;

public class BookCard {

    // importing fields from the fxml view
    @FXML
    private Label bookTitle, bookAuthor;

    // populating the book card (with image)
    @FXML
    private ImageView bookImage;

    // populating the book card (if image isn't available)
    public void setBookCard(Book book) {
        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
    }
}
