package com.codedotorg;

import java.util.Arrays;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuessingGame {

    private Stage window;
    private int width;
    private int height;
    private Label computerGuessLabel;
    private GameLogic logic;

    public GuessingGame(Stage primaryStage, int width, int height) {
        this.window = primaryStage;
        window.setTitle("Guessing Game");
        this.width = width;
        this.height = height;
        computerGuessLabel = new Label(""); 
        logic = new GameLogic();       
    }
    
    public void startGame() {
        VBox mainLayout = createLayout();
        Scene mainScene = new Scene(mainLayout, width, height);
        window.setScene(mainScene);
        window.show();
    }

    public void setComputerGuessLabel(boolean result) {
        if (result) {
            computerGuessLabel.setText("I guessed the correct number " + logic.getGuess() + " in " + logic.getNumGuesses() + " guesses.");
        } else {
            computerGuessLabel.setText("My guess is " + logic.getGuess());
        }
    }

    public VBox createLayout() {
        VBox tempLayout = new VBox(10);

        Label promptLabel = new Label("Think of a number between 1-100.");
        setComputerGuessLabel(false);

        Button higherButton = new Button("Higher");
        Button lowerButton = new Button("Lower");
        Button correctButton = new Button("Correct");

        List<Node> buttonsList = Arrays.asList(higherButton, lowerButton, correctButton);

        higherButton.setOnAction(event -> {
            logic.guessHigher();
            setComputerGuessLabel(false);
        });

        lowerButton.setOnAction(event -> {
            logic.guessLower();
            setComputerGuessLabel(false);
        });

        correctButton.setOnAction(event -> {
            setComputerGuessLabel(true);
            for (Node btn : buttonsList) {
                ((Button)btn).setDisable(true);
            }
        });

        tempLayout.getChildren().addAll(promptLabel, computerGuessLabel);
        tempLayout.getChildren().addAll(buttonsList);

        return tempLayout;
    }
}
