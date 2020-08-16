package Vista.Layouts;

import java.util.ArrayList;

import Modelo.Jugador.Jugador;
import Modelo.Turnos.Temporizador;
import Vista.Botones.BotonContinuar;
import Vista.Botones.BotonRespuestaOrdenada;
import Vista.Boxes.JugadoresConSusPuntajes;
import Vista.Boxes.ModificadoresPuntajeBox;
import Vista.Boxes.PreguntaBox;
import Modelo.Preguntas.Pregunta;
import Modelo.Respuestas.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LayoutOrderedChoice {

    public static StackPane getLayout(Pregunta pregunta, ArrayList<Jugador> jugadores, Jugador jugadorActual, Temporizador temporizador) {
        
        StackPane layout = new StackPane();
        VBox base_layout = new VBox();

        HBox respuestasOrdenadas = new HBox();
        respuestasOrdenadas.setSpacing(20);
        respuestasOrdenadas.setAlignment(Pos.CENTER);

        VBox panelRespuestas = new VBox();
        panelRespuestas.setSpacing(25);
        panelRespuestas.setAlignment(Pos.CENTER);

        for (Respuesta respuesta : pregunta.getRespuestas()) {
            Button botonRespOrdenada = new BotonRespuestaOrdenada(respuesta, jugadorActual, respuestasOrdenadas,
                    panelRespuestas);
            panelRespuestas.getChildren().add(botonRespOrdenada);
        }
       
        VBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        VBox panelPregunta = new PreguntaBox(pregunta);
        Button botonEnviar = new BotonContinuar("Enviar Respuestas");
        HBox panelMultiplicadores = new ModificadoresPuntajeBox(jugadorActual, pregunta);


        base_layout.getChildren().addAll(jugadores_box,panelPregunta, respuestasOrdenadas, panelRespuestas, botonEnviar, panelMultiplicadores);
        base_layout.setSpacing(40);
        base_layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(base_layout);
        layout.setStyle("-fx-background-color: #fdf9e1");

        return layout;
    }
}
