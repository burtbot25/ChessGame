package ca.bcit.comp2526.A2;
import javafx.scene.text.Text;
import java.io.Serializable;
//import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * ChessPiece.
 *  "\u265A " + // black king
 *  "\u265B " + // black queen
 *  "\u265C " + // black rook
 *  "\u265D " + // black bishop
 *  "\u265E " + // black knight
 *  "\u265F " + // black pawn
 *
 * @author Wilburt Herrera
 * @version 2018
 */
abstract class ChessPiece extends Text implements Serializable {

    /**
     * Drop shadow radius.
     */
    public static final double SHADOW_RADIUS = 5;
    
    /**
     * Drop shadow offset.
     */
    public static final double SHADOW_OFFSET = 3;
    
    /**
     * Size of the chess piece.
     */
    public static final int SIZE = 50;
    
    /**
     * Serialization long.
     */
    private static final long serialVersionUID = 1L;
    
//    /**
//     * Drop shadow object.
//     */
//    private DropShadow dropShadow;
    
    /**
     * Colour of piece.
     */
    private String colour;
    
    /**
     * Color toggle.
     */
    private boolean toggle;
    
    /**
     * X Coordinate.
     */
    private int xCor;
    
    /**
     * Y Coordinate.
     */
    private int yCor;
    
    private String name;
    
    /**
     * Constructs an object of type ChessPiece.
     * @param colour of piece
     * @param xCor an int
     * @param yCor an int
     */
    ChessPiece(String colour, int xCor, int yCor) {
        this.colour = colour;
        this.xCor = xCor;
        this.yCor = yCor;
//        makeDropshadow();
//        this.setEffect(dropShadow);
        this.setOnMouseEntered(this::hover);
        this.setOnMouseExited(this::hover);
    }
    
    /**
     * Get name.
     * @return a name.
     */
    public String getName() {
        return name;
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
        if (colour.equals("white")) {
            this.setFill(Color.WHITE);
        } else {
            this.setFill(Color.BLACK);
        }
    }
    
//    /**
//     * Initializes dropshadow effect.
//     */
//    public void makeDropshadow() {
//        dropShadow = new DropShadow();
//        dropShadow.setRadius(SHADOW_RADIUS);
//        dropShadow.setOffsetX(SHADOW_OFFSET);
//        dropShadow.setOffsetY(SHADOW_OFFSET);
//    }

    /**
     * Returns the colour for this ChessPiece.
     * @return colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets the colour for this ChessPiece.
     * @param colour a String
     */
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    /**
     * Checks if the move is performing a valid move.
     * @param fromX an int
     * @param fromY an int
     * @param toX an int
     * @param toY an int
     * @param squareArray Squares
     * @return a boolean.
     */
    abstract boolean validMove(Square[][] squareArray,
            int fromX, int fromY, int toX, int toY);

    /**
     * Checks path to see if a piece is in the way.
     * @param squareArray a Square
     * @param dirX X direction
     * @param dirY Y direction
     * @param srcX X source
     * @param srcY Y source
     * @param destX X destination
     * @param destY Y destination
     * @return a boolean
     */
    public boolean checkPath(Square[][] squareArray, int dirX, int dirY,
            int srcX, int srcY, int destX, int destY) {

        while (destY != srcY + dirY || destX != srcX + dirX) {
            srcY = srcY + dirY;
            srcX = srcX + dirX;

            if (squareArray[srcX][srcY].getPiece() != null) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Returns the xCor for this ChessPiece.
     * @return xCor
     */
    public int getxCor() {
        return xCor;
    }

    /**
     * Returns the yCor for this ChessPiece.
     * @return yCor
     */
    public int getyCor() {
        return yCor;
    }

    /**
     * Sets the xCor for this ChessPiece.
     * @param xCor the xCor to set
     */
    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    /**
     * Sets the yCor for this ChessPiece.
     * @param yCor the yCor to set
     */
    public void setyCor(int yCor) {
        this.yCor = yCor;
    }
 
    /**
     * Sets the xCor for this ChessPiece.
     */
    public void getCor() {
        System.out.println("yCor:" + yCor + "," + " xCor: " 
                + xCor + " colour: " + colour);
    }
    
    /**
     * Text to string.
     * @see java.lang.Text#toString()
     * @return a string
     */
    @Override
    public String toString() {
        return "";
    }
    
}
