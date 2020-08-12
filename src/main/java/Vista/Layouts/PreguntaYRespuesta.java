package Vista.Layouts;

import Modelo.Turnos.Temporizador;
import Vista.Botones.BotonContinuar;
import Vista.Boxes.JugadoresConSusPuntajes;
import Vista.Boxes.ModificadoresPuntajeBox;
import Vista.Boxes.PreguntaBox;
import Vista.Boxes.RespuestasBox;
import Vista.Timer.TimerBox;
import Modelo.Preguntas.Pregunta;
import Modelo.Preguntas.PreguntaGroupChoice;
import Modelo.Jugador.Jugador;
import Modelo.Preguntas.PreguntaOrderedChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PreguntaYRespuesta{

    public static StackPane getLayout(Pregunta pregunta, ArrayList<Jugador> jugadores, Jugador jugadorActual, Temporizador temporizador){

        // Esto hay que cambiarlo
        if (pregunta.getClass() == PreguntaOrderedChoice.class) {
            return LayoutOrderedChoice.getLayout(pregunta, jugadores, jugadorActual, temporizador);
        }
        if (pregunta.getClass() == PreguntaGroupChoice.class) {
            return LayoutGroupChoice.getLayout((PreguntaGroupChoice) pregunta, jugadores, jugadorActual, temporizador);
        }

        StackPane layout = new StackPane();
        VBox base_layout = new VBox();

        HBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        TimerBox tiempo_box = new TimerBox(temporizador);
        HBox panelPregunta = new PreguntaBox(pregunta.getContenido());
        VBox panelRespuestas = new RespuestasBox(pregunta.getRespuestas(), jugadorActual);
        Button botonEnviar = new BotonContinuar("Enviar Respuestas");
        HBox panelMultiplicadores = new ModificadoresPuntajeBox(jugadorActual, pregunta);

        base_layout.getChildren().add(jugadores_box);
        base_layout.getChildren().add(tiempo_box);

        base_layout.getChildren().add(panelPregunta);
        base_layout.getChildren().add(panelRespuestas);
        base_layout.getChildren().add(botonEnviar);
        base_layout.getChildren().add(panelMultiplicadores);
        base_layout.setSpacing(40);
        base_layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(base_layout);

        tiempo_box.arrancar();

        return layout;
    }

}
