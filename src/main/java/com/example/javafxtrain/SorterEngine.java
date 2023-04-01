package com.example.javafxtrain;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class SorterEngine {
    Sorter sorter;
    public enum SortingType {
        BubbleSort, SelectionSort, InsertionSort
    }

    public SortingType SelectedSortingType;
    private OperationPaneEngine operationPaneEngine;

    private StatesPaneEngine statesPaneEngine;

  //  private Boolean isSortingRunning;
    protected Integer arraySize;
    protected Integer maxValue;
    public ListToSort listToSort;

    public Thread sortingThread;

    public SorterEngine(OperationPaneEngine operationPane, StatesPaneEngine statesPaneEngine) throws NullPointerException{
        this.operationPaneEngine = operationPane;
        this.statesPaneEngine = statesPaneEngine;
        this.arraySize = 100;
        this.maxValue = 100;
        this.SelectedSortingType = SortingType.BubbleSort;
        listToSort = new ListToSort();
        sortingThread = new Thread(() -> sorter.startSorting(), "SortingThread");
        /* ///////////////////// */
       // this.sorter = new BubbleSort(operationPane, arraySize, maxValue, listToSort, 10);

    }
    public void initialNewSorter(Integer arraySize, Integer maxValue, SortingType sortingTypepe ){
        this.arraySize = arraySize;
        if(maxValue == null) {
            this.maxValue = 100;
        } else  {
            this.maxValue = maxValue;
        }
        generateArray();
        this.sorter = new BubbleSort(operationPaneEngine, statesPaneEngine, arraySize, maxValue, listToSort, 10);

       // operationPane.initPane(maxValue, arraySize);


    }
    private Sorter createProperSorter(){


        switch (SelectedSortingType){
            case BubbleSort -> {
                return new BubbleSort(operationPaneEngine, statesPaneEngine, arraySize, maxValue, listToSort, 10);
            }
            case SelectionSort -> {
                return new SelectionSort(operationPaneEngine, statesPaneEngine, arraySize, maxValue, listToSort, 10);
            }
            case InsertionSort -> {
                return new InsertionSort(operationPaneEngine, statesPaneEngine, arraySize, maxValue, listToSort, 10);
            }
        }
        return null;
    }

    public void generateNewArray(){
        generateArray();
        if(sorter == null){
            this.sorter = createProperSorter();
        }else{
            sorter.changeArray(arraySize,maxValue,listToSort);
        }

    }

    public void generateArray(){
        Random generator = new Random();
        listToSort = new ListToSort();
        for(int i = 0; i < arraySize; i++){
            listToSort.add(generator.nextInt(maxValue));
        }
        operationPaneEngine.displayNewArray(listToSort, maxValue, arraySize);


      //  sorter.changeArray(arraySize,maxValue,listToSort);
    }

    public void testSortingDisplay() throws NullPointerException{
        sortingThread.start();
    }
    public void changeArraySize(Integer newSize){
        this.arraySize = newSize;
        //initialNewSorter(arraySize, maxValue, SortingType.BubbleSort);
        generateNewArray();
        sortingThread.stop();
        sortingThread = new Thread(() -> sorter.startSorting(), "SortingThread");

    }
    public void changeArrayMaxValue(Integer newMaxVal){
        this.maxValue = newMaxVal;
    }
    public void changeMaxValue(Integer newMaxValue){
        this.maxValue = newMaxValue;
    }

    public void changesimulationStepTime(Integer simulationStepTime){
        sorter.changeSimulationStepTime(simulationStepTime);
    }
    public void stopSortingProcess() {
        sortingThread.stop();

    }
    public void changeSelectedSorter(SortingType newType){
        this.sorter = null;
        this.SelectedSortingType = newType;
        //generateNewArray();
    }
}
