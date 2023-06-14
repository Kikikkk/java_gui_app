package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import labs.lab6.src.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Controller6 {
    private Main main = new Main();
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
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            System.setOut(printStream);

            AbstractProgram program = new AbstractProgram();
            Supervisor supervisor = new Supervisor(program);

            program.start();
            supervisor.start();

            try {
                Thread.sleep(3000); // Wait for the program to run for some time
                program.stop(); // Stop the program after 3 seconds
                supervisor.join(); // Wait for the supervisor thread to finish

                String output = outputStream.toString();
                outputText.setText(output);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
