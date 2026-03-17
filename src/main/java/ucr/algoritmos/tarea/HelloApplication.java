package ucr.algoritmos.tarea;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ucr/algoritmos/tarea/juego.fxml"));
        Scene scene = new Scene(loader.load(), 900, 650);

        stage.setScene(scene);
        stage.setTitle("Adivina el personaje");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
