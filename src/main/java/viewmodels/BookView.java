package viewmodels;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BookView implements Initializable {

    // view fields
    @FXML
    private AnchorPane bookPane;
    @FXML
    private Label bookTitle, bookAuthor, bookDate;
    @FXML
    private RadioButton bookStatus1, bookStatus2, bookStatus3;
    @FXML
    private Slider bookRatingSlider;
    @FXML
    private TextArea bookReviewField;
    @FXML
    private ImageView bookCover;
    @FXML
    private Button submitButton;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
