package greene.ctis310;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class FlashcardMain extends Application {

    private static Scene scene;

    public static CardSet currentCardSet;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 596, 440);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Flashcards!");

        // create a new CardSet object
        currentCardSet = new CardSet("Example Set", "Test", "This is an example set.");

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(FlashcardMain.class.getResource("/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}