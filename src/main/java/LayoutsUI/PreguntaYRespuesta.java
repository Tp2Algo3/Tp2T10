package LayoutsUI;

import Controladores.UpdateEventHandler;
import LayoutsUI.HBoxes.JugadoresConSusPuntajes;
import LayoutsUI.Labels.LabelPregunta;
import Preguntas.Pregunta;
import Respuestas.Respuesta;
import Controladores.AniadirRespuestaEventHandler;
import Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class PreguntaYRespuesta{

    public static StackPane getLayout(Pregunta pregunta, ArrayList<Jugador> jugadores, Jugador jugadorActual){
        StackPane layout = new StackPane();
        VBox base_layout = new VBox();
        HBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        base_layout.getChildren().add(jugadores_box);
        layout.getChildren().add(base_layout);

        HBox panelPregunta = new HBox();
        Label preguntaTexto = new LabelPregunta(pregunta.getContenido());

        panelPregunta.getChildren().add(preguntaTexto);
        panelPregunta.setAlignment(Pos.CENTER);
        base_layout.getChildren().add(panelPregunta);

        VBox panelRespuestas = new VBox();
        for (Respuesta respuesta: pregunta.getRespuestas()){
            Button boton = new Button(respuesta.getContenido());
            boton.setOnAction(new AniadirRespuestaEventHandler(boton, respuesta, jugadorActual));
            panelRespuestas.getChildren().add(boton);
        }
        panelRespuestas.setSpacing(25);
        panelRespuestas.setAlignment(Pos.CENTER);
        base_layout.getChildren().add(panelRespuestas);

        Button botonEnviar = new Button("Enviar Respuestas");
        botonEnviar.setOnAction(new UpdateEventHandler());
        base_layout.getChildren().add(botonEnviar);

        return layout;
    }

}
