package com.example.javafxtrain;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Pane operationPane;
    OperationPaneEngine operationPaneEngine;


    SorterEngine sorterEngine;

    StatesPaneEngine statesPaneEngine;

    @FXML
    private Label statesSize;
    @FXML
    private Label statusStatus;

    @FXML
    private Label statesSpeed;

    @FXML
    private ComboBox algorithmSelector;
    @FXML
    private Pane statesPane;
    @FXML
    private Label welcomeText;
    @FXML
    private  Label sizeLabel;
    @FXML
    private Label maxValueLabel;
    @FXML
    private Button changeMaxValue;
    @FXML
    private Button changeArraySize;
    @FXML
    private Button startSortingButton;
    @FXML
    private Slider maxValueSlider;
    @FXML
    private Slider arraySizeSlider;
    @FXML
    private Slider speedSlider;
    @FXML
    private Label statesAlgorytmName;
    @FXML
    private Label speedLabel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.operationPaneEngine = new OperationPaneEngine(this.operationPane);
        this.statesPaneEngine = new StatesPaneEngine(this.statesPane);
        this.sorterEngine = new SorterEngine(this.operationPaneEngine, this.statesPaneEngine);
        statesSize.setText("Array size: ");
        statesSpeed.setText("Speed: " );


        arraySizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sizeLabel.setText("Size: "+  (int) Math.pow(10.0, (Double) t1));
                statesSize.setText("Array size: " +  (int) Math.pow(10.0, (Double) t1));

            }
        });
     //   arraySizeSlider.valueProperty().addListener((obs, oldval, newVal) ->
     //           arraySizeSlider.setValue(newVal.intValue()));

        speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if(sorterEngine.sorter==null) return;
              //  speedLabel.setText("Speed: " + (int) Math.pow(10.0, (Double) t1));
                statesSpeed.setText("Speed: " +  (int) (1000/Math.pow(10.0, (Double) t1)));
                sorterEngine.changesimulationStepTime((int) (1000/Math.pow(10.0, (Double) t1)));
                //System.out.println((int) (1000/Math.pow(10.0, (Double) t1)));

            }
        });
        //algorithmSelector.
        //sorterEngine
        algorithmSelector.getItems().addAll(FXCollections
                .observableArrayList(getNames(SorterEngine.SortingType.class)));
    }
    //SorterEngine.SortingType)
    @FXML
    protected void penis() {
    //    Integer arraySize = 100;
     //   Integer maxValue = 100;
       // operationPaneEngine.initPane(maxValue, arraySize);
    }

    @FXML
    protected void onHelloButtonClick() {

        Integer arraySize = 1000;
        Integer maxValue = 100;


        SorterEngine.SortingType sortingTypepe = SorterEngine.SortingType.BubbleSort;
        sorterEngine.initialNewSorter(arraySize, maxValue, sortingTypepe);


    }
    @FXML
    protected void onGenerateNewArrayButtonClick(){
       // changeSelectedSorter()
      //  String value = (String) algorithmSelector.getValue();
        try{
            sorterEngine.changeSelectedSorter(SorterEngine.SortingType.valueOf((String) algorithmSelector.getValue()));
        }catch (NullPointerException ex){
            statusStatus.setText("Choose Sorting algorithm");
            return;
        }
        statusStatus.setText("Ready to sorting");
        sorterEngine.changeArrayMaxValue((int) maxValueSlider.getValue());
        sorterEngine.changeArraySize((int)Math.pow(10.0, arraySizeSlider.getValue()));

       // sorterEngine.generateNewArray();

    }
    @FXML
    protected void onStartSortingButtonClick(){
        if(sorterEngine.sorter == null){
            statusStatus.setText("Generate new data set");
            return;
        }

        statusStatus.setText("Sorting!!!");

        statesSpeed.setText("Speed: " + (int) (1000/Math.pow(10.0, (Double) speedSlider.getValue())));
        statesSize.setText("Size: "+Math.pow(10, arraySizeSlider.getValue()));
        statesAlgorytmName.setText(sorterEngine.SelectedSortingType.name());
        sorterEngine.testSortingDisplay();


    }

    @FXML
    protected void onMaxValueArrayChangeButtonClick(){

    }
    @FXML
    protected void onSpeedChangeButtonClick(){
        sorterEngine.changesimulationStepTime(0);
      //  System.out.println((int) speedSlider.getValue());
        // System.out.println((int)Math.pow(10.0, arraySizeSlider.getValue()));
    }
    @FXML
    protected void onStopSortingButtonClick() {
        sorterEngine.stopSortingProcess();
    }




    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}