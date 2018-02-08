package ca.bcit.comp2526.A2;
import javafx.scene.text.Text;

/**
 * ChessPiece.
 *  "\u2654 " + // white king
 *  "\u2655 " + // white queen
 *  "\u2656 " + // white rook
 *  "\u2657 " + // white bishop
 *  "\u2658 " + // white knight
 *  "\u2659 " + // white pawn
 *  "\n" +
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
     * Size of the chess piece.
     */
    public static final int SIZE = 50;
    
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
     * @return colour a String
     */
    public void setColour(String colour) {
        this.colour = colour;
    }
    
}
