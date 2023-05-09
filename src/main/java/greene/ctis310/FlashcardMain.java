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
        currentCardSet = new CardSet("CTIS 310", "Liam", "CTIS 310 Vocab");
        // add some Flashcards to the CardSet
        currentCardSet.addFlashcard(new Flashcard("Encapsulation", "Integrating data (variables) and code (methods) into a single unit."));
        currentCardSet.addFlashcard(new Flashcard("Inheritance", "The process by which one class takes on the attributes and methods of another."));
        currentCardSet.addFlashcard(new Flashcard("Polymorphism", "When a message is sent to an object, the object's class determines how that message will be processed."));
        currentCardSet.addFlashcard(new Flashcard("Abstraction", "The process of picking out (abstracting) common features of objects and procedures."));
        currentCardSet.addFlashcard(new Flashcard("Class", "A blueprint or prototype from which objects are created."));

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