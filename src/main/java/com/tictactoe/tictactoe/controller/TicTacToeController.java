package com.tictactoe.tictactoe.controller;

import com.tictactoe.tictactoe.model.Game;
import com.tictactoe.tictactoe.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Controller for the Tic Tac Toe game.
 */
public class TicTacToeController
{
    @FXML
    private Label currentPlayerLabel;
    @FXML
    private GridPane boardGrid;
    private Game game;
    /**
     * Initializes the controller and starts a new game.
     */
    @FXML
    public void initialize()
    {
        startNewGame();
    }
    /**
     * Handles a cell click event.
     *
     * @param event the event triggered by clicking a cell
     */
    @FXML
    protected void handleCellClick(javafx.event.ActionEvent event)
    {
        Button clickedButton = (Button) event.getSource();
        Integer row = GridPane.getRowIndex(clickedButton);
        Integer col = GridPane.getColumnIndex(clickedButton);
        if (row == null || col == null)
        {
            return;
        }
        if (clickedButton.getText().isEmpty() && game.makeMove(row, col))
        {
            clickedButton.setText(String.valueOf(game.getCurrentPlayer().getSymbol()));
            if (game.checkWin())
            {
                currentPlayerLabel.setText(game.getCurrentPlayer().getName() + " wins!");
                disableBoard();
            }
            else if (game.checkTie())
            {
                currentPlayerLabel.setText("It's a tie!");
                disableBoard();
            }
            else
            {
                game.switchPlayer();
                updateCurrentPlayerLabel();
            }
        }
    }
    /**
     * Starts a new game.
     */
    @FXML
    private void startNewGame()
    {
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        game = new Game(player1, player2);
        boardGrid.setDisable(false);
        boardGrid.getChildren().filtered(node -> node instanceof Button).forEach(node -> {
            Button button = (Button) node;
            button.setText("");
            button.setDisable(false);
        });
        updateCurrentPlayerLabel();
    }
    /**
     * Exits the game.
     */
    @FXML
    private void exitGame()
    {
        System.exit(0);
    }
    /**
     * Updates the current player label.
     */
    private void updateCurrentPlayerLabel()
    {
        currentPlayerLabel.setText(game.getCurrentPlayer().getName() + "'s turn");
    }
    /**
     * Disables the game board.
     */
    private void disableBoard()
    {
        boardGrid.getChildren().filtered(node -> node instanceof Button).forEach(node -> node.setDisable(true));
    }
}