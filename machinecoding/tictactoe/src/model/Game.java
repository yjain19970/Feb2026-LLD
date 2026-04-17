package tictactoe.src.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tictactoe.src.strategy.WinningStrategy;
import tictactoe.src.strategy.ColWinningStrategyImpl;
import tictactoe.src.strategy.DiagonalWinningStrategyImpl;
import tictactoe.src.strategy.RowWinningStrategyImpl;





public class Game {
   private List<Player> players;   // Y
    private Board board; // d: 
    private List<Move> moves; //
    private Player winner;  //
    private GameState gameState; // 
    private int nextMovePlayerIndex; //
    private List<WinningStrategy> winningStrategies; //
    
    /**
     * Todo: Implement the Builder DP for GameController by self.
     * @param dimension
     * @param players
     */
    public Game(int dimension,
                List<Player> players){
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = Arrays.asList(new RowWinningStrategyImpl(), 
                                            new ColWinningStrategyImpl(),
                                        new DiagonalWinningStrategyImpl()); // Add here
        this.moves = new ArrayList<>();
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayerIndex = 0;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }
    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }
    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }
    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }


    public void makeMove() {
        /***
         * S1. Get the currentPlayer for whom we would like to make a move.
         * S2. Take Input (Row,Col) from the player
         * S3. Validate the Input (Eg: Invalid R/C, cell is not empty)
         * S4. Store the move to moves[] and mark the cell as FILLED
         * S5. Increment the `nextMovePlayerIndex`.
         * S6. Check for player win. If player has won, assign the winner to that player. 
         */

        Player currentPlayer = players.get(nextMovePlayerIndex);
        System.out.println("It is player: " + currentPlayer.getName() + " 's move");

        Move newMove =  currentPlayer.getInputAndMakeMove(board);

        // Resume from S3. 

    }
    
    public void undo() {
        /**
         * Steps for UNDO:
         * 
         * 1. Get the last move from the moves list
         * 2. Remove the last move from the list.
         * 3. Update the cell status to EMPTY and player to null in CELL.
         * 4. Decreament the lastPlayerIndex
         * 5. handle undo in winning strategy.
         */
    }

    public void printBoard(){
        board.printBoard();
    }


    /**
     * Al the Private Methods start from here.
     */
    private boolean checkWinner(Board board, Move newMove) {
        return false;
    }  

    // toDo: to implement by own.
    private boolean invalidMove(Move currentMove) {
        /**
         * ToDO: Check for validations...
         *  But you guys will have to handle the validation cases.
         * 1. Row>=0 , Col>=0 && row<n && col <n
         * 2. If the current cell state is NOT EMPTY -- then return true.
         */
        return false;
    }

}
