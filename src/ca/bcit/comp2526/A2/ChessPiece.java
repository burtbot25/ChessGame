package ca.bcit.comp2526.A2;
import javafx.scene.text.Text;
import javafx.scene.effect.DropShadow;

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
abstract class ChessPiece extends Text {

    
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
     * Drop shadow object.
     */
    private DropShadow dropShadow;
    
    /**
     * Colour of piece.
     */
    private String colour;
    
    /**
     * Constructs an object of type ChessPiece.
     * @param colour of piece
     */
    ChessPiece(String colour) {
        this.colour = colour;
        makeDropshadow();
        this.setEffect(dropShadow);
    }
    
    /**
     * Initializes dropshadow effect.
     */
    public void makeDropshadow() {
        dropShadow = new DropShadow();
        dropShadow.setRadius(SHADOW_RADIUS);
        dropShadow.setOffsetX(SHADOW_OFFSET);
        dropShadow.setOffsetY(SHADOW_OFFSET);
    }

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
    
}
