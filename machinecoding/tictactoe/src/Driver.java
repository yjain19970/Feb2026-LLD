import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tictactoe.src.controller.GameController;
import tictactoe.src.model.Game;
import tictactoe.src.model.GameState;
import tictactoe.src.model.Player;
import tictactoe.src.model.PlayerType;


public class Driver {
    public static void main(String[] args) throws Exception {
        // This class will Interact with my GameController.
        Scanner scanner = new Scanner(System.in); // DISCUSS THIS LAYER.
        try{
            int dimension = 3; // HARD CODE IT FOR NOW.
            List<Player> players = new ArrayList<>();
            players.add(new Player(1L, "Yash", "X", PlayerType.HUMAN));
            players.add(new Player(2L, "Karthick", "O", PlayerType.HUMAN));

            
            GameController gameController = new GameController();
            Game game =  gameController.startGame(dimension, players);

            while(gameController.checkGameState(game).equals(GameState.IN_PROGRESS)){
                // S1. Display the board
                gameController.displayBoard(game);

                System.out.println("Please make your move.");
                gameController.makeMove(game);
            }

            if(gameController.checkGameState(game).equals(GameState.WIN)){
                System.out.println("Player " + gameController.getWinner(game).getName() + " has won the game...");

            }else if(gameController.checkGameState(game).equals(GameState.DRAW)){
                System.out.println("Game is DRAWN!");
            }

        }catch(Exception e){
            System.out.println("Exception happened: " + e);
        } finally{
            scanner.close();
        }
    }

}

/**
 * 
 * 
 * Pending part;
 * 1. DiagonalWinningStrategy (checkWinner and handleUndo)
 * 2. Validations after Move for a player (Row>0 and <N and Col>0 and <N)
 * 3. GameClass: You can have BuilderDP
 * 4. BoTPlayingStragey: Factory.
 * 
 * 
 */