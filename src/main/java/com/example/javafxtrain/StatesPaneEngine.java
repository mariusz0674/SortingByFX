package com.example.javafxtrain;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class StatesPaneEngine {
    private Pane statesPane;

    private Integer speedIndicator;
    private Integer comparesCounter;
    private Integer swapsCounter;
    private String algoritmName;
    @FXML
    private Label statesSize;
    @FXML
    private Label statesSpeed;
    @FXML
    private Label statesCompares;
    @FXML
    private Label statesSwaps;
    @FXML
    private Label statesAlgorytmName;

    public StatesPaneEngine(Pane _statesPane){
        this.statesPane = _statesPane;
        speedIndicator = 0;
        comparesCounter = 0;
        swapsCounter = 0;
        algoritmName = " ";
        statesSize = (Label) statesPane.lookup("#statesSize");
        statesSpeed = (Label) statesPane.lookup("#statesSpeed");
        statesCompares = (Label) statesPane.lookup("#statesCompares");
        statesSwaps = (Label) statesPane.lookup("#statesSwaps");
        statesAlgorytmName = (Label) statesPane.lookup("#statesAlgorytmName");

    }

    public void setStatesSpeed(Integer speed){
        Platform.runLater(new Runnable() {
            public void run() {
                statesSpeed.setText(String.valueOf(speed));
            }
        });
    }
    public void incStatesCompares(){
        comparesCounter++;
        Platform.runLater(new Runnable() {
            public void run() {
                statesCompares.setText("Compares Number: " + comparesCounter);
            }
        });
    }
    public void incStatesSwaps(){
        swapsCounter++;
        Platform.runLater(new Runnable() {
            public void run() {
                statesSwaps.setText("Swaps number: " + swapsCounter);
            }
        });
    }
    public void setStatesAlgoritmName(String _algoritmName){
        algoritmName = _algoritmName;
        Platform.runLater(new Runnable() {
            public void run() {
                statesAlgorytmName.setText(algoritmName);
            }
        });
    }
}
