package Controladores;

import Preguntas.PreguntaVerdaderoOFalso;
import Puntajes.PuntajeClasico;
import Respuestas.Respuesta;
import Respuestas.RespuestaCorrecta;
import Respuestas.RespuestaIncorrecta;
import Jugador.Jugador;
import App.KahootApp;
import LayoutsUI.PreguntaYRespuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
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

        /*CAMBIARLO, ES TENTATIVO.
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(new RespuestaCorrecta("Verdadero"));
        respuestasPosibles.add(new RespuestaIncorrecta("Falso"));
        PreguntaVerdaderoOFalso VoF = new PreguntaVerdaderoOFalso(new PuntajeClasico(), respuestasPosibles,"Es este el mejor K!?");


        KahootApp.getStage().getScene().setRoot(PreguntaYRespuesta.getLayout(VoF, respuestasPosibles, jugadores));
        */
    }
}
