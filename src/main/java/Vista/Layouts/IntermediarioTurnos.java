package Vista.Layouts;

import Modelo.Jugador.Jugador;
import Modelo.Preguntas.Pregunta;
import Modelo.Turnos.Temporizador;
import Vista.Botones.BotonComenzarTurno;
import Vista.Labels.LabelTurnoJugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class IntermediarioTurnos {

    public static StackPane getLayout(Jugador jugadorTurno, ArrayList<Jugador> jugadores, Pregunta preguntaActual, Temporizador temporizador){
        StackPane layout = new StackPane();
        VBox verticalBox = new VBox();
        Label turnoJugador = new LabelTurnoJugador(jugadorTurno);
        Button botonContinuar = new BotonComenzarTurno(jugadorTurno, jugadores, preguntaActual, temporizador);

        verticalBox.getChildren().addAll(turnoJugador, botonContinuar);
        verticalBox.setAlignment(Pos.CENTER);
        verticalBox.setSpacing(100);
        layout.getChildren().add(verticalBox);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #fdf9e1");
        return layout;
    }

}
