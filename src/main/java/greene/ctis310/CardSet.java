package greene.ctis310;

import java.io.BufferedWriter;
// import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// import org.apache.commons.io.FileUtils;


public class CardSet {
    // Instance variables
    private String title;
    private String author;
    private String description;
    private LinkedList<Flashcard> flashcards;
    private Flashcard currentFlashcard;

    private Path saveFileLocation;

    private ListIterator<Flashcard> flashcardIterator;

    /*
     * @Constructor CardSet
     * 
     * The CardSet constructor should initialize the instance variables title,
     * author, and description
     * with the values passed to the constructor. The constructor should also
     * initialize the instance
     * variable currentFlashcard with a new Flashcard object. The constructor should
     * initialize the
     * instance variable flashcards with a new LinkedList object. The constructor
     * should add the
     * currentFlashcard object to the flashcards LinkedList.
     * The constructor should initialize the instance variable saveFileLocation with
     * the path to the
     * CardSets.txt file. The constructor should catch the URISyntaxException and
     * NullPointerException
     * exceptions and print the message "File is not found." to the console.
     * 
     * @param title
     * @param author
     * @param description
     * 
     * @return none
     * 
     * 
     */
    // Constructor
    public CardSet(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.currentFlashcard = new Flashcard(title, description);
        this.flashcards = new LinkedList<Flashcard>();
        this.flashcards.add(currentFlashcard);
        try {
            this.saveFileLocation = Paths.get(CardSet.class.getResource("/CardSets.txt").toURI());
        } catch (URISyntaxException e) {
            System.out.println("File is not found.");
        } catch (NullPointerException e) {
            System.out.println("File is not found.");
        }
    }

    // Methods

    /*
     * @method createCardSet
     * The createCardSet method should write the CardSet object to a file if it is
     * not
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
            FileWriter location = new FileWriter(saveFileLocation.toString());
            BufferedWriter writer = new BufferedWriter(location);
            writer.write("\n" + this.title + "," + this.author + "," + this.description.replaceAll(",", ""));
            for (Flashcard flashcard : flashcards) {
                writer.write(","+flashcard.getFrontSide() + "," + flashcard.getBackSide().replaceAll(",",""));
            }
            writer.close();
            // File tempFile = new File("/CardSets.txt");
            // File saveFile = new File("../../src/main/resources/CardSets.txt");
            // FileUtils.copyFile(tempFile, saveFile);
            return 0;
        }
        return -1;
    }

    /*
     * @method saveCardSet
     * 
     * The saveCardSet method should check the file for the CardSet object. If the
     * CardSet object is present, it updates the CardSet object in the file and
     * returns 0. If the
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
    // public int saveCardSet() throws IOException {
    //     if (checkForCardSet()) {
    //         // create a Scanner object
    //         Scanner scanner = new Scanner(saveFileLocation.toFile());
    //         // create a StringBuilder object
    //         StringBuilder builder = new StringBuilder();
    //         // while the Scanner object has another line
    //         while (scanner.hasNextLine()) {
    //             String line = scanner.nextLine();
    //             // if the line contains the title of the CardSet object
    //             if (line.contains(this.title) && line.contains(this.author) && line.contains(this.description.replaceAll(",",""))) {
    //                 // for each Flashcard object in the flashcards LinkedList that is not already in
    //                 // the file
    //                 for (Flashcard flashcard : flashcards) {
    //                     if (!line.contains(flashcard.getFrontSide()) && !line.contains(flashcard.getBackSide())) {
    //                         // append the front side and back side of the Flashcard object to the
    //                         // StringBuilder object
    //                         builder.append(","+flashcard.getFrontSide() + "," + flashcard.getBackSide());
    //                     }
    //                 }
    //             }
    //         }
    //         scanner.close();
    //         // create a BufferedWriter object
    //         FileWriter location = new FileWriter(saveFileLocation.toString());
    //         BufferedWriter writer = new BufferedWriter(location);
    //         // write the StringBuilder object to the file
    //         writer.write(builder.toString());
    //         writer.close();
    //         // File tempFile = new File("/CardSets.txt");
    //         // File saveFile = new File("../../src/main/resources/CardSets.txt");
    //         // FileUtils.copyFile(tempFile, saveFile);
    //         // return 0
    //         return 0;
    //     }
    //     // return -1
    //     return -1;
    // }

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
        Scanner scanner = new Scanner(saveFileLocation.toFile());
        // while the Scanner object has another line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // if the line contains the title of the CardSet object
            if (line.contains(this.title) && line.contains(this.author)) {
                scanner.close();
                // return true
                return true;
            }
        }
        scanner.close();
        // return false
        return false;
    }

    /*
     * @method loadCardSet
     * 
     * The loadCardSet method should load the CardSet object from the file. Creates
     * a Scanner object to read the file. If the CardSet object is present in the
     * file, the method should create a CardSet object and return it. If the CardSet
     * object is not present in the file, the method should return null.
     * 
     * @throws IOException
     * 
     * @return CardSet object if the CardSet object was successfully loaded from the
     * file, null if the
     * CardSet object was not successfully loaded from the file
     * 
     * @param none
     */
    // loads the CardSet object from the file
    public CardSet loadCardSet(String loadTitle, String loadAuthor) throws IOException {
        // create a Scanner object
        Scanner scanner = new Scanner(saveFileLocation.toFile());
        scanner.useDelimiter(",");
        // while the Scanner object has another line
        while (scanner.hasNext()) {
            // if the line contains the title of the CardSet object
            if (scanner.next().contains(loadTitle) && scanner.next().contains(loadAuthor)) {
                String loadDescription = scanner.next();
                // create a CardSet object
                CardSet cardSet = new CardSet(loadTitle, loadAuthor, loadDescription);
                // while the Scanner object has another line
                while (scanner.hasNext()) {
                    // create a String array
                    String frontSide = scanner.next();
                    String backSide = scanner.next();
                    // create a Flashcard object
                    Flashcard card = new Flashcard(frontSide, backSide);
                    // add the Flashcard object to the CardSet object
                    cardSet.addFlashcard(card);
                }
                scanner.close();
                // return the CardSet object
                return cardSet;
            }
        }
        scanner.close();
        // return null
        return null;
    }

    /*
     * @method nextFlashcard
     * 
     * The nextFlashcard method should return the next Flashcard object in the
     * flashcards LinkedList.
     * 
     * @return Flashcard object
     * 
     */
    // returns the next Flashcard object in the flashcards LinkedList
    public Flashcard nextFlashcard() {
        // if the flashcards LinkedList is not empty
        if (!flashcards.isEmpty() && flashcardIterator.hasNext()) {
            // return the first Flashcard object in the flashcards LinkedList
            flashcardIterator.next();
            currentFlashcard = flashcardIterator.next();
            return currentFlashcard;
        }
        // return null
        return null;
    }

    /*
     * @method previousFlashcard
     * 
     * The previousFlashcard method should return the previous Flashcard object in
     * the flashcards LinkedList.
     * 
     * @return Flashcard object
     * 
     */
    // returns the previous Flashcard object in the flashcards LinkedList
    public Flashcard previousFlashcard() {
        // if the flashcards LinkedList is not empty
        if (!flashcards.isEmpty() && flashcardIterator.hasPrevious()) {
            // return the last Flashcard object in the flashcards LinkedList
            flashcardIterator.previous();
            currentFlashcard = flashcardIterator.previous();
            return currentFlashcard;
        }
        // return null
        return null;
    }

    // addFlashcard method
    // adds a flashcard to the flashcards LinkedList
    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
        flashcardIterator = flashcards.listIterator(flashcards.indexOf(currentFlashcard));
    }

    // removeFlashcard method
    // removes a flashcard from the flashcards LinkedList
    public void removeFlashcard(Flashcard flashcard) {
        if (flashcards.size() > 1) {
            flashcards.remove(flashcard);
            flashcardIterator = flashcards.listIterator(flashcards.indexOf(currentFlashcard));
        }
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

    public Flashcard getCurrentFlashcard() {
        return currentFlashcard;
    }

    public void setCurrentFlashcard(Flashcard currentFlashcard) {
        this.currentFlashcard = currentFlashcard;
    }

    // toString method
    @Override
    public String toString() {
        return "CardSet [title=" + title + ", author=" + author + ", description=" + description + ", flashcards="
                + flashcards + "]";
    }
}
