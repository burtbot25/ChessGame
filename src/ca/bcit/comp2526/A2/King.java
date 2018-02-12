package ca.bcit.comp2526.A2;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * King.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class King extends ChessPiece {
    
    /**
     * King Image.
     */
    private String kingImage = "\u265A";
    
    /**
     * Name.
     */
    private String name;
    
    /**
     * Constructs an object of type King.
     * @param colour of King
     */
    public King(String colour) {
        super(colour);
        setText(kingImage);
        setName(this);

        // Assigns black or white icon
        if (colour.equals("white")) {
            setFill(Color.WHITE);
        }
        
        setFont(new Font(ChessPiece.SIZE));
        
    }
    
    /**
     * Sets the name of this King Object.
     * @param king a King obj.
     */
    public void setName(King king) {
        if (super.getColour().equals("white")) {
            name = "White King";
        } else {
            name = "Black King";
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
     * @return boop.
     */
    @Override
    public String toString() {
        return (name + " clicked");
    }

}
