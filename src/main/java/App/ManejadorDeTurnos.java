package App;


import Jugador.Jugador;
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
    }

    public void update(){
        preguntaActual.calcularPuntajeIndividual(jugadores.get(jugadorActual).responderPregunta());
        if (jugadorActual == jugadores.size()-1){
            aumentarPuntajesJugadores();
            siguienteRonda();
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

    private void siguienteRonda(){
        jugadorActual=0;
        rondaActual++;
        preguntaActual = preguntas.get(rondaActual);
        siguienteTurno(preguntaActual);
    }

    private void siguienteTurno(Pregunta preguntaActual){
        //KahootApp.getStage().getScene().root(algo mandando la pregunta y el jugador);
    }

}
