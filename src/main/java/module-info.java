module com.example.javafxtrain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxtrain to javafx.fxml;
    exports com.example.javafxtrain;
}