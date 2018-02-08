package ca.bcit.comp2526.A2;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 * Squares class.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Square extends Rectangle {

    /**
     * Color toggle.
     */
    private boolean toggle;
    
    /**
     * Colour of the square.
     */
    private String colour;
    
    /**
     * X coordinate.
     */
    private int xCor;
    
    /**
     * Y coordinate.
     */
    private int yCor;
    
    /**
     * Constructs an object of type Square.
     * @param colour of square
     * @param x location
     * @param y location
     */
    public Square(String colour, int x, int y) {
        
        this.colour = colour;
        this.xCor = x;
        this.yCor = y;
        
        setWidth(ChessGame.SQUARE_SIZE);
        setHeight(ChessGame.SQUARE_SIZE);
        
        relocate(x * ChessGame.SQUARE_SIZE, y * ChessGame.SQUARE_SIZE);
        
        if (colour.equals("grey")) {
            setFill(Color.GREY);
        } else {
            setFill(Color.LIGHTGREY);
        }
        
    }
    
    /**
     * Highlights the borders blue when selected.
     * @param me an event.
     */
    public void selected(MouseEvent me) {
        if (!toggle) {
            setStrokeWidth(2);
            setStroke(Color.BLUE);
            toggle = true;
        } else {
            setStroke(null);
            toggle = false;
        }
    }
    
    /**
     * Returns the x for this Square.
     * @return x
     */
    public int getXCor() {
        return xCor;
    }

    /**
     * Returns the y for this Square.
     * @return y
     */
    public int getYCor() {
        return yCor;
    }

    public boolean occupied() {
        return false;
    }

    /**
     * String representation of this Square.
     * @see java.lang.Rectangle#toString()
     * @return
     */
    @Override
    public String toString() {
        return "Square [toggle=" + toggle + ", colour=" + colour 
                + ", xCor=" + xCor + ", yCor=" + yCor + "]";
    }
}
