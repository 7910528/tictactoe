package com.tictactoe.tictactoe.controller;

import com.tictactoe.tictactoe.model.Game;
import com.tictactoe.tictactoe.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TicTacToeController
{
    @FXML
    private Label currentPlayerLabel;
    @FXML
    private GridPane boardGrid;
    private Game game;
    @FXML
    public void initialize()
    {
        startNewGame();
    }
    @FXML
    protected void handleCellClick(javafx.event.ActionEvent event)
    {
        Button clickedButton = (Button) event.getSource();
        Integer row = GridPane.getRowIndex(clickedButton);
        Integer col = GridPane.getColumnIndex(clickedButton);
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
    @FXML
    private void exitGame()
    {
        System.exit(0);
    }
    private void updateCurrentPlayerLabel()
    {
        currentPlayerLabel.setText(game.getCurrentPlayer().getName() + "'s turn");
    }
    private void disableBoard()
    {
        boardGrid.getChildren().filtered(node -> node instanceof Button).forEach(node -> node.setDisable(true));
    }
}