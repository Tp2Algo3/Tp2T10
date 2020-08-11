package LayoutsUI;

import LayoutsUI.Botones.BotonContinuar;
import LayoutsUI.Boxes.JugadoresConSusPuntajes;
import LayoutsUI.Boxes.ModificadoresPuntajeBox;
import LayoutsUI.Boxes.PreguntaBox;
import LayoutsUI.Boxes.RespuestasBox;
import Preguntas.Pregunta;
import Jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PreguntaYRespuesta{

    public static StackPane getLayout(Pregunta pregunta, ArrayList<Jugador> jugadores, Jugador jugadorActual){
        StackPane layout = new StackPane();
        VBox base_layout = new VBox();

        HBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        HBox panelPregunta = new PreguntaBox(pregunta.getContenido());
        VBox panelRespuestas = new RespuestasBox(pregunta.getRespuestas(), jugadorActual);
        Button botonEnviar = new BotonContinuar("Enviar Respuestas");
        HBox panelMultiplicadores = new ModificadoresPuntajeBox(jugadorActual, pregunta);

        base_layout.getChildren().add(jugadores_box);
        base_layout.getChildren().add(panelPregunta);
        base_layout.getChildren().add(panelRespuestas);
        base_layout.getChildren().add(botonEnviar);
        base_layout.getChildren().add(panelMultiplicadores);
        base_layout.setSpacing(40);
        base_layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(base_layout);

        return layout;
    }

}
