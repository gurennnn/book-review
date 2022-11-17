package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import models.Profile;

public class ProfileView implements Initializable {

    // importing fields from the fxml file
    @FXML
    private AnchorPane profilePane;
    @FXML
    private ImageView profilePicture;
    @FXML
    private TextField userNameField, firstNameField, lastNameField, ageField, countryField, emailField, gsmField;

    // path to the profile savings directory
    private static final String profileFilePath = "C:\\Users\\ASUS\\IdeaProjects\\book-review\\src\\main\\resources\\savings\\profile.txt";
    // path to the image saving directory
    private static final String imageFilePath = "C:\\Users\\ASUS\\IdeaProjects\\book-review\\src\\main\\resources\\savings\\image.txt";
    // path to the default image directory
    private static final File imageDirectory = new File("C:\\Users\\ASUS\\Pictures\\Camera Roll");

    // displaying profile information
    public void displayProfile() {
        // displaying information from the deserialized profile object
        Profile userProfile = this.getProfileFromTxt();
        if (userProfile != null) {
            // displaying text fields
            this.userNameField.setText(userProfile.getUserName());
            this.firstNameField.setText(userProfile.getFirstName());
            this.lastNameField.setText(userProfile.getLastName());
            this.ageField.setText(userProfile.getAge() == 0 ? "" : String.valueOf(userProfile.getAge()));
            this.countryField.setText(userProfile.getCountry());
            this.emailField.setText(userProfile.getEmail());
            this.gsmField.setText(userProfile.getGsm());
            // displaying the image
            String imagePath = userProfile.getImagePath();
            if (imagePath != null) {
                try {
                    this.profilePicture.setImage(new Image(new FileInputStream(imagePath)));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // getting the user profile from the serialized .txt file (if it exists)
    private Profile getProfileFromTxt() {
        // retrieving the profile from the 'profile.txt' file if it exists (deserialization)
        try {
            FileInputStream input = new FileInputStream(profileFilePath);
            ObjectInputStream profileInput = new ObjectInputStream(input);
            return (Profile) profileInput.readObject();
        } catch (IOException | ClassNotFoundException ce) {
            return null; // in this case no profile has ever been saved.
        }
    }

    // updating the profile
    public void updateProfile() {
        // creating the updated profile for serialization
        Profile updatedProfile = this.getProfileFromView();
        // serialization process
        try {
            FileOutputStream output = new FileOutputStream(profileFilePath);
            ObjectOutputStream profileOutput = new ObjectOutputStream(output);
            profileOutput.writeObject(updatedProfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getting the user's profile from the profile view that has been modified
    private Profile getProfileFromView() {
        // getting the instance fields from the view
        String userName = this.userNameField.getText();
        String firstName = this.firstNameField.getText();
        String lastName = this.lastNameField.getText();
        int age = Integer.parseInt(this.ageField.getText().equals("") ? "0" : this.ageField.getText());
        String country = this.countryField.getText();
        String email = this.emailField.getText();
        String gsm = this.gsmField.getText();
        String imagePath = null;
        Image image = this.profilePicture.getImage();
        if (image != null) {
            imagePath = getImagePath();
        }
        // creating the updated profile for serialization
        return new Profile(userName, firstName, lastName, country, email, gsm, age, imagePath);
    }

    // changing the profile picture
    public void changePFP() {
        // profile stage
        Stage stage = (Stage)this.profilePane.getScene().getWindow();
        // invoking a fileChooser
        FileChooser fileChooser = new FileChooser();
        // fileChooser styling
        fileChooser.setTitle("Select an Image");
        fileChooser.setInitialDirectory(imageDirectory);
        // showing the file dialog
        File picFile = fileChooser.showOpenDialog(stage);
        // getting the chosen file
        if (picFile != null) {
            try {
                String path = picFile.getPath();
                this.profilePicture.setImage(new Image(new FileInputStream(path)));
                this.profilePicture.setFitWidth(130);
                this.profilePicture.setFitHeight(130);

                saveImagePath(path);
            } catch (FileNotFoundException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    // saving the temporary image path
    private static void saveImagePath(String imagePath) {
        try {
            FileOutputStream output = new FileOutputStream(imageFilePath);
            ObjectOutputStream profileOutput = new ObjectOutputStream(output);
            profileOutput.writeObject(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // getting the temporary image path
    private static String getImagePath() {
        try {
            FileInputStream input = new FileInputStream(imageFilePath);
            ObjectInputStream imageInput = new ObjectInputStream(input);
            return (String) imageInput.readObject();
        } catch (IOException | ClassNotFoundException ce) {
            return null; // in this case no profile has ever been saved.
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayProfile();
    }
}
