package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import strategy.ColWinningStrategyImpl;
import strategy.DiagonalWinningStrategyImpl;
import strategy.RowWinningStrategyImpl;
import strategy.WinningStrategy;

public class Game {
   private List<Player> players;   // Y
    private Board board; // dimension: 
    private List<Move> moves; // N
    private Player winner;  // N
    private GameState gameState; // N 
    private int nextMovePlayerIndex; // N 
    private List<WinningStrategy> winningStrategies; // N
    
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
        /**
         * S1. Get the player using the nextPlayerIndex from players list.
         * S2. Take the input from player and then make move.
         * S3. Validate the player move.
         * S4. Store the move in the List<Move>
         * S5. Calculate the next player Index
         * S6. Check winner
         */
        
        //S1. 
        Player currentPlayer = players.get(nextMovePlayerIndex);
        System.out.println("It is player: "  + currentPlayer.getName()+ "'s move.");

        // S2.
        Move currentMove = currentPlayer.getInputAndMakeMove(board);

        //S3.
        if(invalidMove(currentMove)){
            System.out.println("Invalid move. Please provide the X,Y values correctly...");
            return;
        }

        //S4.
        int currentRow = currentMove.getCell().getRow();
        int currentCol = currentMove.getCell().getCol();
        System.out.println("Move is made in: "+ currentRow + " and Col: " + currentCol);

        // Fetching cell from a 2D matrix.
        Cell currentCell = board.getBoard().get(currentRow).get(currentCol);
        currentCell.setCellState(CellState.FILLED); // Marking the cell as FILLED
        currentCell.setPlayer(currentPlayer); // Adding the player to the cell.

        // Make a move.
        Move newMoveObj = new Move(currentCell, currentPlayer);
        moves.add(newMoveObj);

        //S5. 
        nextMovePlayerIndex  +=1;
        nextMovePlayerIndex %= players.size(); // make sure to keep the value within the index...

        // S6. 
        if(checkWinner(board, newMoveObj)){
            gameState = GameState.WIN;
            winner = currentPlayer;
        }else if(moves.size() == this.getBoard().getSize()*this.getBoard().getSize()){
            // moves = 9
            // board= 3
            gameState = GameState.DRAW;
        }

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

        if(moves.size()==0){
            System.out.println("no moves made yet. Cannot undo");
            return;
        }
        if(!gameState.equals(GameState.IN_PROGRESS)){
            System.out.println("Game is not in-progress anymore. Cannot undo");
            return;
        }

        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);


        nextMovePlayerIndex -=1;
        nextMovePlayerIndex = (nextMovePlayerIndex + players.size())%players.size();

        // Last part:
        for(WinningStrategy strategy : winningStrategies){
            strategy.handleUndo(board, lastMove);
        }

        lastMove.getCell().setCellState(CellState.EMPTY);
        lastMove.getCell().setPlayer(null);
        
        
    }

    public void printBoard(){
        board.printBoard();
    }


    /**
     * Al the Private Methods start from here.
     */
    private boolean checkWinner(Board board, Move newMove) {
        for(WinningStrategy wStrategy : winningStrategies){
            if(wStrategy.checkWinner(board, newMove)){
                System.out.println("Check winner returns true : ");
                return true;
            }
        }
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
