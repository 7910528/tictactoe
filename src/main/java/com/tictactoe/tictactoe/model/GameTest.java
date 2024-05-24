package com.tictactoe.tictactoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest
{
    private Game game;
    private Player player1;
    private Player player2;
    @BeforeEach
    public void setUp()
    {
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        game = new Game(player1, player2);
    }
    @Test
    public void testInitialBoardSetup()
    {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                assertEquals(' ', board[i][j]);
            }
        }
    }
    @Test
    public void testMakeMove()
    {
        game.makeMove(0, 0);
        assertEquals(player1.getSymbol(), game.getBoard()[0][0]);
    }
    @Test
    public void testInvalidMove()
    {
        game.makeMove(0, 0);
        assertFalse(game.makeMove(0, 0));
    }
    @Test
    public void testCheckWin()
    {
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);
        assertTrue(game.checkWin());
    }
    @Test
    public void testCheckTie()
    {
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(0, 2);
        game.makeMove(1, 0);
        game.makeMove(1, 2);
        game.makeMove(1, 1);
        game.makeMove(2, 0);
        game.makeMove(2, 2);
        game.makeMove(2, 1);
        assertTrue(game.checkTie());
    }
    @Test
    public void testSwitchPlayer()
    {
        assertEquals(player1, game.getCurrentPlayer());
        game.switchPlayer();
        assertEquals(player2, game.getCurrentPlayer());
    }
}