module ucr.algoritmos.tarea {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.algoritmos.tarea to javafx.fxml;
    exports ucr.algoritmos.tarea;
}