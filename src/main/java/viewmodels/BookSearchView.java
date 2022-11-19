package viewmodels;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.BookSearch;

public class BookSearchView {

    // fxml fields
    @FXML
    private Label bookSearchTitle, bookSearchAuthor, bookSearchDate;

    // populating the bookSearchPane
    public void setBookSearch(BookSearch bookSearch) {
        this.bookSearchTitle.setText(bookSearch.getTitle());
        this.bookSearchAuthor.setText(bookSearch.getAuthor());
        this.bookSearchDate.setText(String.valueOf(bookSearch.getDate()));
    }

    // add selected to the book collection

}
