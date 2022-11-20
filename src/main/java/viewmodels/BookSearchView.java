package viewmodels;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.BookSearch;
import services.DBInteraction;

public class BookSearchView {

    // fxml fields
    @FXML
    private Label bookSearchTitle, bookSearchAuthor, bookSearchDate, bookSearchCoverID;

    // populating the bookSearchPane
    public void setBookSearch(BookSearch bookSearch) {
        this.bookSearchTitle.setText(bookSearch.getTitle());
        this.bookSearchAuthor.setText(bookSearch.getAuthor());
        this.bookSearchDate.setText(String.valueOf(bookSearch.getDate()));
        this.bookSearchCoverID.setText(String.valueOf(bookSearch.getCoverID()));
    }

    // add selected book to the book collection
    public void addBook() {
        String title = this.bookSearchTitle.getText();
        String author = this.bookSearchAuthor.getText();
        int date = Integer.parseInt(this.bookSearchDate.getText());
        int coverID = Integer.parseInt(this.bookSearchCoverID.getText());
        DBInteraction.addBook(title, author, date, coverID);
        AppView.collection = DBInteraction.getBookCollection();
    }
}
