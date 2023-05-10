package greene.ctis310;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NewSetController {
    // Instance variables
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;

    @FXML
    private TextField titleTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private TextArea descriptionField;

    // Methods

    /*
     * Save Method
     * 
     * This method creates a new CardSet object and sets the title, author, and
     * description of the CardSet object if the CardSet object is not already in the CardSets.txt file. The window then closes
     */
    // save method
    @FXML
    private void save() throws IOException {
        // create a new CardSet object
        // set the title, author, and description of the CardSet object
        // add the CardSet object to the CardSetManager
        CardSet cardSet = new CardSet(titleTextField.getText(), authorTextField.getText(), descriptionField.getText());
        if (cardSet.createCardSet() == -1) {
            descriptionField.setPromptText("Error: Card Set already exists, please try again.");
        } else {
            FlashcardMain.currentCardSet = cardSet;
            FlashcardMain.currentFlashcard = cardSet.getFlashcards().get(0);
            // close the window
            // get the parent of the save button
            // get the scene of the parent
            // get the window of the scene
            // close the window
            Parent parent = saveButton.getParent();
            parent.getScene().getWindow().hide();
        }
    }

    /*
     * Cancel Method
     * 
     * This method closes the window.
     * 
     */
    // cancel method
    @FXML
    private void cancel() throws IOException {
        // close the window
        // get the parent of the cancel button
        // get the scene of the parent
        // get the window of the scene
        // close the window
        Parent parent = cancelButton.getParent();
        parent.getScene().getWindow().hide();
    }
}