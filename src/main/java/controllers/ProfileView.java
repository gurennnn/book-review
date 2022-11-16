package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.embed.swing.SwingFXUtils;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Profile;

public class ProfileView implements Initializable {

    // importing fields from the fxml file
    @FXML
    private AnchorPane scenePane;
    @FXML
    private ImageView profilePicture;
    @FXML
    private Label changeProfilePicture;
    @FXML
    private TextField userNameField, firstNameField, lastNameField, ageField, countryField, emailField, gsmField;

    // path to the savings directory
    private static String filePath = "C:\\Users\\ASUS\\IdeaProjects\\book-review\\src\\main\\resources\\savings\\profile.txt";

    // displaying profile information
    public void displayProfile() {
        // displaying information from the deserialized profile object
        Profile userProfile = this.getProfileFromTxt();
        if (userProfile != null) {
            // displaying text fields
            this.userNameField.setText(userProfile.getUserName());
            this.firstNameField.setText(userProfile.getFirstName());
            this.lastNameField.setText(userProfile.getLastName());
            this.ageField.setText(String.valueOf(userProfile.getAge()));
            this.countryField.setText(userProfile.getCountry());
            this.emailField.setText(userProfile.getEmail());
            this.gsmField.setText(userProfile.getGsm());
            // displaying the image
            /*
            BufferedImage profileImage = userProfile.getProfilePicture();
            WritableImage wi = null;
            if (profileImage != null) {
                wi = new WritableImage(profileImage.getWidth(), profileImage.getHeight());
                PixelWriter pw = wi.getPixelWriter();
                for (int x = 0; x < profileImage.getWidth(); x++) {
                    for (int y = 0; y < profileImage.getHeight(); y++) {
                        pw.setArgb(x, y, profileImage.getRGB(x, y));
                    }
                }
                this.profilePicture.setImage(new ImageView(wi).getImage());
            }
             */
        }
    }

    // updating the profile
    public void updateProfile() {
        // creating the updated profile for serialization
        Profile updatedProfile = this.getProfileFromView();
        // serialization process
        try {
            FileOutputStream output = new FileOutputStream(filePath);
            ObjectOutputStream profileOutput = new ObjectOutputStream(output);
            profileOutput.writeObject(updatedProfile);
        } catch (IOException e) {
            System.out.println("failed to update");
        }
        // Stage stage = (Stage) this.scenePane.getScene().getWindow();
        // stage.close();
    }

    // getting the user profile from the serialized .txt file (if it exists)
    private Profile getProfileFromTxt() {
        // retrieving the profile from the 'profile.txt' file if it exists (deserialization)
        try {
            FileInputStream input = new FileInputStream(filePath);
            ObjectInputStream profileInput = new ObjectInputStream(input);
            Profile userProfile = (Profile) profileInput.readObject();
            return userProfile;
        } catch (IOException | ClassNotFoundException ce) {
            return null; // in this case no profile has ever been saved.
        }
    }

    private Profile getProfileFromView() {
        // getting the instance fields from the view
        String userName = this.userNameField.getText();
        String firstName = this.firstNameField.getText();
        String lastName = this.lastNameField.getText();
        int age = Integer.parseInt(this.ageField.getText());
        String country = this.countryField.getText();
        String email = this.emailField.getText();
        String gsm = this.gsmField.getText();
        // BufferedImage profileImage = SwingFXUtils.fromFXImage(this.profilePicture.getImage(), null);
        // creating the updated profile for serialization
        Profile updatedProfile = new Profile(userName, firstName, lastName, country, email, gsm, age, null);
        return updatedProfile;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayProfile();
    }
}
