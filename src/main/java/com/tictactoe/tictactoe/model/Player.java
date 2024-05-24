package com.tictactoe.tictactoe.model;

/**
 * Represents a player in the Tic Tac Toe game.
 */
public class Player
{
    private final String name;
    private final char symbol;
    /**
     * Initializes a new player with the specified name and symbol.
     *
     * @param name the name of the player
     * @param symbol the symbol of the player ('X' or 'O')
     */
    public Player(String name, char symbol)
    {
        this.name = name;
        this.symbol = symbol;
    }
    /**
     * Gets the name of the player.
     *
     * @return the name of the player
     */
    public String getName()
    {
        return name;
    }
    /**
     * Gets the symbol of the player.
     *
     * @return the symbol of the player
     */
    public char getSymbol()
    {
        return symbol;
    }
}