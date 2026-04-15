import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.GameController;
import model.Game;
import model.GameState;
import model.Player;
import model.PlayerType;

public class Driver {
    public static void main(String[] args) throws Exception {
        // This class will Interact with my GameController.
        Scanner scanner = new Scanner(System.in); // DISCUSS THIS LAYER.
        try{
            int dimension = 3; // HARD CODE IT FOR NOW.
            List<Player> players = new ArrayList<>();
            players.add(new Player(1L, "Yash", "X", PlayerType.HUMAN));
            players.add(new Player(2L, "Abhijeet", "O", PlayerType.HUMAN));

            
            GameController gameController = new GameController();
            Game game =  gameController.startGame(dimension, players);

            while(gameController.checkGameState(game).equals(GameState.IN_PROGRESS)){
                // Display the board to the user to see where they can make a move.
                gameController.displayBoard(game);

                String undoInput = "N";
                if(game.getMoves().size()!=0){
                    System.out.print("Do you want to do Undo: Y/N");
                    undoInput = scanner.next();
                }
                

                if(undoInput.equals("Y")){
                    gameController.undo(game);
                    continue;
                }

                System.out.println("Please make a move... ");
                gameController.makeMove(game);


            }

            if(gameController.checkGameState(game).equals(GameState.WIN)){
                System.out.println("Player has won the game: " + gameController.getWinner(game).getName());
            }else if(gameController.checkGameState(game).equals(GameState.DRAW)){
                System.out.println("Game is drawn...");
            }

            System.out.println("Final Output of the board: ");
            gameController.displayBoard(game);

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