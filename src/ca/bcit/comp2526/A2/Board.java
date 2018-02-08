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
    
    private boolean active;
 
    /**
     * Keeps track of the event's source node.
     */
    private Node source;
    
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
    public void getPosition(MouseEvent e) {
        source = (Node) e.getSource();
        objCol = GridPane.getColumnIndex(source);
        objRow = GridPane.getRowIndex(source);
        System.out.println(objCol + " " + objRow);
        System.out.println(source);
    }
    
    /**
     * Gets the position of the object within the grid pane.
     * @param e an event
     */
    public void setPosition(MouseEvent e) {
        source = (Node) e.getSource();
        objCol = GridPane.getColumnIndex(source);
        objRow = GridPane.getRowIndex(source);
        System.out.println(objCol + " " + objRow);
        setColumnIndex(source, objCol);
        setRowIndex(source, objRow);
        System.out.println("Setting Position");
    }
    
    public void move(MouseEvent e) {
        active = !(active);
        
        source = (Node) e.getSource();
        objCol = GridPane.getColumnIndex(source);
        objRow = GridPane.getRowIndex(source);
        System.out.println(objCol + " " + objRow);
        System.out.println(source);
        
        if (active) {
            System.out.println("Active");
            
        } else {
            System.out.println("Deslected");
        }
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
                squareArray[x][y].setOnMousePressed(this::getPosition);
            }
        }
    } //End of makeGrid
    
    /**
     * Creates the pieces on the board.
     */
    public void makePieces() {
        ChessPiece bKing = new King("black");
        ChessPiece wKing = new King("white");
        add(bKing, 3, 3);
        add(wKing, 0, 1);
        
        bKing.setOnMouseClicked(this::move);
        wKing.setOnMouseClicked(this::move);
        wKing.setOnMousePressed(this::getPosition);
    }
}
