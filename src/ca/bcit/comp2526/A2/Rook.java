package ca.bcit.comp2526.A2;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Rook.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Rook extends ChessPiece {
    
    /**
     * Rook Image.
     */
    private String rookImage = "\u265C";
    
    /**
     * Name.
     */
    private String name;
    

    
    /**
     * Constructs an object of type Rook.
     * @param colour of Rook
     */
    public Rook(String colour) {
        super(colour);
        setText(rookImage);
        setName(this);

        // Assigns black or white icon
        if (colour.equals("white")) {
            setFill(Color.WHITE);
        }
        
        
        setFont(new Font(ChessPiece.SIZE));
        
    }


    
    /**
     * Sets the name of this Rook Object.
     * @param rook a rook obj.
     */
    public void setName(Rook rook) {
        if (super.getColour().equals("white")) {
            name = "White Rook";
        } else {
            name = "Black Rook";
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
