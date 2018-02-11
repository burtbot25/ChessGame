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
public class Board extends GridPane {
    
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
    
    ////////////////////////////////////////////////////////////////
    /* NOTE TO SELF. Right now you have the squares being clicked
     * to move the piece to that space. You WILL need to make it
     * so that you can click on a piece and the piece will over take it.
     * Move will need to change its source to NOT just the square.*/
    
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
        add(wKing, 4, 7);
        wKing.setOnMouseClicked(this::togglePiece);
        ChessPiece wQueen = new Queen("white");
        add(wQueen, 3, 7);
        wQueen.setOnMouseClicked(this::togglePiece);
        ChessPiece wBishop1 = new Bishop("white");
        add(wBishop1, 2, 7);
        wBishop1.setOnMouseClicked(this::togglePiece);
        ChessPiece wBishop2 = new Bishop("white");
        add(wBishop2, 5, 7);
        wBishop2.setOnMouseClicked(this::togglePiece);
        ChessPiece wKnight1 = new Knight("white");
        add(wKnight1, 1, 7);
        wKnight1.setOnMouseClicked(this::togglePiece);
        ChessPiece wKnight2 = new Knight("white");
        add(wKnight2, 6, 7);
        wKnight2.setOnMouseClicked(this::togglePiece);
        ChessPiece wRook1 = new Rook("white");
        add(wRook1, 0, 7);
        wRook1.setOnMouseClicked(this::togglePiece);
        ChessPiece wRook2 = new Rook("white");
        add(wRook2, 7, 7);
        wRook2.setOnMouseClicked(this::togglePiece);
        for (int i = 0; i < ChessGame.WIDTH; i++) {
            wPawnArray[i] = new Pawn("white");
            add(wPawnArray[i], i, 6);
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
        add(bKing, 4, 0);
        bKing.setOnMouseClicked(this::togglePiece);
        ChessPiece bQueen = new Queen("black");
        add(bQueen, 3, 0);
        bQueen.setOnMouseClicked(this::togglePiece);
        ChessPiece bBishop1 = new Bishop("black");
        add(bBishop1, 2, 0);
        bBishop1.setOnMouseClicked(this::togglePiece);
        ChessPiece bBishop2 = new Bishop("black");
        add(bBishop2, 5, 0);
        bBishop2.setOnMouseClicked(this::togglePiece);
        ChessPiece bKnight1 = new Knight("black");
        add(bKnight1, 1, 0);
        bKnight1.setOnMouseClicked(this::togglePiece);
        ChessPiece bKnight2 = new Knight("black");
        add(bKnight2, 6, 0);
        bKnight2.setOnMouseClicked(this::togglePiece);
        ChessPiece bRook1 = new Rook("black");
        add(bRook1, 0, 0);
        bRook1.setOnMouseClicked(this::togglePiece);
        ChessPiece bRook2 = new Rook("black");
        add(bRook2, 7, 0);
        bRook2.setOnMouseClicked(this::togglePiece);
        for (int i = 0; i < ChessGame.WIDTH; i++) {
            bPawnArray[i] = new Pawn("black");
            add(bPawnArray[i], i, 1);
            bPawnArray[i].setOnMouseClicked(this::togglePiece);
        }
    }
}
