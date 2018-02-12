package ca.bcit.comp2526.A2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ChessGame.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class ChessGame extends Application {

    /**
     * Size of square.
     */
    public static final int SQUARE_SIZE = 75;
    
    /**
     * Board width.
     */
    public static final int WIDTH = 8;
    
    /**
     * Board height.
     */
    public static final int HEIGHT = 8;
    
    /**
     * Launches the Chess game.
     * @see javafx.application.Application#start(javafx.stage.Stage)
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Board chessboard = new Board();
        Scene scene = new Scene(chessboard);
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Instantiates and runs the game.
     * @param args unused.
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
