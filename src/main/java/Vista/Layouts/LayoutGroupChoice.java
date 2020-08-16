package Vista.Layouts;

import java.util.ArrayList;

import Modelo.Jugador.Jugador;
import Modelo.Respuestas.RespuestaGroup;
import Modelo.Turnos.Temporizador;
import Vista.Botones.BotonContinuar;
import Vista.Botones.BotonRespuestaGrupo;
import Vista.Boxes.JugadoresConSusPuntajes;
import Vista.Boxes.ModificadoresPuntajeBox;
import Vista.Boxes.PreguntaBox;
import Modelo.Respuestas.Respuesta;
import Vista.Timer.TimerBox;
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
                
        VBox jugadores_box = new JugadoresConSusPuntajes(jugadores);
        VBox panelPregunta = new PreguntaBox(pregunta);
        
        HBox panelGrupos = new HBox();
        for(Grupo grupito : pregunta.getGrupos()) {
            GrupoVBox panelGrupo = new GrupoVBox(grupito);
            panelGrupos.getChildren().add(panelGrupo);
        }
        panelGrupos.setSpacing(100);
        panelGrupos.setAlignment(Pos.CENTER);

        HBox panelRespuestas = new RespuestasGroupChoiceBox(pregunta.getRespuestas(), jugadorActual);
       
        Button botonEnviar = new BotonContinuar("Enviar Respuestas");
        HBox panelMultiplicadores = new ModificadoresPuntajeBox(jugadorActual, pregunta);
        TimerBox timerBox = new TimerBox(temporizador);

        base_layout.getChildren().addAll(jugadores_box,panelPregunta, timerBox, panelRespuestas, panelGrupos, botonEnviar, panelMultiplicadores);
        base_layout.setSpacing(20);
        base_layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(base_layout);
        layout.setStyle("-fx-background-color: #fdf9e1");

        timerBox.arrancar();

        return layout;
    }
}
