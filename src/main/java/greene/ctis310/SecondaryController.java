package greene.ctis310;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        FlashcardMain.setRoot("primary");
    }
}