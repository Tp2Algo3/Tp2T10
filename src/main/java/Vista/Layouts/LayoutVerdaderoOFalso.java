package Vista.Layouts;

import java.util.ArrayList;

import Modelo.Preguntas.Pregunta;
import Modelo.Turnos.Temporizador;
import Vista.Botones.BotonContinuar;
import Vista.Boxes.JugadoresConSusPuntajes;
import Vista.Boxes.ModificadoresPuntajeBox;
import Vista.Boxes.PreguntaBox;
import Vista.Boxes.RespuestasBox;
import Vista.Timer.TimerBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import Modelo.Jugador.Jugador;

public class LayoutVerdaderoOFalso {

    public static StackPane getLayout(Pregunta pregunta, ArrayList<Jugador>jugadores, Jugador jugadorActual, Temporizador temporizador){

        StackPane layout = new StackPane();
        VBox base_layout = new VBox();

        HBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        TimerBox tiempo_box = new TimerBox(temporizador);
        VBox panelPregunta = new PreguntaBox(pregunta);
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