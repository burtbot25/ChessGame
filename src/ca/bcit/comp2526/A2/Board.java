package ca.bcit.comp2526.A2;
import java.io.Serializable;

import javafx.geometry.HPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Board class.
 * Note to self: A8 [0][7] is the top left of the board.
 *               A1 [0][0] is the bottom left.
 *               H8 [7][7] is the top right
 *               H1 [7][0] is the bottom right.
 * @author Wilburt Herrera
 * @version 2018
 */
public class Board extends GridPane implements Move, Serializable {
    
    /**
     * Board width.
     */
    public static final int WIDTH = 8;
    
    /**
     * Board height.
     */
    public static final int HEIGHT = 8;

    /**
     * Chess Row 1. White non-pawn row.
     */
    public static final int CHESS_ROW1 = 7;
    
    /**
     * Chess Row 2. White pawn row.
     */
    public static final int CHESS_ROW2 = 6;
    
    /**
     * Chess Row 7. Black pawn row.
     */
    public static final int CHESS_ROW7 = 1;
    
    /**
     * Chess Row 8. Black non-pawn row.
     */
    public static final int CHESS_ROW8 = 0;
    
    /**
     * Rook1 pos.
     */
    public static final int ROOK1 = 0;
    
    /**
     * Rook2 pos.
     */
    public static final int ROOK2 = 7;
    
    /**
     * Knight1 pos.
     */
    public static final int KNIGHT1 = 1;
    
    /**
     * Knight2 pos.
     */
    public static final int KNIGHT2 = 6;
    
    /**
     * BISHOP1 pos.
     */
    public static final int BISHOP1 = 2;
    
    /**
     * BISHOP2 pos.
     */
    public static final int BISHOP2 = 5;
    
    /**
     * King pos.
     */
    public static final int KING = 4;
    
    /**
     * Queen pos.
     */
    public static final int QUEEN = 3;
    
    /**
     * Board Serial.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Holds all the squares in an array.
     */
    protected Square[][] squareArray = 
            new Square[WIDTH][HEIGHT];
    
    /**
     * Holds all the black pawns in an array.
     */
    private ChessPiece[] bPawnArray = 
            new Pawn[WIDTH];
    
    /**
     * Holds all the white pawns in an array.
     */
    private ChessPiece[] wPawnArray = 
            new Pawn[WIDTH];
    
    /**
     * Keeps track of whose turn it is.
     */
    private String turn = "white";
    
    /**
     * Color of square.
     */
    private String squareColour;
   
    /**
     * Destination col.
     */
    private int destCol;
    
    /**
     * Destination row.
     */
    private int destRow;
    
    /**
     * Active piece tracker.
     */
    private boolean active;
 
    /**
     * Keeps track of PieceObject.
     */
    private ChessPiece pieceNode;
    
    /**
     * Destination square.
     */
    private Square destSquare;
    
    /**
     * Destination piece.
     */
    private ChessPiece destPiece = new King("", 0, 0);;

    
    /**
     * Constructs an object of type Board.
     */
    public Board() {
    }

    
    /**
     * Sets up a new board.
     */
    public void newGame() {
        getChildren().clear();
        setSquares();
        setWhitePieces();
        setBlackPieces();
        System.out.println("Started New Game");
    }

    /**
     * Toggles piece selected. Active/Inactive.
     * @param click a mouse event.
     */
    public void togglePiece(MouseEvent click) {
        active = !(active);
        if (!active) {
            active = !(active);
            if (move(click)) {
                capture();
            }
        }
        getPieceInfo(click);
    }
    
    /**
     * Check if it's the correct player's turn.
     * @return a boolean.
     */
    public boolean turnCheck() {
        if (turn.equals(pieceNode.getColour())) {

            return true;
        } else {
            System.out.println("Not your turn");
        }
        return false;
    }
    
    /**
     * Moves piece to the destination.
     * @param click an event
     * @return a boolean
     */
    public boolean move(MouseEvent click) {
        getDestinationInfo(click);
        if (active && turnCheck() && isValid(click)) {
            setDestination();
            return true;
        }
        return false;
    }
    
    /**
     * Checks if move is valid based on the corresponding piece.
     * @param click an event
     * @return a boolean
     */
    public boolean isValid(MouseEvent click) {
        return (pieceNode.validMove(squareArray, pieceNode.getxCor(),
                pieceNode.getyCor(), destCol, destRow));
    }

    
    /**
     * Sets piece destination.
     */
    private void setDestination() {
        
        //Sets piece to new Col and Row
        setColumnIndex(pieceNode, destCol);
        setRowIndex(pieceNode, destRow);
        
        //Swaps piece location
        squareArray[pieceNode.getxCor()][pieceNode.getyCor()].setPiece(null);
        squareArray[destCol][destRow].setPiece(pieceNode);
        
        //Update's piece's internal x and y coordinates
        pieceNode.setxCor(destCol);
        pieceNode.setyCor(destRow);
        active = !(active);
        
        if (turn.equals("white")) {
            turn = "black";
            System.out.println("Black's turn");
        } else {
            turn = "white";
            System.out.println("White's turn");
        }

    }
    
    /**
     * Obtains destination's source information.
     * @param click a MouseEvent
     */
    private void getDestinationInfo(MouseEvent click) {
        
        if (click.getSource() instanceof Square) {
            destSquare = (Square) click.getSource();
            destCol = GridPane.getColumnIndex(destSquare);
            destRow = GridPane.getRowIndex(destSquare);
            System.out.println(destCol + " " + destRow + " " + destSquare);
        } else {
            destPiece = (ChessPiece) click.getSource();
            destCol = GridPane.getColumnIndex(destPiece);
            destRow = GridPane.getRowIndex(destPiece);
            System.out.println(destCol + " " + destRow + " " + destPiece);
        }
    }
    
    
    /**
     * Obtains chess piece's source information.
     * @param click a Mouse Event
     */
    private void getPieceInfo(MouseEvent click) {
        pieceNode = (ChessPiece) click.getSource();
        if (active) {
            System.out.println(pieceNode.getxCor() + " " + pieceNode.getyCor()
                    + " " + pieceNode + " selected");
        }
    }
    
    /**
     * Removes captured piece.
     */
    private void capture() {
        if (destPiece != pieceNode) {
            getChildren().remove(destPiece);
            System.out.println(destPiece + " captured");
        }
    }
    
    /**
     * Creates the squares on the Grid.
     */
    public void setSquares() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                // Determines colour of square
                squareColour = ((x + y) % 2 == 0) ? "grey" : "light grey";
                squareArray[x][y] = new Square(squareColour, x, y);
                add(squareArray[x][y], x, y);
                
                // Returns coordinates of the square
                squareArray[x][y].setOnMousePressed(this::move);
            }
        }
    }
    
    /**
     * Creates and sets White Pieces.
     */
    public void setWhitePieces() {        
        makePiece("King", "white", KING, CHESS_ROW1);
        makePiece("Queen", "white", QUEEN, CHESS_ROW1);
        makePiece("Bishop", "white", BISHOP1, CHESS_ROW1);
        makePiece("Bishop", "white", BISHOP2, CHESS_ROW1);
        makePiece("Knight", "white", KNIGHT1, CHESS_ROW1);
        makePiece("Knight", "white", KNIGHT2, CHESS_ROW1);
        makePiece("Rook", "white", ROOK1, CHESS_ROW1);
        makePiece("Rook", "white", ROOK2, CHESS_ROW1);
        makePawns("white");
    }
    
    /**
     * Creates and sets Black Pieces.
     */
    public void setBlackPieces() {
        makePiece("King", "black", KING, CHESS_ROW8);
        makePiece("Queen", "black", QUEEN, CHESS_ROW8);
        makePiece("Bishop", "black", BISHOP1, CHESS_ROW8);
        makePiece("Bishop", "black", BISHOP2, CHESS_ROW8);
        makePiece("Knight", "black", KNIGHT1, CHESS_ROW8);
        makePiece("Knight", "black", KNIGHT2, CHESS_ROW8);
        makePiece("Rook", "black", ROOK1, CHESS_ROW8);
        makePiece("Rook", "black", ROOK2, CHESS_ROW8);
        makePawns("black");
    }
    
    /**
     * Creates the pieces on the board.
     * @param name a String
     * @param colour a String
     * @param type an int to determine col position.
     * @param row an int
     */
    public void makePiece(String name, String colour, int type, int row) {
        
        switch (name) {
        case "King" :
            squareArray[type][row].setPiece(new King(colour, type, row));
            break;
        case "Queen" :
            squareArray[type][row].setPiece(new Queen(colour, type, row));
            break;
        case "Bishop" :
            squareArray[type][row].setPiece(new Bishop(colour, type, row));
            break;
        case "Knight" :
            squareArray[type][row].setPiece(new Knight(colour, type, row));
            break;
        case "Rook" :
            squareArray[type][row].setPiece(new Rook(colour, type, row));
            break;
        case "Pawn" :
            squareArray[type][row].setPiece(new Pawn(colour, type, row));
            break;
        default :
            break;
        }
        GridPane.setHalignment(squareArray[type][row].getPiece(), HPos.CENTER);
        add(squareArray[type][row].getPiece(), type, row);
        squareArray[type][row].getPiece().setOnMouseClicked(this::togglePiece);
    }
    
    /**
     * Makes pawn pieces.
     * @param colour a String.
     */
    public void makePawns(String colour) {
        if (colour.equals("white")) {
            for (int i = 0; i < WIDTH; i++) {
                wPawnArray[i] = new Pawn("white", i, CHESS_ROW2);
                add(wPawnArray[i], wPawnArray[i].getxCor(),
                        wPawnArray[i].getyCor());
                squareArray[i][CHESS_ROW2].setPiece(wPawnArray[i]);
                wPawnArray[i].setOnMouseClicked(this::togglePiece);
                GridPane.setHalignment(wPawnArray[i], HPos.CENTER);
            }
        } else {
            for (int i = 0; i < WIDTH; i++) {
                bPawnArray[i] = new Pawn("black", i, CHESS_ROW7);
                add(bPawnArray[i], bPawnArray[i].getxCor(),
                        bPawnArray[i].getyCor());
                squareArray[i][CHESS_ROW7].setPiece(bPawnArray[i]);
                bPawnArray[i].setOnMouseClicked(this::togglePiece);
                GridPane.setHalignment(bPawnArray[i], HPos.CENTER);
            }
        }
    }

}
