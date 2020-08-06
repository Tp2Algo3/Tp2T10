package Controladores;

import ClasesPreguntas.Preguntas.PreguntaVerdaderoOFalso;
import ClasesPreguntas.Puntajes.PuntajeClasico;
import ClasesPreguntas.Respuestas.Respuesta;
import ClasesPreguntas.Respuestas.RespuestaCorrecta;
import ClasesPreguntas.Respuestas.RespuestaIncorrecta;
import Jugador.Jugador;
import UI.KahootApp;
import UI.PreguntaYRespuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {
    private Button botonJugar;
    private TextField nombre_jug1;
    private TextField nombre_jug2;

    public BotonJugarEventHandler(Button miBoton, TextField nombre_jug1, TextField nombre_jug2) {
        this.botonJugar = miBoton;
        this.nombre_jug1 = nombre_jug1;
        this.nombre_jug2 = nombre_jug2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador1 = new Jugador(nombre_jug1.getText());
        Jugador jugador2 = new Jugador(nombre_jug2.getText());

        //CAMBIARLO, ES TENTATIVO.
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();
        respuestasPosibles.add(new RespuestaCorrecta("Verdadero"));
        respuestasPosibles.add(new RespuestaIncorrecta("Falso"));
        PreguntaVerdaderoOFalso VoF = new PreguntaVerdaderoOFalso(new PuntajeClasico(), respuestasPosibles,"Es este el mejor K!?");


        KahootApp.getStage().getScene().setRoot(PreguntaYRespuesta.getLayout(VoF, respuestasPosibles, jugadores));
    }
}
