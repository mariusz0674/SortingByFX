package com.example.javafxtrain;

public class BubbleSort extends Sorter {

    public BubbleSort(OperationPaneEngine operationPane, StatesPaneEngine statesPaneEngine, Integer arraySize, Integer maxValue, ListToSort listToSort, Integer simulationStepTime) {
        super(operationPane, statesPaneEngine, arraySize, maxValue, listToSort, simulationStepTime);
    }


    @Override
    public void startSorting(){
        boolean swaped = false;
        for(int i = 0; i < arraySize-1; i++){
            for(int j = 0; j < arraySize-i-1; j++){
/*                operationPane.markCompare(j, j+1);
                statesPaneEngine.incStatesCompares();
                pauseSorting(100);
                operationPane.reMarkCompare(j, j+1);*/
                drawCompare(j,j+1);
                if(listToSort.get(j) > listToSort.get(j+1)) {
                    doDrawSwap(j, j+1);
/*                    operationPane.markSwap(j, j + 1);
                    statesPaneEngine.incStatesSwaps();
                    listToSort.swap(j, j + 1);
                    operationPane.drowSwap(listToSort, j, j + 1);
                    pauseSorting(100);
                    operationPane.reMarkSwap(j, j + 1);*/

                }

            }
            operationPane.markFinalPoss(arraySize - i-1);


        }

    }
}
