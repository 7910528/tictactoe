package com.tictactoe.tictactoe.model;

/**
 * Represents a Tic Tac Toe game.
 */
public class Game
{
    private final char[][] board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private boolean isGameActive;
    /**
     * Initializes a new game with two players.
     *
     * @param player1 the first player
     * @param player2 the second player
     */
    public Game(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new char[3][3];
        this.isGameActive = true;
        initializeBoard();
    }
    /**
     * Initializes the game board with empty spaces.
     */
    private void initializeBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }
    /**
     * Makes a move at the specified row and column.
     *
     * @param row the row index
     * @param col the column index
     * @return true if the move is valid and made, false otherwise
     */
    public boolean makeMove(int row, int col)
    {
        if (isGameActive && isValidMove(row, col))
        {
            board[row][col] = currentPlayer.getSymbol();
            return true;
        }
        return false;
    }
    /**
     * Checks if the move is valid.
     *
     * @param row the row index
     * @param col the column index
     * @return true if the move is valid, false otherwise
     */
    private boolean isValidMove(int row, int col)
    {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
    /**
     * Checks if the current player has won.
     *
     * @return true if the current player has won, false otherwise
     */
    public boolean checkWin()
    {
        if (isRowWin() || isColumnWin() || isDiagonalWin())
        {
            isGameActive = false;
            return true;
        }
        return false;
    }
    /**
     * Checks if there is a row win.
     *
     * @return true if there is a row win, false otherwise
     */
    private boolean isRowWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == currentPlayer.getSymbol() && board[i][1] == currentPlayer.getSymbol() && board[i][2] == currentPlayer.getSymbol())
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Checks if there is a column win.
     *
     * @return true if there is a column win, false otherwise
     */
    private boolean isColumnWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[0][i] == currentPlayer.getSymbol() && board[1][i] == currentPlayer.getSymbol() && board[2][i] == currentPlayer.getSymbol())
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Checks if there is a diagonal win.
     *
     * @return true if there is a diagonal win, false otherwise
     */
    private boolean isDiagonalWin()
    {
        return (board[0][0] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol()) ||
                (board[0][2] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][0] == currentPlayer.getSymbol());
    }
    /**
     * Checks if the game is a tie.
     *
     * @return true if the game is a tie, false otherwise
     */
    public boolean checkTie()
    {
        if (!isGameActive)
        {
            return false;
        }
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == ' ')
                {
                    return false;
                }
            }
        }
        isGameActive = false;
        return true;
    }
    /**
     * Switches the current player.
     */
    public void switchPlayer()
    {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    /**
     * Gets the current player.
     *
     * @return the current player
     */
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    /**
     * Gets the game board.
     *
     * @return the game board
     */
    public char[][] getBoard()
    {
        return board;
    }
}