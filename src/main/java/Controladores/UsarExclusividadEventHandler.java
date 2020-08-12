package Controladores;


import Modelo.Jugador.Jugador;
import Modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class UsarExclusividadEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private Pregunta pregunta;
    private Button boton;

    public UsarExclusividadEventHandler(Jugador jugador, Pregunta pregunta, Button boton){
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        jugador.utilizarExclusividad(pregunta);
        boton.setDisable(true);
    }
}
