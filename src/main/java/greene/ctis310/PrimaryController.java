package greene.ctis310;

import java.io.IOException;
import java.util.NoSuchElementException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PrimaryController {
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private Label flashcardDisplay;
    @FXML
    private Label setTitle;

    TranslateTransition translateTransition;

    // loads the Create New Card Set window
    @FXML
    private void createCardSet() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FlashcardMain.class.getResource("/newset.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("New Card Set");
        stage.show();
    }

    // loads the Create New Flashcard window
    @FXML
    private void createNewFlashcard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FlashcardMain.class.getResource("/newflashcard.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("New Flashcard");
        stage.show();
    }

    // loads the Load Card Set window
    @FXML
    private void loadCardSets() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FlashcardMain.class.getResource("/loadcardset.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Load Card Set");
        stage.show();
    }

    // @FXML
    // private void saveCardSet() {
    // // save the current card set to a file
    // // display a message that the card set was saved
    // try {
    // if (FlashcardMain.currentCardSet.saveCardSet() == -1) {
    // flashcardDisplay.setText("Error saving card set!");
    // }
    // } catch (IOException e) {
    // System.out.println("Error saving card set!");
    // }
    // flashcardDisplay.setText("Card set saved!");
    // }

    @FXML
    private void refreshDisplay() {
        // refresh the display
        // this is used when a new card set is loaded
        // or a new flashcard is created
        setTitle.setText(FlashcardMain.currentCardSet.getTitle());
        FlashcardMain.currentFlashcard = FlashcardMain.currentCardSet.getCurrentFlashcard();
        flashcardDisplay.setText(FlashcardMain.currentFlashcard.getFrontSide());
    }

    @FXML
    private void nextFlashcard() {
        // get the next flashcard from the CardSet object
        // display the next flashcard
        // if the flashcard is the last flashcard, disable the next button
        try {
            FlashcardMain.currentFlashcard = FlashcardMain.currentCardSet.nextFlashcard();
            if (FlashcardMain.currentFlashcard != null) {
                translateTransition = new TranslateTransition();
                translateTransition.setDuration(Duration.seconds(1));
                translateTransition.setNode(flashcardDisplay);
                translateTransition.setToX(flashcardDisplay.getTranslateX() + 80);
                translateTransition.setAutoReverse(true);
                translateTransition.setCycleCount(2);
                translateTransition.setRate(4);
                translateTransition.play();
                translateTransition.setOnFinished(event -> {
                    flashcardDisplay.setTranslateX(0);
                    flashcardDisplay.setText(FlashcardMain.currentFlashcard.getFrontSide());
                });

            }
        } catch (NullPointerException | NoSuchElementException e) {
            System.out.println("No more flashcards!");
        }
    }

    @FXML
    private void previousFlashcard() {
        // get the previous flashcard from the CardSet object
        // display the previous flashcard
        // if the flashcard is the first flashcard, disable the previous button
        try {
            FlashcardMain.currentFlashcard = FlashcardMain.currentCardSet.previousFlashcard();
            if (FlashcardMain.currentFlashcard != null) {
                translateTransition = new TranslateTransition();
                translateTransition.setDuration(Duration.seconds(1));
                translateTransition.setNode(flashcardDisplay);
                translateTransition.setToX(flashcardDisplay.getTranslateX() - 80);
                translateTransition.setAutoReverse(true);
                translateTransition.setCycleCount(2);
                translateTransition.setRate(4);
                translateTransition.play();
                translateTransition.setOnFinished(event -> {
                    flashcardDisplay.setTranslateX(0);
                    flashcardDisplay.setText(FlashcardMain.currentFlashcard.getFrontSide());
                });
            }
        } catch (NullPointerException | NoSuchElementException e) {
            System.out.println("No more flashcards!");
        }
    }

    @FXML
    private void flipFlashcard() {
        // flip the flashcard over to the back side
        // if the flashcard is on the back side, flip it back to the front side
        FlashcardMain.currentFlashcard = FlashcardMain.currentCardSet.getCurrentFlashcard();
        if (FlashcardMain.currentFlashcard != null) {
            translateTransition = new TranslateTransition();
            translateTransition.setDuration(Duration.seconds(1));
            translateTransition.setNode(flashcardDisplay);
            translateTransition.setToX(flashcardDisplay.getTranslateX() + 20);
            translateTransition.setAutoReverse(true);
            translateTransition.setCycleCount(2);
            translateTransition.setRate(10);
            translateTransition.playFromStart();
            translateTransition.setOnFinished(event -> {
                flashcardDisplay.setTranslateX(0);
                FlashcardMain.currentFlashcard.flip();
                if (FlashcardMain.currentFlashcard.getCurrentSide() == 0) {
                    flashcardDisplay.setText(FlashcardMain.currentFlashcard.getFrontSide());
                } else {
                    flashcardDisplay.setText(FlashcardMain.currentFlashcard.getBackSide());
                }
            });
        }
    }

    @FXML
    public void updateDisplays() {
        // change the title to the current card set
        setTitle.setText(FlashcardMain.currentCardSet.getTitle());
        // display the first flashcard
        flashcardDisplay.setText(FlashcardMain.currentCardSet.getCurrentFlashcard().getFrontSide());
    }
}
