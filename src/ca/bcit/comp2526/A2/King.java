package ca.bcit.comp2526.A2;
import javafx.scene.effect.DropShadow;
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
     * Drop shadow object.
     */
    private DropShadow dropShadow;
    
    /**
     * Constructs an object of type King.
     * @param colour of King
     */
    public King(String colour) {
        super(colour);
        setText(kingImage);
        setName(this);
        makeDropshadow();

        // Assigns black or white icon
        if (colour.equals("white")) {
            setFill(Color.WHITE);
        }
        this.setEffect(dropShadow);
        
        setFont(new Font(ChessPiece.SIZE));
        
    }

    /**
     * Initializes dropshadow effect.
     */
    public void makeDropshadow() {
        dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
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
