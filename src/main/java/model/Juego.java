package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Juego {

    private HashMap<String, Personaje> personajes = new HashMap<>();
    private  Personaje personajeActual;
    private int vidas = 3;
    private int puntaje = 0;
    private boolean dificil;

    public Juego(boolean dificil) {
        this.dificil = dificil;
        cargarPersonajes();
        seleccionarPersonajeAleatorio();
    }

    private void cargarPersonajes(){

        personajes.put("Mario" , new Personaje("Mario",
            List.of("Es un fontanero", "Lleva una gorra roja", "Esta en videojuegos de Nintendo"),
            List.of("Es el hermano de Luigi", "Tiene un bigote característico", "Rescata a una princesa")));

        personajes.put("Luigi" , new Personaje("Luigi",
            List.of("Es un fontanero", "Lleva una gorra verde", "Esta en videojuegos de Nintendo"),
            List.of("Es el hermano de Mario", "Tiene un bigote característico", "Rescata a una princesa")));

        personajes.put("Batman", new Personaje(
                "Batman",
                List.of("Es un superhéroe", "Usa traje negro", "Vive en Gotham"),
                List.of("No tiene poderes", "Es millonario", "Tiene un mayordomo")
        ));

        personajes.put("Superman", new Personaje(
                "Superman",
                List.of("Es un superhéroe", "Usa traje azul y rojo", "Viene de otro planeta"),
                List.of("Tiene super fuerza", "Puede volar", "Es vulnerable a la kryptonita")
        ));

        personajes.put("Harry Potter", new Personaje(
                "Harry Potter",
                List.of("Es un mago", "Usa gafas redondas", "Tiene una cicatriz en forma de rayo"),
                List.of("Asiste a Hogwarts", "Tiene una varita mágica", "Es el niño que vivió")
        ));

        personajes.put("Hulk", new Personaje(
                "Hulk",
                List.of("Es un superhéroe", "Tiene piel verde", "Se transforma cuando se enoja"),
                List.of("Su nombre real es Bruce Banner", "Es parte de los Avengers", "Tiene una fuerza increíble")
        ));

        personajes.put("Pochita" , new Personaje("Pochita",
            List.of("Es un demonio perro", "Tiene una motosierra en la cabeza", "Aparece en el manga Chainsaw Man"),
            List.of("Es el mejor amigo de Denji", "Puede transformarse en motosierra", "Es un personaje muy querido por los fans")
        ));

        personajes.put("Tanjiro", new Personaje(
            "Tanjiro",
            List.of("Es un cazador de demonios", "Lleva un kimono a cuadros", "Aparece en el anime Demon Slayer"),
            List.of("Tiene un sentido del olfato muy desarrollado", "Es muy amable y compasivo", "Busca una cura para su hermana Nezuko")
        ));

        personajes.put("Nezuko", new Personaje(
            "Nezuko",
            List.of("Es una demonio", "Hermana de Tanjiro", "Aparece en el anime Demon Slayer"),
            List.of("Tiene la capacidad de encogerse", "No puede hablar", "Es muy protectora con su hermano")
        ));
    }

    public void seleccionarPersonajeAleatorio(){

        List<Personaje> lista = new ArrayList<>(personajes.values());
        Random random = new Random();
        personajeActual = lista.get(random.nextInt(lista.size()));

    }

    public String obtenerPista(int intento){

        List<String> pistas = personajeActual.getPistas(dificil);
        if (intento < pistas.size()) {
            return pistas.get(intento);
        }
        return "No hay más pistas disponibles.";

    }

    public boolean verificarRespuestas(String respuesta){

        if (respuesta.equalsIgnoreCase(personajeActual.getNombre())) {
            puntaje += 10;
            seleccionarPersonajeAleatorio();
            return true;
        } else {
            vidas--;
            return false;
        }
    }

    public int getVidas() {
        return vidas;
    }
    public int getPuntaje(){
        return puntaje;
    }

}
