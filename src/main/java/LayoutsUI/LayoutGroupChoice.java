package LayoutsUI;

import java.util.ArrayList;

import Controladores.DragDroppedEventHandler;
import Controladores.DragOverEventHandler;
import Jugador.Jugador;
import LayoutsUI.Botones.BotonContinuar;
import LayoutsUI.Botones.BotonRespuestaGrupo;
import LayoutsUI.Botones.BotonRespuestaOrdenada;
import LayoutsUI.Boxes.JugadoresConSusPuntajes;
import LayoutsUI.Boxes.ModificadoresPuntajeBox;
import LayoutsUI.Boxes.PreguntaBox;
import LayoutsUI.Boxes.RespuestasBox;
import Preguntas.Pregunta;
import Respuestas.Respuesta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import Preguntas.PreguntaGroupChoice;
import Puntajes.PuntajeClasico;
import Grupo.*;
import LayoutsUI.Boxes.*;

public class LayoutGroupChoice {

    public static StackPane getLayout(PreguntaGroupChoice pregunta, ArrayList<Jugador> jugadores, Jugador jugadorActual) {
        StackPane layout = new StackPane();
        VBox base_layout = new VBox();
                
        HBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        HBox panelPregunta = new PreguntaBox(pregunta.getContenido());
        
        HBox panelGrupos = new HBox();
        for(Grupo grupito : pregunta.getGrupos()) {
            GrupoVBox panelGrupo = new GrupoVBox(grupito);
            panelGrupo.setMinHeight(100);
            panelGrupo.setMinWidth(70);
            panelGrupo.setOnDragOver(new DragOverEventHandler(panelGrupo));
            panelGrupo.setOnDragDropped(new DragDroppedEventHandler(panelGrupo));
            panelGrupo.setBorder(new Border(new BorderStroke(Color.BLACK, 
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            panelGrupos.getChildren().add(panelGrupo);

        }
        panelGrupos.setSpacing(100);
        panelGrupos.setAlignment(Pos.CENTER);

        HBox panelRespuestas = new HBox();
        for (Respuesta respuesta : pregunta.getRespuestas()) {
            Button boton = new BotonRespuestaGrupo(respuesta, jugadorActual, panelRespuestas, panelGrupos);
            panelRespuestas.getChildren().add(boton);
        }
        panelRespuestas.setSpacing(5);
        panelRespuestas.setMinSize(330, 100);
        panelRespuestas.setAlignment(Pos.CENTER);
       
        Button botonEnviar = new BotonContinuar("Enviar Respuestas");
        HBox panelMultiplicadores = new ModificadoresPuntajeBox(jugadorActual, pregunta);

        
        base_layout.getChildren().add(jugadores_box);
        base_layout.getChildren().add(panelPregunta);
        base_layout.getChildren().add(panelRespuestas);
        base_layout.getChildren().add(panelGrupos);
        base_layout.getChildren().add(botonEnviar);
        base_layout.getChildren().add(panelMultiplicadores);
        base_layout.setSpacing(5);
        base_layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(base_layout);

        return layout;
    }
}
