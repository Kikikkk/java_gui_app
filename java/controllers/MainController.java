package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button open_button1;

    @FXML
    private Button open_button2;

    @FXML
    private Button open_button3;

    @FXML
    private Button open_button4;

    @FXML
    private Button open_button5;

    @FXML
    private Button open_button6;

    @FXML
    private void initialize() {
        handleButtonClick(open_button1, "/program1.fxml");
        handleButtonClick(open_button2, "/program2.fxml");
        handleButtonClick(open_button3, "/program3.fxml");
        handleButtonClick(open_button4, "/program4.fxml");
        handleButtonClick(open_button5, "/program5.fxml");
        handleButtonClick(open_button6, "/program6.fxml");

    }

    public void handleButtonClick(Button button, String fxmlPath) {
        button.setOnAction(actionEvent -> {
            button.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlPath));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

}
