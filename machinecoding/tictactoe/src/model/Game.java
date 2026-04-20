package tictactoe.src.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tictactoe.src.strategy.WinningStrategy;
import tictactoe.src.exception.InvalidMoveException;
import tictactoe.src.exception.NoValidCellFoundException;
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


     /***
         * S1. Get the currentPlayer for whom we would like to make a move.
         * S2. Take Input (Row,Col) from the player
         * S3. Validate the Input (Eg: Invalid R/C, cell is not empty)
         * S4. Store the move to moves[] and mark the cell as FILLED
         * S5. Increment the `nextMovePlayerIndex`.
         * S6. Check for player win. If player has won, assign the winner to that player. 
     */
    public void makeMove() throws NoValidCellFoundException, InvalidMoveException {
        // S1
        Player currentPlayer = players.get(nextMovePlayerIndex);
        System.out.println("It is player: " + currentPlayer.getName() + " 's move");
        // S2
        Move newMove =  currentPlayer.getInputAndMakeMove(board);
        //S3
        if(invalidMove(newMove)){
            throw new InvalidMoveException("move is invalid!");
        }

        int currRow = newMove.getCell().getRow();
        int currCol = newMove.getCell().getCol();
        System.out.println("move is made in --> Row: " + currRow + "col: " + currCol);

        Cell currCell = this.getBoard().getBoard().get(currRow).get(currCol);
        currCell.setCellState(CellState.FILLED);
        currCell.setPlayer(currentPlayer);
        // S4.
        Move finalMove = new Move(currCell, currentPlayer);
        moves.add(finalMove);
        // S5.
        nextMovePlayerIndex +=1;
        nextMovePlayerIndex %= players.size();
        // S6.
        if(checkWinner(board, finalMove)){
            this.winner = currentPlayer;
            this.gameState = GameState.WIN;
        }else if(moves.size() == this.getBoard().getSize()* this.getBoard().getSize()){
            this.gameState = GameState.DRAW;
        }
    }
    
    public void undo() throws InvalidMoveException {
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
            System.out.println("No moves made yet!");
            //throw new InvalidMoveException("No moves made yet!");
        }
        if(!gameState.equals(GameState.IN_PROGRESS)){
            System.out.println("Game is not in progress!");
            //throw new InvalidMoveException("Game is not in progress anymore!");
        }

        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);

        nextMovePlayerIndex -= 1;
        nextMovePlayerIndex = (nextMovePlayerIndex + players.size())%players.size();

        for(WinningStrategy winningStrategy: winningStrategies){
            winningStrategy.handleUndo(board, lastMove);
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
        for(WinningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(board, newMove)){
                System.out.println("Player has won the game: "+ winningStrategy.getClass().getSimpleName());
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
        Cell currMoveCell = this.getBoard().getBoard().get(currentMove.getCell().getRow()).get(currentMove.getCell().getCol());
        if(currMoveCell.getCellState().equals(CellState.FILLED)){
            return true;
        }
        return false;
    }

}
