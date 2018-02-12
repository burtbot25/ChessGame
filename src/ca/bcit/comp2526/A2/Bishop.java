package ca.bcit.comp2526.A2;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Bishop.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Bishop extends ChessPiece {
    
    /**
     * Bishop Image.
     */
    private String bishopImage = "\u265D";
    
    /**
     * Name.
     */
    private String name;
    
    /**
     * Constructs an object of type Bishop.
     * @param colour of Bishop
     */
    public Bishop(String colour) {
        super(colour);
        setText(bishopImage);
        setName(this);

        // Assigns black or white icon
        if (colour.equals("white")) {
            setFill(Color.WHITE);
        }
        
        setFont(new Font(ChessPiece.SIZE));
        
    }
    
    /**
     * Sets the name of this Bishop Object.
     * @param bishop a Bishop obj.
     */
    public void setName(Bishop bishop) {
        if (super.getColour().equals("white")) {
            name = "White Bishop";
        } else {
            name = "Black Bishop";
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
