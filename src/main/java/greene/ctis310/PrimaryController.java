package greene.ctis310;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        FlashcardMain.setRoot("secondary");
    }
}
