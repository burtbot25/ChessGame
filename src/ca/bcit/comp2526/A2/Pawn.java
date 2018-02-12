package ca.bcit.comp2526.A2;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Pawn.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Pawn extends ChessPiece {
    
    /**
     * Pawn Image.
     */
    private String pawnImage = "\u265F";
    
    /**
     * Name.
     */
    private String name;
    
    /**
     * Constructs an object of type Pawn.
     * @param colour of Pawn
     */
    public Pawn(String colour) {
        super(colour);
        setText(pawnImage);
        setName(this);

        // Assigns black or white icon
        if (colour.equals("white")) {
            setFill(Color.WHITE);
        }
        
        setFont(new Font(ChessPiece.SIZE));
        
    }

    
    /**
     * Sets the name of this Knight Object.
     * @param pawn a pawn obj.
     */
    public void setName(Pawn pawn) {
        if (super.getColour().equals("white")) {
            name = "White Pawn";
        } else {
            name = "Black Pawn";
        }
    }
    
    /**
     * Checks if the move is performing a valid move.
     * @return a boolean.
     */
    public boolean validMove() {
        return false;
    }

    /**
     * Text to string.
     * @see java.lang.Text#toString()
     * @return a string
     */
    @Override
    public String toString() {
        return (name + " clicked");
    }

}
