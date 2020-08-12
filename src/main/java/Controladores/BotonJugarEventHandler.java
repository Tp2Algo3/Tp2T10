package Controladores;

import Modelo.Jugador.Jugador;
import Vista.KahootApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {
    private final ArrayList<TextField>nombresJugadores;
    private ArrayList<Jugador> jugadores;

    public BotonJugarEventHandler(ArrayList<TextField> nombresJugadores) {
        this.nombresJugadores = nombresJugadores;
        this.jugadores = new ArrayList<>();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for (TextField nombreField: nombresJugadores){
            jugadores.add(new Jugador(nombreField.getText()));
        }
        KahootApp.iniciarJuego(jugadores);
        KahootApp.update();

        /*
        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(new RespuestaCorrecta("Verdadero"));
        respuestasPosibles.add(new RespuestaIncorrecta("Falso"));
        PreguntaVerdaderoOFalso VoF = new PreguntaVerdaderoOFalso(new PuntajeClasico(), respuestasPosibles,"Es este el mejor K!?");


        KahootApp.getStage().getScene().setRoot(PreguntaYRespuesta.getLayout(VoF, respuestasPosibles, jugadores));
        */
    }
}
