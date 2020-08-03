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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {
    private Button botonJugar;

    public BotonJugarEventHandler(Button miBoton) {
        this.botonJugar = miBoton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        StackPane stackPane = new StackPane();
        VBox vbox = new VBox();
        stackPane.getChildren().add(vbox);

        //CAMBIARLO, ES TENTATIVO.
        Jugador jugador1 = new Jugador("Pepe");
        Jugador jugador2 = new Jugador("Jacinta");
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
