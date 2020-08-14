package Controladores;

import Modelo.Jugador.Jugador;
import Modelo.Preguntas.Pregunta;
import Modelo.Turnos.Temporizador;
import Vista.KahootApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class AvanzarTurnoEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugadorTurno;
    private ArrayList<Jugador> jugadores;
    private Pregunta preguntaActual;
    private Temporizador temporizador;

    public AvanzarTurnoEventHandler(Jugador jugadorTurno, ArrayList<Jugador> jugadores, Pregunta preguntaActual, Temporizador temporizador){
        this.jugadorTurno = jugadorTurno;
        this.jugadores = jugadores;
        this.preguntaActual = preguntaActual;
        this.temporizador = temporizador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        KahootApp.setJugadorPresionoContinuar();
        KahootApp.cambiarEscena(preguntaActual, jugadores, jugadorTurno, temporizador);
    }
}
