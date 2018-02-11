package ca.bcit.comp2526.A2;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * knight.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Knight extends ChessPiece {
    
    /**
     * Knight Image.
     */
    private String knightImage = "\u265E";
    
    /**
     * Name.
     */
    private String name;
    
    /**
     * Drop shadow object.
     */
    private DropShadow dropShadow;
    
    /**
     * Constructs an object of type Knight.
     * @param colour of Knight
     */
    public Knight(String colour) {
        super(colour);
        setText(knightImage);
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
     * Sets the name of this Knight Object.
     * @param knight a Knight obj.
     */
    public void setName(Knight knight) {
        if (super.getColour().equals("white")) {
            name = "White Knight";
        } else {
            name = "Black Knight";
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
