package ca.bcit.comp2526.A2;
import javafx.scene.Node;
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
public class Board extends GridPane implements Move {
    
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
     * Holds all the squares in an array.
     */
    private Square[][] squareArray = 
            new Square[ChessGame.WIDTH][ChessGame.HEIGHT];
    
    /**
     * Holds all the black pawns in an array.
     */
    private ChessPiece[] bPawnArray = 
            new Pawn[ChessGame.WIDTH];
    
    /**
     * Holds all the white pawns in an array.
     */
    private ChessPiece[] wPawnArray = 
            new Pawn[ChessGame.WIDTH];
    
    /**
     * Color of square.
     */
    private String colour;
    
    /**
     * Piece col.
     */
    private Integer pCol;
    
    /**
     * Piece row.
     */
    private Integer pRow;
    
    /**
     * Square col.
     */
    private Integer sqCol;
    
    /**
     * Square row.
     */
    private Integer sqRow;
    
    /**
     * Active piece tracker.
     */
    private boolean active;
 
    /**
     * Keeps track of PieceObject.
     */
    private Node pieceNode;
    
    /**
     * Keeps track of Square object.
     */
    private Node squareNode;
    
    /**
     * Constructs an object of type Board.
     */
    public Board() {
        setSquares();
        setWhitePieces();
        setBlackPieces();
    }
        
    /**
     * Gets the position of the object within the grid pane.
     * @param e an event
     */
    public void move(MouseEvent e) {
        squareNode = (Node) e.getSource();
        sqCol = GridPane.getColumnIndex(squareNode);
        sqRow = GridPane.getRowIndex(squareNode);
        System.out.println(sqCol + " " + sqRow);
        System.out.println(squareNode);
        
        if (active) {
            setColumnIndex(pieceNode, sqCol);
            setRowIndex(pieceNode, sqRow);
            active = !(active);
        }
    }
    
    /**
     * Toggles pieces selected. Active/Inactive.
     * @param e a mouse event.
     */
    public void togglePiece(MouseEvent e) {
        active = !(active);
        
        if (!active) {
            active = !(active);
            move(e);
        }
        
        pieceNode = (Node) e.getSource();
        pCol = GridPane.getColumnIndex(pieceNode);
        pRow = GridPane.getRowIndex(pieceNode);
        System.out.println(pCol + " " + pRow);
        System.out.println(pieceNode);
        
    }
    
    /**
     * Creates the squares on the Grid.
     */
    public void setSquares() {
        for (int x = 0; x < ChessGame.WIDTH; x++) {
            for (int y = 0; y < ChessGame.HEIGHT; y++) {
                // Determines colour of square
                if ((x + y) % 2 == 0) {
                    colour = "grey";
                } else {
                    colour = "light grey";
                }
                squareArray[x][y] = new Square(colour, x, y);
                add(squareArray[x][y], x, y);
                
                // Returns coordinates of the square
                squareArray[x][y].setOnMousePressed(this::move);
            }
        }
    } //End of makeGrid
    
    /**
     * Creates and sets White Pieces.
     */
    public void setWhitePieces() {
        ChessPiece wKing = new King("white");
        add(wKing, KING, CHESS_ROW1);
        wKing.setOnMouseClicked(this::togglePiece);
        ChessPiece wQueen = new Queen("white");
        add(wQueen, QUEEN, CHESS_ROW1);
        wQueen.setOnMouseClicked(this::togglePiece);
        ChessPiece wBishop1 = new Bishop("white");
        add(wBishop1, BISHOP1, CHESS_ROW1);
        wBishop1.setOnMouseClicked(this::togglePiece);
        ChessPiece wBishop2 = new Bishop("white");
        add(wBishop2, BISHOP2, CHESS_ROW1);
        wBishop2.setOnMouseClicked(this::togglePiece);
        ChessPiece wKnight1 = new Knight("white");
        add(wKnight1, KNIGHT1, CHESS_ROW1);
        wKnight1.setOnMouseClicked(this::togglePiece);
        ChessPiece wKnight2 = new Knight("white");
        add(wKnight2, KNIGHT2, CHESS_ROW1);
        wKnight2.setOnMouseClicked(this::togglePiece);
        ChessPiece wRook1 = new Rook("white");
        add(wRook1, ROOK1, CHESS_ROW1);
        wRook1.setOnMouseClicked(this::togglePiece);
        ChessPiece wRook2 = new Rook("white");
        add(wRook2, ROOK2, CHESS_ROW1);
        wRook2.setOnMouseClicked(this::togglePiece);
        for (int i = 0; i < ChessGame.WIDTH; i++) {
            wPawnArray[i] = new Pawn("white");
            add(wPawnArray[i], i, CHESS_ROW2);
            wPawnArray[i].setOnMouseClicked(this::togglePiece);
        }
        
        //GridPane.setHalignment(wKing, HPos.CENTER);
        //whitePiecesArray[0] = wKing;
    }
    
    /**
     * Creates and sets Black Pieces.
     */
    public void setBlackPieces() {
        ChessPiece bKing = new King("black");
        add(bKing, KING, CHESS_ROW8);
        bKing.setOnMouseClicked(this::togglePiece);
        ChessPiece bQueen = new Queen("black");
        add(bQueen, QUEEN, CHESS_ROW8);
        bQueen.setOnMouseClicked(this::togglePiece);
        ChessPiece bBishop1 = new Bishop("black");
        add(bBishop1, BISHOP1, CHESS_ROW8);
        bBishop1.setOnMouseClicked(this::togglePiece);
        ChessPiece bBishop2 = new Bishop("black");
        add(bBishop2, BISHOP2, CHESS_ROW8);
        bBishop2.setOnMouseClicked(this::togglePiece);
        ChessPiece bKnight1 = new Knight("black");
        add(bKnight1, KNIGHT1, CHESS_ROW8);
        bKnight1.setOnMouseClicked(this::togglePiece);
        ChessPiece bKnight2 = new Knight("black");
        add(bKnight2, KNIGHT2, CHESS_ROW8);
        bKnight2.setOnMouseClicked(this::togglePiece);
        ChessPiece bRook1 = new Rook("black");
        add(bRook1, ROOK1, CHESS_ROW8);
        bRook1.setOnMouseClicked(this::togglePiece);
        ChessPiece bRook2 = new Rook("black");
        add(bRook2, ROOK2, CHESS_ROW8);
        bRook2.setOnMouseClicked(this::togglePiece);
        for (int i = 0; i < ChessGame.WIDTH; i++) {
            bPawnArray[i] = new Pawn("black");
            add(bPawnArray[i], i, CHESS_ROW7);
            bPawnArray[i].setOnMouseClicked(this::togglePiece);
        }
    }
}
