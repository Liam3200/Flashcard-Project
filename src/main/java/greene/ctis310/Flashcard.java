package greene.ctis310;

public class Flashcard implements Comparable<Flashcard> {
    // Instance variables
    private String frontSide; // The front side of the flashcard, represented as 0
    private String backSide; // The back side of the flashcard, represented as 1
    private short currentSide = 0;

    // Constructor
    public Flashcard(String frontSide, String backSide) {
        this.frontSide = frontSide;
        this.backSide = backSide;
    }

    // Methods

    //flip method
    //changes the current side of the flashcard to the other side
    public void flip() {
        if (currentSide == 0) {
            currentSide = 1;
        } else {
            currentSide = 0;
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
