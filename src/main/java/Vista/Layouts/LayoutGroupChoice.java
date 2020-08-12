package Vista.Layouts;

import java.util.ArrayList;

import Modelo.Jugador.Jugador;
import Modelo.Turnos.Temporizador;
import Vista.Botones.BotonContinuar;
import Vista.Botones.BotonRespuestaGrupo;
import Vista.Boxes.JugadoresConSusPuntajes;
import Vista.Boxes.ModificadoresPuntajeBox;
import Vista.Boxes.PreguntaBox;
import Modelo.Respuestas.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import Modelo.Preguntas.PreguntaGroupChoice;
import Modelo.Grupo.*;
import Vista.Boxes.*;

public class LayoutGroupChoice {

    public static StackPane getLayout(PreguntaGroupChoice pregunta, ArrayList<Jugador> jugadores, Jugador jugadorActual, Temporizador temporizador) {
        StackPane layout = new StackPane();
        VBox base_layout = new VBox();
                
        HBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        HBox panelPregunta = new PreguntaBox(pregunta.getContenido());
        
        HBox panelGrupos = new HBox();
        for(Grupo grupito : pregunta.getGrupos()) {
            GrupoVBox panelGrupo = new GrupoVBox(grupito);
            panelGrupos.getChildren().add(panelGrupo);
        }
        panelGrupos.setSpacing(100);
        panelGrupos.setAlignment(Pos.CENTER);

        HBox panelRespuestas = new HBox();
        for (Respuesta respuesta : pregunta.getRespuestas()) {
            Button boton = new BotonRespuestaGrupo(respuesta, jugadorActual, panelRespuestas);
            panelRespuestas.getChildren().add(boton);
        }
        double alturaActual = panelRespuestas.getHeight();
        double anchoActual = panelRespuestas.getWidth();
        panelRespuestas.setSpacing(5);
        panelRespuestas.setMinSize(anchoActual, alturaActual);
        panelRespuestas.setAlignment(Pos.CENTER);
       
        Button botonEnviar = new BotonContinuar("Enviar Respuestas");
        HBox panelMultiplicadores = new ModificadoresPuntajeBox(jugadorActual, pregunta);

        
        base_layout.getChildren().add(jugadores_box);
        base_layout.getChildren().add(panelPregunta);
        base_layout.getChildren().add(panelRespuestas);
        base_layout.getChildren().add(panelGrupos);
        base_layout.getChildren().add(botonEnviar);
        base_layout.getChildren().add(panelMultiplicadores);
        base_layout.setSpacing(20);
        base_layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(base_layout);

        return layout;
    }
}
