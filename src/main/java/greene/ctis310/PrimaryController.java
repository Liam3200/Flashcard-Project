package greene.ctis310;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {

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
}
