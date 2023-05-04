package greene.ctis310;

import java.util.LinkedList;

public class CardSet {
    // Instance variables
    private String title;
    private String author;
    private String description;
    private LinkedList<Flashcard> flashcards;

    // Constructor
    public CardSet(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.flashcards = new LinkedList<Flashcard>();
    }

    // Methods

    //addFlashcard method
    //adds a flashcard to the flashcards LinkedList
    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    //removeFlashcard method
    //removes a flashcard from the flashcards LinkedList
    public void removeFlashcard(Flashcard flashcard) {
        flashcards.remove(flashcard);
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(LinkedList<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    //getters and setters
    
}
