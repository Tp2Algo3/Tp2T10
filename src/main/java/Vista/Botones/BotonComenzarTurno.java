package Vista.Botones;

import Controladores.AvanzarTurnoEventHandler;
import Modelo.Jugador.Jugador;
import Modelo.Preguntas.Pregunta;
import Modelo.Turnos.Temporizador;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class BotonComenzarTurno extends Button {
    public BotonComenzarTurno(Jugador jugadorTurno, ArrayList<Jugador> jugadores, Pregunta preguntaActual, Temporizador temporizador){
        super("Comenzar Turno");
        setOnAction(new AvanzarTurnoEventHandler(jugadorTurno, jugadores, preguntaActual, temporizador));
    }
}
