package LayoutsUI;

import java.util.ArrayList;

import Jugador.Jugador;
import LayoutsUI.Botones.BotonContinuar;
import LayoutsUI.Botones.BotonRespuestaOrdenada;
import LayoutsUI.Boxes.JugadoresConSusPuntajes;
import LayoutsUI.Boxes.ModificadoresPuntajeBox;
import LayoutsUI.Boxes.PreguntaBox;
import LayoutsUI.Boxes.RespuestasBox;
import Preguntas.Pregunta;
import Respuestas.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LayoutOrderedChoice {

    public static StackPane getLayout(Pregunta pregunta, ArrayList<Jugador> jugadores, Jugador jugadorActual) {
        
        StackPane layout = new StackPane();
        VBox base_layout = new VBox();

        HBox respuestasOrdenadas = new HBox();
        respuestasOrdenadas.setSpacing(20);
        respuestasOrdenadas.setAlignment(Pos.BOTTOM_CENTER);
        respuestasOrdenadas.setPrefSize(300, 100);

        VBox panelRespuestas = new VBox();
        panelRespuestas.setSpacing(25);
        panelRespuestas.setAlignment(Pos.CENTER);

        for (Respuesta respuesta : pregunta.getRespuestas()) {
            Button botonRespOrdenada = new BotonRespuestaOrdenada(respuesta, jugadorActual, respuestasOrdenadas,
                    panelRespuestas);
            panelRespuestas.getChildren().add(botonRespOrdenada);
        }
       
        HBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        HBox panelPregunta = new PreguntaBox(pregunta.getContenido());
        // VBox panelRespuestas = new RespuestasBox(pregunta.getRespuestas(), jugadorActual);
        Button botonEnviar = new BotonContinuar("Enviar Respuestas");
        HBox panelMultiplicadores = new ModificadoresPuntajeBox(jugadorActual, pregunta);

        
        base_layout.getChildren().add(jugadores_box);
        base_layout.getChildren().add(panelPregunta);
        base_layout.getChildren().add(respuestasOrdenadas);
        base_layout.getChildren().add(panelRespuestas);
        base_layout.getChildren().add(botonEnviar);
        base_layout.getChildren().add(panelMultiplicadores);
        base_layout.setSpacing(40);
        base_layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(base_layout);

        return layout;
    }
}
