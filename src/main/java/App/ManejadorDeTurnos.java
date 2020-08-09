package App;


import Jugador.Jugador;
import LayoutsUI.PuntajesActuales;
import Preguntas.*;
import java.util.ArrayList;



public class ManejadorDeTurnos {

    private ArrayList<Jugador> jugadores;
    private ArrayList<Pregunta> preguntas;
    int jugadorActual;
    int rondaActual;
    Pregunta preguntaActual;

    public ManejadorDeTurnos(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas){
        this.jugadores=jugadores;
        this.preguntas=preguntas;
        jugadorActual=0;
        rondaActual=0;
        preguntaActual = preguntas.get(rondaActual);
    }

    public void update(){
        if (jugadorActual!=0) {
            preguntaActual.calcularPuntajeIndividual(jugadores.get(jugadorActual).responderPregunta());
            jugadorActual++;
        }
        if (jugadorActual == jugadores.size()){
            aumentarPuntajesJugadores();
            mostrarPuntajes();
        }
        else {
            siguienteTurno(preguntaActual);
        }
    }

    private void aumentarPuntajesJugadores(){
        ArrayList<Integer> puntajesRonda = preguntaActual.definirPuntajesDeJugadores();
        for (int i=0; i<jugadores.size(); i++){
            jugadores.get(i).aumentarPuntaje(puntajesRonda.get(i));
        }
    }

    private void mostrarPuntajes(){
        jugadorActual=0;
        rondaActual++;
        preguntaActual = preguntas.get(rondaActual);
        KahootApp.getStage().getScene().setRoot(PuntajesActuales.getLayout(jugadores, rondaActual));
    }

    private void siguienteTurno(Pregunta preguntaActual){
        //KahootApp.getStage().getScene().setRoot(algo mandando la pregunta y el jugador);
    }

}
