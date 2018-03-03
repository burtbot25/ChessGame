package ca.bcit.comp2526.A2;
import javafx.scene.text.Font;

/**
 * Pawn.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Pawn extends ChessPiece {
    
    /**
     * Pawn Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Pawn Image.
     */
    private String pawnImage = "\u265F";
    
    /**
     * Name.
     */
    private String name = "Pawn";
    
    /**
     * Has moved.
     */
    private boolean moved = true;
    
    /**
     * Constructs an object of type Pawn.
     * @param colour of Pawn
     * @param xCor an int
     * @param yCor an int
     */
    public Pawn(String colour, int xCor, int yCor) {
        super(colour, xCor, yCor);
        setText(pawnImage);

        // Assigns black or white icon
        setColour();
        
        setFont(new Font(ChessPiece.SIZE));
        
    }
    
    /**
     * Gets the name of this Knight Object.
     * @return a String
     */
    public String getName() {
        return name;
    }

    /**
     * Text to string.
     * @see java.lang.Text#toString()
     * @return a string
     */
    @Override
    public String toString() {
        return (getColour() + " " + name);
    }


    /**
     * Checks if valid move.
     * @see ca.bcit.comp2526.A2.ChessPiece#validMove(int, int, int, int)
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @return boolean
     */
    @Override
    boolean validMove(Square[][] squareArray, int fromX, int fromY,
            int toX, int toY) {
        if (toX == fromX && colourValid(fromY, toY)) {
            if (Math.abs(fromY - toY) > 2) {
                return false;
            } else if (!moved && Math.abs(fromY - toY) == 2) {
                return false;
            }    
            moved = false;
            return true;
        }
        return false;
    }
    
    /**
     * Determines if valid depending on the colour.
     * @param fromY an int
     * @param toY an int
     * @return boolean
     */
    boolean colourValid(int fromY, int toY) {
        if (getColour().equals("black")) {
            if (fromY < toY) {
                return true;
            }
        } else if (getColour().equals("white")) {
            if (fromY > toY) {
                return true;
            }
        }
        return false;
    }
    
}
