package greene.ctis310;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PrimaryController {
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private Label flashcardDisplay;

    private Flashcard currentFlashcard;

    @FXML
    private void createCardSet() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlashcardMain.class.getResource("newset.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("New Card Set");
        stage.show();
    }

    @FXML
    private void createNewFlashcard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlashcardMain.class.getResource("newflashcard.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("New Flashcard");
        stage.show();
    }

    @FXML
    private void loadCardSets() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlashcardMain.class.getResource("loadcardset.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Load Card Set");
        stage.show();
    }

    @FXML
    private void nextFlashcard() {
        // get the next flashcard from the CardSet object
        // display the next flashcard
        // if the flashcard is the last flashcard, disable the next button
        currentFlashcard = FlashcardMain.currentCardSet.nextFlashcard();
        if (currentFlashcard != null) {
            flashcardDisplay.setText(currentFlashcard.getFrontSide());
        } else {
            nextButton.setDisable(true);
        }
        
    }
}
