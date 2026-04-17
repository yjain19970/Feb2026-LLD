package tictactoe.src.controller;

import java.util.List;

import tictactoe.src.model.Game;
import tictactoe.src.model.GameState;
import tictactoe.src.model.Player;


public class GameController {

    public Game startGame(int dimension, List<Player> players){
        return new Game(dimension, players);
    }

    public GameState checkGameState(Game game){
        return game.getGameState();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undo(Game game){
        game.undo();
    }

    public void displayBoard(Game game){
        game.printBoard();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }


}
