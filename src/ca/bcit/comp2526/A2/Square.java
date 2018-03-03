package ca.bcit.comp2526.A2;
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
     * Chess piece on Square.
     */
    private ChessPiece piece;
    
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
        
        setColour();
        
        this.setOnMouseEntered(this::hover);
        this.setOnMouseExited(this::hover);
        
    }
    
    /**
     * Highlights the borders blue when selected.
     * @param me an event.
     */
    public void hover(MouseEvent me) {
        if (!toggle) {
            setFill(Color.CYAN);
            toggle = true;
        } else {
            setColour();
            toggle = false;
        }
    }
    
    /**
     * Sets Color.
     */
    public void setColour() {
        if (colour.equals("grey")) {
            this.setFill(Color.GREY);
        } else {
            this.setFill(Color.LIGHTGREY);
        }
    }
    
    /**
     * Returns the x for this Square.
     * @return x
     */
    public int getxCor() {
        return xCor;
    }

    /**
     * Returns the y for this Square.
     * @return y
     */
    public int getyCor() {
        return yCor;
    }

    /**
     * String representation of this Square.
     * @see java.lang.Rectangle#toString()
     * @return
     */
    @Override
    public String toString() {
        return colour + " Square";
    }
    
    /**
     * Gets square source.
     * @return an Object.
     */
    public Object getSource() {
        return new Square(null, 0, 0);
    }

    /**
     * Returns the piece for this Square.
     * @return piece
     */
    public ChessPiece getPiece() {
        return piece;
    }

    /**
     * Sets the piece for this Square.
     * @param piece the piece to set
     */
    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }
}
