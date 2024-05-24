module com.tictactoe.tictactoe
{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;

    opens com.tictactoe.tictactoe to javafx.fxml;
    opens com.tictactoe.tictactoe.controller to javafx.fxml;
    opens com.tictactoe.tictactoe.model to org.junit.platform.commons, org.junit.jupiter.api;

    exports com.tictactoe.tictactoe;
    exports com.tictactoe.tictactoe.controller;
    exports com.tictactoe.tictactoe.model;
}