module com.tictactoe.tictactoe
{
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tictactoe.tictactoe to javafx.fxml;
    opens com.tictactoe.tictactoe.controller to javafx.fxml;

    exports com.tictactoe.tictactoe;
    exports com.tictactoe.tictactoe.controller;
}