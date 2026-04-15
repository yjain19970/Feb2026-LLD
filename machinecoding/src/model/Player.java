package model;

import java.util.Scanner;

public class Player {
    private String symbol;
    private String name;
    private Long id;
    private PlayerType playerType;
    private Scanner scanner; // I have to take, name/symbol as input from player.

    public Player(Long id, String name, String symbol, PlayerType type) {
        this.id = id;
        this.playerType = type;
        this.name = name;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    /**
     * For making the move we need to take Input from the player.
     * @param board
     * @return
     */
    public Move getInputAndMakeMove(Board board) {
        /**
         * S1. Check whether player is a BOT or not.
         * S2. If the player is HUMAN:
         *      - Take Row Input
         *      - Take Col Input
         * 
         * S3. Return the new Move()    
         */
        if(this.playerType.equals(PlayerType.BOT)){
            // Skip taking the input and decide the move on the basis of BotPlayingStrategy.
            /**
             * ToDo: Implement it.
             * 
             * S1. Create a factory and pass the DifficultyLevel
             * S2. On the basis of difficultyLevel, create a move.
             * S3. finally return.
             * 
             * EASY: Make the move at first EMPTY cell in the board
             * MEDIUM: Always make move in the center, if center is NA, then make a move on Row center or column center.
             * HARD: Have some complex algorithm.
             * 
             */
        }

        System.out.println("Please select Row number");
        int row = scanner.nextInt();
        System.out.println("Please select Column number");
        int col = scanner.nextInt();

        // Create a new Move and Return from here.
        return new Move(new Cell(row, col), this);
    }    

}