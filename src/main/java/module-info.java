module ucr.algoritmos.tarea {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ucr.algoritmos.tarea to javafx.fxml;
    exports ucr.algoritmos.tarea;
    exports controller;
    opens controller to javafx.fxml;
}