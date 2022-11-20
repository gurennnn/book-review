package viewmodels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Book;

import java.io.IOException;

public class BookCard {

    // importing fields from the fxml view
    @FXML
    private Label bookTitle, bookAuthor, bookID;

    // populating the book card (with image)
    @FXML
    private ImageView bookImage;
    public static String _imageURL = "https://covers.openlibrary.org/b/id/";
    public static String imageURL_ = "-M.jpg";

    // populating the book card
    public void setBookCard(Book book) {
        bookID.setText(String.valueOf(book.getId()));
        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
        bookImage.setImage(new Image(_imageURL + book.getCoverID() + imageURL_));
    }

    // open the book view
    public void openBookView() throws IOException {
        BookView.id = Integer.parseInt(this.bookID.getText());
        // loading the book view's fxml file
        FXMLLoader bookLoader = new FXMLLoader(getClass().getResource("book-view.fxml"));
        // creating the profile view
        AnchorPane bookView = bookLoader.load();
        // creating the stage that will show our profile
        Stage bookStage = new Stage();
        // some stage styling
        bookStage.setResizable(false);
        Image icon = new Image("C:\\Users\\ASUS\\Pictures\\Camera Roll\\book-review-icon.png");
        bookStage.getIcons().add(icon);
        bookStage.setTitle("Book View: " + bookTitle.getText());
        // adding the view to a scene and linking it to the profile view
        bookStage.setScene(new Scene(bookView));
        // showing the newly created stage
        bookStage.show();
    }
}
