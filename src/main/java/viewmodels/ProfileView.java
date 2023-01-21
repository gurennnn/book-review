package viewmodels;

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
    private TextField firstNameField, lastNameField, ageField, countryField, emailField, gsmField;

    // path to the profile savings directory
    public static final String profileFilePath = ".\\src\\main\\resources\\savings\\profile.txt";

    // displaying profile information
    public void displayProfile() {
        // displaying information from the deserialized profile object
        Profile userProfile = this.getProfileFromTxt();
        if (userProfile != null) {
            // displaying text fields
            this.firstNameField.setText(userProfile.getFirstName());
            this.lastNameField.setText(userProfile.getLastName());
            this.ageField.setText(userProfile.getAge() == 0 ? "" : String.valueOf(userProfile.getAge()));
            this.countryField.setText(userProfile.getCountry());
            this.emailField.setText(userProfile.getEmail());
            this.gsmField.setText(userProfile.getGsm());
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
        String firstName = this.firstNameField.getText();
        String lastName = this.lastNameField.getText();
        int age = Integer.parseInt(this.ageField.getText().equals("") ? "0" : this.ageField.getText());
        String country = this.countryField.getText();
        String email = this.emailField.getText();
        String gsm = this.gsmField.getText();
        // creating the updated profile for serialization
        return new Profile(firstName, lastName, country, email, gsm, age);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayProfile();
    }
}
