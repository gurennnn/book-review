package viewmodels;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Book;
import services.DBInteraction;

import java.net.URL;
import java.util.ResourceBundle;

public class BookView implements Initializable {

    // view fields
    @FXML
    private AnchorPane bookViewPane;
    @FXML
    private ImageView bookCover;
    @FXML
    private Label bookTitle, bookAuthor, bookYear;
    @FXML
    private CheckBox bookIsFavourite;
    @FXML
    private RadioButton bookStatus1, bookStatus2, bookStatus3;
    @FXML
    private Slider bookRatingSlider;
    @FXML
    private TextArea bookReviewField;


    // current book's id field
    public static int id;

    // deleting a book from the list
    public void deleteBook() {
        DBInteraction.deleteBookById(id);
        AppView.collection = DBInteraction.getBookCollection();
        Stage bookStage = (Stage) this.bookViewPane.getScene().getWindow();
        bookStage.close();
    }

    // updating the book changes
    public void submitChanges() {
        int rating = (int) bookRatingSlider.getValue();
        int isFavourite = this.bookIsFavourite.isSelected() ? 1 : 0;
        String status;
        if (bookStatus2.isSelected()) {
            status = "READING";
        } else if (bookStatus3.isSelected()) {
            status = "READ";
        } else {
            status = "TO_READ";
        }
        String review = bookReviewField.getText();
        DBInteraction.updateBookById(id, isFavourite, rating, status, review);
        AppView.collection = DBInteraction.getBookCollection();
        Stage bookStage = (Stage) this.bookViewPane.getScene().getWindow();
        bookStage.close();
    }

    // displaying book information
    public void displayBookInfo() {
        Book book = DBInteraction.getBookById(id);
        this.bookCover.setImage(new Image(BookCard._imageURL + book.getCoverID() + BookCard.imageURL_));
        this.bookTitle.setText(book.getTitle());
        this.bookAuthor.setText(book.getAuthor());
        this.bookYear.setText(String.valueOf(book.getYear()));
        this.bookIsFavourite.setSelected(book.getIsFavourite());
        this.bookRatingSlider.adjustValue(book.getRating());
        Book.Status status = book.getStatus();
        switch (status) {
            case READING -> {
                this.bookStatus2.selectedProperty().setValue(true);
                break;
            }
            case READ -> {
                this.bookStatus3.selectedProperty().setValue(true);
                break;
            }
            default -> {
                this.bookStatus1.selectedProperty().setValue(true);
                break;
            }
        }
        this.bookReviewField.setText(book.getReview());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayBookInfo();
    }
}
