package greene.ctis310;

/*
 * Class Flashcard
 * 
 * This class represents a single flashcard. It has two sides, a front side and a back side.
 * The front side is the side that is initially displayed to the user. The back side is the side that is displayed when the user clicks the "Flip" button.
 * This class has a simple compareTo method that compares the front side of this flashcard to the front side of another flashcard.
 * This class also has a flip method that changes the current side of the flashcard to the other side.
 * 
 */
public class Flashcard implements Comparable<Flashcard> {
    // Instance variables
    private String frontSide; // The front side of the flashcard, represented as 0
    private String backSide; // The back side of the flashcard, represented as 1
    private short currentSide = 0;

    public final int FRONT_SIDE = 0;
    public final int BACK_SIDE = 1;

    // Constructor
    public Flashcard(String frontSide, String backSide) {
        this.frontSide = frontSide;
        this.backSide = backSide;
    }

    // Methods

    //flip method
    //changes the current side of the flashcard to the other side
    public void flip() {
        if (currentSide == FRONT_SIDE) {
            currentSide = BACK_SIDE;
        } else {
            currentSide = FRONT_SIDE;
        }
    }

    //implement compareTo method
    //returns 0 if the front side Strings are the same
    //returns a positive number if the front side of this flashcard is greater than the front side of the other flashcard
    //returns a negative number if the front side of this flashcard is less than the front side of the other flashcard
    //if the front sides are the same, then compare the back sides
    @Override
    public int compareTo(Flashcard other) {
        if (this.frontSide.equals(other.frontSide) && this.backSide.equals(other.backSide)) {
            return 0;
        } else {
            return this.frontSide.compareTo(other.frontSide);
        }
    }

    public String getFrontSide() {
        return frontSide;
    }

    public void setFrontSide(String frontSide) {
        this.frontSide = frontSide;
    }

    public String getBackSide() {
        return backSide;
    }

    public void setBackSide(String backSide) {
        this.backSide = backSide;
    }

    public short getCurrentSide() {
        return currentSide;
    }

    public void setCurrentSide(short currentSide) {
        this.currentSide = currentSide;
    }

    //to String method
    //returns the front side, backside and current side of the flashcard
    @Override
    public String toString() {
        return "Flashcard [frontSide=" + frontSide + ", backSide=" + backSide + ", currentSide=" + currentSide + "]";
    }
    
    
}
