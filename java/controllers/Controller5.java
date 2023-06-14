package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import labs.lab5.src.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Controller5 {
    @FXML
    private Button exit_button;

    @FXML
    private TextArea outputText;

    @FXML
    private Button start_button;

    @FXML
    private void initialize() {
        MainController ctr = new MainController();
        ctr.handleButtonClick(exit_button, "/com/example/demo/main.fxml");
        start_button.setOnAction(start());
    }

    @FXML
    private EventHandler<ActionEvent> start() {
        return event -> {
            PrintStream oldOut = System.out;
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                System.setOut(printStream);

                StreamOperations.main(new String[0]);

                outputText.setText(outputStream.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                System.setOut(oldOut);
            }
        };
    }
}
