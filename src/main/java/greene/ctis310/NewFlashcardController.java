package greene.ctis310;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class NewFlashcardController {
    @FXML
    private TextArea frontSideTextArea;
    @FXML
    private TextArea backSideTextArea;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;


    /*
     * saveFlashcard method
     * This method creates a new Flashcard object and adds it to the CardSet object.
     * It then closes the window.
     * If the front side or back side of the Flashcard object is empty, it will prompt the user to enter a side.
     * If the Flashcard object already exists in the CardSet object, it will prompt the user to try again.
     * 
     * @param none
     * @return void
     * 
     */
    @FXML
    private void saveFlashcard() {
        // create a new Flashcard object
        // set the front side and back side of the Flashcard object
        // add the Flashcard object to the CardSet object
        // close the window
        if (frontSideTextArea.getText().equals("") || backSideTextArea.getText().equals("")) {
            if (frontSideTextArea.getText().equals("")) {
                frontSideTextArea.setPromptText("Please enter a front side.");
            }
            if (backSideTextArea.getText().equals("")) {
                backSideTextArea.setPromptText("Please enter a back side.");
            }
            return;
        }
        Flashcard flashcard = new Flashcard(frontSideTextArea.getText(), backSideTextArea.getText());
        //chacking the CardSet object for the flashcard
        //loop through the list
        //if the flashcard is already in the list, prompt the user to try again
        for (Flashcard currentFlashcard : FlashcardMain.currentCardSet.getFlashcards()) {
            if (currentFlashcard.getFrontSide().equals(flashcard.getFrontSide()) && currentFlashcard.getBackSide().equals(flashcard.getBackSide())) {
                frontSideTextArea.setText("");
                backSideTextArea.setText("");
                frontSideTextArea.setPromptText("Flashcard already exists.");
                backSideTextArea.setPromptText("Flashcard already exists.");
                return;
            }
        }
        
        //add the flashcard to the list
        FlashcardMain.currentCardSet.addFlashcard(flashcard);
        // System.out.println(FlashcardMain.currentCardSet.getFlashcards());
        // close the window
        Parent parent = saveButton.getParent();
        parent.getScene().getWindow().hide();
    }

    /*
     * cancel method
     * This method closes the window without anything else happening.
     * 
     * @param none
     * @return void
     * 
     */
    @FXML
    private void cancel() {
        // close the window
        Parent parent = cancelButton.getParent();
        parent.getScene().getWindow().hide();
    }

    
}
