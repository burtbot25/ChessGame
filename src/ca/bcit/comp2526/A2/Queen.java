package ca.bcit.comp2526.A2;
import javafx.scene.text.Text;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Queen.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Queen extends ChessPiece {
    
    /**
     * Queen Image.
     */
    private String queenImage = "\u265B";
    
    /**
     * Name.
     */
    private String name;
    
    /**
     * Drop shadow object.
     */
    private DropShadow dropShadow;
    
    /**
     * Constructs an object of type Queen.
     * @param colour of Queen
     */
    public Queen(String colour) {
        super(colour);
        setText(queenImage);
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
     * Sets the name of this Queen Object.
     * @param queen a Queen obj.
     */
    public void setName(Queen queen) {
        if (super.getColour().equals("white")) {
            name = "White Queen";
        } else {
            name = "Black Queen";
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
