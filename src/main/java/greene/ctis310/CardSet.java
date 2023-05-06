package greene.ctis310;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Scanner;

public class CardSet {
    // Instance variables
    private String title;
    private String author;
    private String description;
    private LinkedList<Flashcard> flashcards;

    private File saveFile;

    // Constructor
    public CardSet(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.flashcards = new LinkedList<Flashcard>();
        try {
            this.saveFile = new File(CardSet.class.getResource("/greene/ctis310/CardSets.txt").toURI());
        } catch (URISyntaxException e) {
            System.out.println("File is not found.");
        } catch (NullPointerException e) {
            System.out.println("File is not found.");
        }
    }

    // Methods

    /*
     * @method createCardSet
     * The createCardSet method should write the CardSet object to a file if it is not
     * already present in
     * the file. Creates a Scanner object to read the file. If the CardSet object is
     * already present in
     * the file, the method should return -1. If the CardSet object is not already
     * present in the file,
     * the method should create a BufferedWriter object to write the CardSet object
     * to the file. The
     * method should return 0 if the CardSet object was successfully saved to the
     * file.
     * 
     * @throws IOException
     * 
     * @return 0 if the CardSet object was successfully saved to the file, -1 if the
     * CardSet object was
     * already present in the file
     * 
     * @param none
     */
    // saves the CardSet object to a file
    public int createCardSet() throws IOException {
        if (!checkForCardSet()) {
            // create a BufferedWriter object
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            writer.write(this.title + "," + this.author + "," + this.description + ",");
            for (Flashcard flashcard : flashcards) {
                writer.write(flashcard.getFrontSide() + "," + flashcard.getBackSide() + "\n");
            }
            writer.close();
            return 0;
        }
        return -1;
    }

    /*
     * @method saveCardSet
     * 
     * The saveCardSet method should check the file for the CardSet object. If the
     * CardSet object is present, it updates the CardSet object in the file and returns 0. If the
     * CardSet object is not present, it returns -1.
     * 
     * @throws IOException
     * 
     * @return 0 if the CardSet object was successfully saved to the file, -1 if the
     * CardSet object was not successfully saved to the file
     * 
     * @param none
     */
    // updates the CardSet object in the file
    public int saveCardSet() throws IOException {
        if (checkForCardSet()) {
            // create a Scanner object
            Scanner scanner = new Scanner(saveFile);
            // create a StringBuilder object
            StringBuilder builder = new StringBuilder();
            // while the Scanner object has another line
            while (scanner.hasNextLine()) {
                // if the line contains the title of the CardSet object
                if (scanner.nextLine().contains(this.title) && scanner.nextLine().contains(this.author) && scanner.nextLine().contains(this.description)) {
                    // for each Flashcard object in the flashcards LinkedList that is not already in the file
                    for (Flashcard flashcard : flashcards) {
                        if (!scanner.nextLine().contains(flashcard.getFrontSide()) && !scanner.nextLine().contains(flashcard.getBackSide())) {
                            // append the front side and back side of the Flashcard object to the
                            // StringBuilder object
                            builder.append(flashcard.getFrontSide() + "," + flashcard.getBackSide() + "\n");
                        }
                    }
                } else {
                    // append the line to the StringBuilder object
                    builder.append(scanner.nextLine() + "\n");
                }
            }
            scanner.close();
            // create a BufferedWriter object
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            // write the StringBuilder object to the file
            writer.write(builder.toString());
            writer.close();
            // return 0
            return 0;
        }
        // return -1
        return -1;
    }

    /*
     * @method checkForCardSet
     * 
     * The checkForCardSet method should check if the CardSet object is already
     * present in the file.
     * 
     * @throws IOException
     * 
     * @return true if the CardSet object is already present in the file, false if
     * the CardSet object
     * is not already present in the file
     * 
     * @param none
     */
    private boolean checkForCardSet() throws IOException {
        // create a Scanner object
        Scanner scanner = new Scanner(saveFile);
        // while the Scanner object has another line
        while (scanner.hasNextLine()) {
            // if the line contains the title of the CardSet object
            if (scanner.nextLine().contains(this.title) && scanner.nextLine().contains(this.author)) {
                scanner.close();
                // return true
                return true;
            }
        }
        scanner.close();
        // return false
        return false;
    }

    // addFlashcard method
    // adds a flashcard to the flashcards LinkedList
    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    // removeFlashcard method
    // removes a flashcard from the flashcards LinkedList
    public void removeFlashcard(Flashcard flashcard) {
        flashcards.remove(flashcard);
    }

    // getters and setters
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

    // toString method
    @Override
    public String toString() {
        return "CardSet [title=" + title + ", author=" + author + ", description=" + description + ", flashcards="
                + flashcards + "]";
    }
}
