package ca.bcit.comp2526.A2;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

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
     * Color of square.
     */
    private String colour;
    
    /**
     * X position of square.
     */
    private int xCor;
    
    /**
     * Y position of square.
     */
    private int yCor;
    
    private Integer objCol;
    
    private Integer objRow;
    
    private Integer sqCol;
    
    private Integer sqRow;
    
    private boolean active;
 
    /**
     * Keeps track of the event's source node.
     */
    private Node source;
    
    private Node squareSource;
    
    /**
     * Constructs an object of type Board.
     */
    public Board() {
        makeSquares();
        makePieces();
    }
        
    /**
     * Gets the position of the object within the grid pane.
     * @param e an event
     */
    public void move(MouseEvent e) {
        squareSource = (Node) e.getSource();
        sqCol = GridPane.getColumnIndex(squareSource);
        sqRow = GridPane.getRowIndex(squareSource);
        System.out.println(sqCol + " " + sqRow);
        System.out.println(squareSource);
        
        if (active) {
            setColumnIndex(source, sqCol);
            setRowIndex(source, sqRow);
            active = !(active);
        }
    }
    
    
    public void togglePiece(MouseEvent e) {
        active = !(active);
        source = (Node) e.getSource();
        objCol = GridPane.getColumnIndex(source);
        objRow = GridPane.getRowIndex(source);
        
        System.out.println(objCol + " " + objRow);
        System.out.println(source);
    }
    
    /**
     * Creates the squares on the Grid.
     */
    public void makeSquares() {
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
     * Creates the pieces on the board.
     */
    public void makePieces() {
        ChessPiece bKing = new King("black");
        ChessPiece wKing = new King("white");
        add(bKing, 4, 0);
        add(wKing, 4, 7);
        
        bKing.setOnMouseClicked(this::togglePiece);
        wKing.setOnMouseClicked(this::togglePiece);
    }
}
