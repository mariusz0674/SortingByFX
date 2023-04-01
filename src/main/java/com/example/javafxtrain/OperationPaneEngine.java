package com.example.javafxtrain;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class OperationPaneEngine {

    Rectangle[] rectangleSegments;
    Pane operationPane;
    private double paneWidth;
    private double paneHeight;

    public Integer maxValue;
    public Integer arrSize;

    private Double rectangleWidth;
    private Double rectangleHeightPerValue;
    public OperationPaneEngine(Pane operationPane) {
        this.operationPane = operationPane;

    }

    public void initPane(Integer maxValue, Integer arrSize, ListToSort arrToDisp){
        this.paneWidth = operationPane.getWidth();
        this.paneHeight = operationPane.getHeight()-100;
        this.maxValue = maxValue;
        this.arrSize = arrSize;
        this.rectangleWidth = paneWidth / (double)arrSize;
        Double segmentWidth = paneWidth/arrSize-1;
        rectangleHeightPerValue = paneHeight / maxValue;
        rectangleSegments = new Rectangle[arrSize];
        for(int i = 0; i < arrSize; i++){
            rectangleSegments[i] = new Rectangle(i*this.rectangleWidth, paneHeight - arrToDisp.get(i)*rectangleHeightPerValue, segmentWidth, arrToDisp.get(i)*rectangleHeightPerValue);
        //    rectangleSegments[i].setFill(Color.BLACK);
            operationPane.getChildren().add(rectangleSegments[i]);
        }

    }

    public void displayNewArray(ListToSort toDisp, Integer maxValue, Integer arrSize){
        if(this.arrSize != null){
            for(int i = 0; i < this.arrSize; i++){
                operationPane.getChildren().remove(rectangleSegments[i]);
            }
        }
         initPane(maxValue, arrSize, toDisp);
    }
    public void syncRectangles(ListToSort listToDisplay){
        for(int i = 0; i < arrSize; i++){
            rectangleSegments[i].setHeight(listToDisplay.get(i)*rectangleHeightPerValue);
            rectangleSegments[i].setY(paneHeight - listToDisplay.get(i)*rectangleHeightPerValue);
        }
        //rectangleSegments[0].setFill(Color.PINK);
    }
    public void stepForInsertiondrow(Integer i, ListToSort listToDisplay ){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[i].setFill(Color.RED);
                rectangleSegments[i].setHeight(listToDisplay.get(i)*rectangleHeightPerValue);
                rectangleSegments[i].setY(paneHeight - listToDisplay.get(i)*rectangleHeightPerValue);
            }
        });

    }
    public void markPossition(Integer i){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[i].setFill(Color.RED);
            }
        });

    }

    public void doFirstStepInsertion(Integer i){
        Platform.runLater(new Runnable() {
            public void run() {
               // rectangleSegments[i].setFill(Color.BLUE);
                rectangleSegments[i].setHeight(0);
            }
        });

    }
    public void doThirdStepInsertion(ListToSort listToSort, Integer i){
        Platform.runLater(new Runnable() {
            public void run() {
                // rectangleSegments[i].setFill(Color.BLUE);
                rectangleSegments[i].setHeight(listToSort.get(i));
            }
        });
    }

    public void refreshSegment(ListToSort listToDisplay, Integer i){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[i].setHeight(listToDisplay.get(i)*rectangleHeightPerValue);
                rectangleSegments[i].setY(paneHeight - listToDisplay.get(i)*rectangleHeightPerValue);

            }
        });

    }

    public void markCompare(Integer leftPos, Integer rightPos){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[leftPos].setFill(Color.BLUE);
                rectangleSegments[rightPos].setFill(Color.YELLOW);
            }
        });


    }
    public void reMarkCompare(Integer leftPos, Integer rightPos){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[leftPos].setFill(Color.BLACK);
                rectangleSegments[rightPos].setFill(Color.BLACK);
            }
        });
    }
    public void markSwap(Integer leftPoss, Integer rightPoss){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[leftPoss].setFill(Color.ORANGE);
                rectangleSegments[rightPoss].setFill(Color.BLUE);
            }
        });
    }
    public void reMarkSwap(Integer leftPoss, Integer rightPoss){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[leftPoss].setFill(Color.BLACK);
                rectangleSegments[rightPoss].setFill(Color.BLACK);
            }
        });
    }
    public void drowSwap(ListToSort listToDisplay, Integer leftPoss, Integer rightPoss){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[rightPoss].setHeight(listToDisplay.get(rightPoss)*rectangleHeightPerValue);
                rectangleSegments[rightPoss].setY(paneHeight - listToDisplay.get(rightPoss)*rectangleHeightPerValue);
                rectangleSegments[leftPoss].setHeight(listToDisplay.get(leftPoss)*rectangleHeightPerValue);
                rectangleSegments[leftPoss].setY(paneHeight - listToDisplay.get(leftPoss)*rectangleHeightPerValue);
            }
        });

    }
    public void drowSwapToFinalPoss(ListToSort listToDisplay, Integer leftPoss, Integer rightPoss){
        drowSwap(listToDisplay, leftPoss, rightPoss);
        rectangleSegments[rightPoss].setFill(Color.GREEN);
    }
    public void markFinalPoss(Integer finalPoss){
        Platform.runLater(new Runnable() {
            public void run() {
                rectangleSegments[finalPoss].setFill(Color.GREEN);
            }
        });
    }

    public void drowPane(ListToSort listToDisplay){
        syncRectangles(listToDisplay);
    }

    public void addObject(){
        Text text = new Text("Penis");
        text.setX(50);
        text.setY(50);
        operationPane.getChildren().add(text);



     //   drowPane();
    }

}
