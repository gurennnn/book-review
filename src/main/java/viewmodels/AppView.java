package viewmodels;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import models.BookCollection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import models.Book;
import models.Profile;

import org.w3c.dom.Text;
import services.BookSearch;
import services.JsonBookFormat;
import services.JsonResponseFormat;

public class AppView implements Initializable {

    // importing fields from the fxml file
    @FXML
    private AnchorPane scenePane;
    @FXML
    private FlowPane bookCollectionPane;
    @FXML
    private ImageView profilePicture;
    @FXML
    private Label viewLabel;
    @FXML
    private Label userName;
    @FXML
    private TextField bookSearchBar;
    @FXML
    private ListView<Label> searchResults;

    // displaying results in the list view
    public void displayResults() {
        // clearing the ListView
        searchResults.getItems().clear();
        // getting the results
        List<JsonBookFormat> results = getBooksListAsJson(this.bookSearchBar.getText());
        if (results == null) {
            Label label = new Label("No results found");
            searchResults.getItems().add(label);
        } else {
            String bookTitle, bookAuthor;
            int bookPublishDate;
            // for each book, creating a label where the title, author and publish date are shown and adding the label to the list View
            for (JsonBookFormat result : results) {
                bookTitle = result.title;
                bookAuthor = result.author_name.get(0);
                bookPublishDate = result.first_publish_date;
                Label label = new Label(bookTitle + "\n" + bookAuthor + "\n" + bookPublishDate);
                this.searchResults.getItems().add(label);
            }
        }
    }

    // getting the list of books in the json format with the giver title (max size is 5)
    private List<JsonBookFormat> getBooksListAsJson(String bookTitle) {
        //
        try {
            List<JsonBookFormat> booksList = new ArrayList<>();
            String jsonStringResponse = BookSearch.getJsonResponse(bookTitle);
            JsonResponseFormat jsonBookFormat = BookSearch.transformToJsonFormat(jsonStringResponse);
            if (jsonBookFormat == null) return null;
            int counter = 0;
            for (JsonBookFormat jsonBook : jsonBookFormat.docs) {
                if (counter > 5) break;
                booksList.add(jsonBook);
                counter++;
            }
            return booksList;
        } catch (IOException e) {
            return null;
        }
    }

    // mocked data book collection
    private BookCollection collection;

    // displaying username and profile picture in the home page
    public void displayProfileInfo() {
        String[] infos = getProfileDisplayInfo();
        String userName = infos[0];
        String imagePath = infos[1];
        if (!userName.equals("")) {
            this.userName.setText(userName);
        }
        if (!imagePath.equals("")) {
            Image profileImage = new Image(imagePath);
            this.profilePicture.setImage(profileImage);
            this.profilePicture.setFitWidth(65);
            this.profilePicture.setFitHeight(65);
        }
    }

    // getting username and profile picture from the profile.txt file
    private String[] getProfileDisplayInfo() {
        String[] profileInfo = new String[2];
        try {
            FileInputStream input = new FileInputStream(ProfileView.profileFilePath);
            ObjectInputStream profileInput = new ObjectInputStream(input);
            Profile userProfile = (Profile) profileInput.readObject();
            profileInfo[0] = userProfile.getUserName();
            profileInfo[1] = userProfile.getImagePath();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return profileInfo;
    }

    // showing the profile view
    public void showProfile() throws IOException {
        // loading the profile view's fxml file
        FXMLLoader profileLoader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        // creating the profile view
        AnchorPane profileView = profileLoader.load();
        // creating the stage that will show our profile
        Stage profileStage = new Stage();
        // some stage styling
        profileStage.setResizable(false);
        Image icon = new Image("C:\\Users\\ASUS\\Pictures\\Camera Roll\\book-review-icon.png");
        profileStage.getIcons().add(icon);
        profileStage.setTitle("Welcome to your Profile :)");
        // adding the view to a scene and linking it to the profile view
        profileStage.setScene(new Scene(profileView));
        // showing the newly created stage
        profileStage.show();
    }

    // displaying all the books
    public void displayAll() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            // loading the book card view from the appropriate fxml file
            bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
            // creating the card element from the fxml loader
            bookCard = bookCardLoader.load();
            // adding the card to the collection
            this.bookCollectionPane.getChildren().add(bookCard);
            // getting the newly created card's controller
            bookCardController = bookCardLoader.getController();
            // populating the empty card with books
            bookCardController.setBookCard(book);
            // increment the books counter
            booksNumber++;
        }
        // updating the text label
        this.viewLabel.setText("Books List - all - " + booksNumber);
    }

    // displaying favourite books
    public void displayFavourites() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            if (book.getIsFavourite()) {
                // loading the book card view from the appropriate fxml file
                bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
                // creating the card element from the fxml loader
                bookCard = bookCardLoader.load();
                // adding the card to the collection
                this.bookCollectionPane.getChildren().add(bookCard);
                // getting the newly created card's controller
                bookCardController = bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List - favs - " + booksNumber);
    }

    // displaying to read books
    public void displayToRead() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            if (book.getStatus() == Book.Status.TO_READ) {
                // loading the book card view from the appropriate fxml file
                bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
                // creating the card element from the fxml loader
                bookCard = bookCardLoader.load();
                // adding the card to the collection
                this.bookCollectionPane.getChildren().add(bookCard);
                // getting the newly created card's controller
                bookCardController = bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List - to read - " + booksNumber);
    }

    // displaying currently reading books
    public void displayReading() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            if (book.getStatus() == Book.Status.READING) {
                // loading the book card view from the appropriate fxml file
                bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
                // creating the card element from the fxml loader
                bookCard = bookCardLoader.load();
                // adding the card to the collection
                this.bookCollectionPane.getChildren().add(bookCard);
                // getting the newly created card's controller
                bookCardController = bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List - reading - " + booksNumber);
    }

    // displaying read books
    public void displayRead() throws IOException {

        // we start by making sure our collection pane is empty
        this.bookCollectionPane.getChildren().clear();

        FXMLLoader bookCardLoader;
        AnchorPane bookCard;
        BookCard bookCardController;

        int booksNumber = 0;

        for (Book book : this.collection.getMyCollection()) {
            if (book.getStatus() == Book.Status.READ) {
                // loading the book card view from the appropriate fxml file
                bookCardLoader = new FXMLLoader(getClass().getResource("book-card.fxml"));
                // creating the card element from the fxml loader
                bookCard = bookCardLoader.load();
                // adding the card to the collection
                this.bookCollectionPane.getChildren().add(bookCard);
                // getting the newly created card's controller
                bookCardController = bookCardLoader.getController();
                // populating the empty card with books
                bookCardController.setBookCard(book);
                // increment the books counter
                booksNumber++;
            }
        }
        // updating the text label
        this.viewLabel.setText("Books List - read - " + booksNumber);
    }

    // exit method
    public void exit() {
        // popup alert window
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit");
        // exit confirmation
        if (alert.showAndWait().get() == ButtonType.OK) {
            // getting the current stage to exit
            Stage stage = (Stage) this.scenePane.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.collection = new BookCollection();
        displayProfileInfo();
        try {
            displayAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}