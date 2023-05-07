package greene.ctis310;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoadSetController {
    @FXML
    private TextField loadTitle;
    @FXML
    private TextField loadAuthor;
    @FXML
    private Button cancelButton;

    @FXML
    private void cancel() {
        // close the window
        Parent parent = cancelButton.getParent();
        parent.getScene().getWindow().hide();
    }

    @FXML
    private void loadSet() {
        // get the selected card set from the list
        // set the current card set to the selected card set
        // close the window
        String title = loadTitle.getText();
        String author = loadAuthor.getText();
        if (title != null || author != null) {
            FlashcardMain.currentCardSet = new CardSet(title, author, "");
        } else {
            if (title == null) {
                loadTitle.setPromptText("Erorr: nothing entered");
            }
            if (author == null) {
                loadAuthor.setPromptText("Erorr: nothing entered");
            }
        }
    }
}
