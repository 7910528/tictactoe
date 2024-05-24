module com.tictactoe.tictactoe
{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;

    opens com.tictactoe.tictactoe to javafx.fxml;
    opens com.tictactoe.tictactoe.controller to javafx.fxml;
    opens com.tictactoe.tictactoe.model to org.junit.jupiter;

    exports com.tictactoe.tictactoe;
    exports com.tictactoe.tictactoe.controller;
    exports com.tictactoe.tictactoe.model;
}