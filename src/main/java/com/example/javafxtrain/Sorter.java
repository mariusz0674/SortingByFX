package com.example.javafxtrain;

import javafx.scene.layout.Pane;

public abstract class Sorter {
    protected OperationPaneEngine operationPane;
    protected Integer arraySize;
    protected Integer maxValue;
    protected ListToSort listToSort;

    protected  StatesPaneEngine statesPaneEngine;
    public Integer simulationStepTime;
    public Sorter(OperationPaneEngine operationPane, StatesPaneEngine statesPaneEngine, Integer arraySize, Integer maxValue, ListToSort listToSort, Integer simulationStepTime  ) {
        this.operationPane = operationPane;
        this.statesPaneEngine = statesPaneEngine;
        this.arraySize = arraySize;
        this.maxValue = maxValue;
        this.listToSort = listToSort;
        this.simulationStepTime = simulationStepTime;

    }


    public void changeArray(Integer arraySize, Integer maxValue, ListToSort listToSort){
        this.arraySize = arraySize;
        this.maxValue = maxValue;
        this.listToSort = listToSort;
    }
    public abstract void startSorting() throws NullPointerException;
    public void pauseSorting(Integer timeInMilSec){
        try {
            Thread.sleep(this.simulationStepTime);
          //  System.out.println("Peniss: " + this.simulationStepTime%10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public void drawCompare(Integer i, Integer j){
        operationPane.markCompare(i, j);
        statesPaneEngine.incStatesCompares();
        pauseSorting(100);
        operationPane.reMarkCompare(i, j);
    }
    public void doDrawSwap(Integer i, Integer j){
        operationPane.markSwap(i, j);
        statesPaneEngine.incStatesSwaps();
        listToSort.swap(i, j);
        operationPane.drowSwap(listToSort, i, j);
        pauseSorting(100);
        operationPane.reMarkSwap(i, j);

    }
    public void changeSimulationStepTime(Integer newTimeStop){
        this.simulationStepTime = newTimeStop;
    }

}
