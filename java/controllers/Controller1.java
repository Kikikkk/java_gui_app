package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import labs.lab1.src.main.java.*;

public class Controller1 {
    private Hero hero = new Hero(new WalkStrategy());
    @FXML
    private Button exit_button;

    @FXML
    private MenuItem move1;

    @FXML
    private MenuItem move2;

    @FXML
    private MenuItem move3;
    @FXML
    private MenuItem move4;

    @FXML
    private TextArea outputText;

    @FXML
    private void initialize() {
        MainController ctr = new MainController();
        ctr.handleButtonClick(exit_button, "/com/example/demo/main.fxml");
        move1.setOnAction(setMove1());
        move2.setOnAction(setMove2());
        move3.setOnAction(setMove3());
        move4.setOnAction(setMove4());
    }

    @FXML
    private EventHandler<ActionEvent> setMove1() {
        return event -> {
            hero.setMoveStrategy(new WalkStrategy());
            outputText.setText(hero.move());
        };
    }

    @FXML
    private EventHandler<ActionEvent> setMove2() {
        return event -> {
            hero.setMoveStrategy(new RunStrategy());
            outputText.setText(hero.move());
        };
    }

    @FXML
    private EventHandler<ActionEvent> setMove3() {
        return event -> {
            hero.setMoveStrategy(new HorseStrategy());
            outputText.setText(hero.move());
        };
    }

    @FXML
    private EventHandler<ActionEvent> setMove4() {
        return event -> {
            hero.setMoveStrategy(new PortalStrategy());
            outputText.setText(hero.move());
        };
    }
}
