package com.example.javafxtrain;

public class SelectionSort extends Sorter {
    public SelectionSort(OperationPaneEngine operationPane, StatesPaneEngine statesPaneEngine, Integer arraySize, Integer maxValue, ListToSort listToSort, Integer simulationStepTime) {
        super(operationPane, statesPaneEngine, arraySize, maxValue, listToSort, simulationStepTime);
    }

    @Override
    public void startSorting() {
        for (int i = 0; i < arraySize-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < arraySize; j++) {


                drawCompare(min_idx, j);
                if (listToSort.get(j) < listToSort.get(min_idx)) {
                    min_idx = j;

                }
            }
            doDrawSwap(min_idx, i);
            operationPane.markFinalPoss(i);
            //listToSort.swap(min_idx, i);
        }
    }


}
