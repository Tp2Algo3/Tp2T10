package LayoutsUI;

import Controladores.UpdateEventHandler;
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

    public static StackPane getLayout(Pregunta pregunta, ArrayList<Respuesta> respuestas, ArrayList<Jugador> jugadores){
        StackPane layout = new StackPane();
        VBox base_layout = new VBox();
        HBox jugadores_box = new HBox();
        for (Jugador jugador: jugadores){
            Label label_j = new Label(jugador.getNombre() + ": " + jugador.getPuntos());
            jugadores_box.getChildren().add(label_j);
        }
        jugadores_box.setSpacing(600);
        jugadores_box.setAlignment(Pos.CENTER);
        base_layout.getChildren().add(jugadores_box);
        layout.getChildren().add(base_layout);

        HBox panelPregunta = new HBox();
        Label pregunta_texto = new Label(pregunta.getContenido());
        pregunta_texto.setFont(new Font("Arial", 20));
        pregunta_texto.setPadding(new Insets(100,0,100,0));
        panelPregunta.getChildren().add(pregunta_texto);
        panelPregunta.setAlignment(Pos.CENTER);
        base_layout.getChildren().add(panelPregunta);

        VBox panelRespuestas = new VBox();
        for (Respuesta respuesta: respuestas){
            Button boton = new Button(respuesta.getContenido());
            boton.setOnAction(new AniadirRespuestaEventHandler(boton, respuesta, jugadores.get(0)));
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
