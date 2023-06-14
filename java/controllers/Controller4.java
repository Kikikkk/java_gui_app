package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import labs.lab4.src.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Controller4 {
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

                String pathToDictionary = "src/main/java/labs/lab4/src/dictionary.txt";
                String pathToText = "src/main/java/labs/lab4/src/input.txt";
                Lab4.main(new String[] { pathToDictionary, pathToText });

                String output = outputStream.toString();
                outputText.setText(output);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                System.setOut(oldOut);
            }
        };
    }
}
