package com.tictactoe.tictactoe.model;

public class Game
{
    private final char[][] board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private boolean isGameActive;
    public Game(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new char[3][3];
        this.isGameActive = true;
        initializeBoard();
    }
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
    public boolean makeMove(int row, int col)
    {
        if (isGameActive && row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ')
        {
            board[row][col] = currentPlayer.getSymbol();
            return true;
        }
        return false;
    }
    public boolean checkWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if ((board[i][0] == currentPlayer.getSymbol() && board[i][1] == currentPlayer.getSymbol() && board[i][2] == currentPlayer.getSymbol()) || (board[0][i] == currentPlayer.getSymbol() && board[1][i] == currentPlayer.getSymbol() && board[2][i] == currentPlayer.getSymbol()))
            {
                isGameActive = false;
                return true;
            }
        }
        if ((board[0][0] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][2] == currentPlayer.getSymbol()) || (board[0][2] == currentPlayer.getSymbol() && board[1][1] == currentPlayer.getSymbol() && board[2][0] == currentPlayer.getSymbol()))
        {
            isGameActive = false;
            return true;
        }
        return false;
    }
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
    public void switchPlayer()
    {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    public char[][] getBoard()
    {
        return board;
    }
}