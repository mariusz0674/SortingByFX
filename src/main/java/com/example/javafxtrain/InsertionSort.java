package com.example.javafxtrain;

public class InsertionSort extends Sorter {

    public InsertionSort(OperationPaneEngine operationPane, StatesPaneEngine statesPaneEngine, Integer arraySize, Integer maxValue, ListToSort listToSort, Integer simulationStepTime) {
        super(operationPane, statesPaneEngine, arraySize, maxValue, listToSort, simulationStepTime);
    }

    @Override
    public void startSorting() {
        int n = arraySize;
        for (int i = 1; i < n; ++i) {
            int key = listToSort.get(i);
          //  operationPane.markPossition(i);
            listToSort.set(i, 0);
            operationPane.refreshSegment(listToSort, i);

            // operationPane.doFirstStepInsertion(i);
            pauseSorting(100);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            statesPaneEngine.incStatesCompares();
            while (j >= 0 && listToSort.get(j) > key) {
                statesPaneEngine.incStatesCompares();
                //makeStep(j);
               // makeStep(j);
                doDrawSwap(j, j+1);
              //  listToSort[j + 1] = listToSort[j];
                j = j - 1;
            }
          //  listToSort.set(j + 1, key);
         //   operationPane.markFinalPoss(j);
            listToSort.set(j+1, key);
            operationPane.refreshSegment(listToSort, j+1);
            operationPane.markFinalPoss(j+1);


           // operationPane.doThirdStepInsertion(listToSort, i);
        }
    }

}
