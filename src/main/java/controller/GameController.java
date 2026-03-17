package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Juego;

public class GameController {

    @FXML private Label lblPista;
    @FXML private TextField txtRespuesta;
    @FXML private Label lblResultado;
    @FXML private Label lblVidas;
    @FXML private Label lblPuntaje;

    private Juego juego;
    private int intento = 0;

    @FXML
    public void initialize() {
        juego = new Juego(false);
        actualizarUI();
    }

    @FXML
    private void handleAdivinar() {
        String respuesta = txtRespuesta.getText();

        if (respuesta.isEmpty()) {
            lblResultado.setText("⚠️ Escribe algo");
            return;
        }

        if (juego.verificarRespuestas(respuesta)) {
            lblResultado.setText("✅ ¡Correcto!");
            intento = 0;
        } else {
            lblResultado.setText("❌ Incorrecto");
            intento++;
        }

        actualizarUI();

        if (juego.getVidas() == 0) {
            lblResultado.setText("💀 Game Over");
        }

        txtRespuesta.clear();
    }


    @FXML
    public void handleFacil(ActionEvent event) {
        juego = new Juego(false);
        intento = 0;
        lblResultado.setText("Modo Fácil");
        actualizarUI();
    }

    @FXML
    public void handleDificil(ActionEvent event) {
        juego = new Juego(true);
        intento = 0;
        lblResultado.setText("Modo Difícil");
        actualizarUI();
    }

    private void actualizarUI() {
        lblPista.setText(juego.obtenerPista(intento));
        lblVidas.setText("❤️ Vidas: " + juego.getVidas());
        lblPuntaje.setText("⭐ Puntaje: " + juego.getPuntaje());
    }
}