package Modelo.Turnos;


import Modelo.Jugador.Jugador;
import PatronObserver.Observado;
import PatronObserver.Observer;
import Vista.KahootApp;
import Modelo.Preguntas.*;
import Modelo.Respuestas.Respuesta;
import java.util.ArrayList;



public class ManejadorDeTurnos{

    private final ArrayList<Jugador> jugadores;
    private final ArrayList<Pregunta> preguntas;
    private int jugadorActual;
    private int rondaActual;
    private Pregunta preguntaActual;
    private ArrayList<ArrayList<Respuesta>> respuestasJugadores;
    private Temporizador temporizador;

    public ManejadorDeTurnos(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas){
        this.jugadores=jugadores;
        this.preguntas=preguntas;
        jugadorActual=-1;
        rondaActual=0;
        preguntaActual = preguntas.get(rondaActual);
        respuestasJugadores = new ArrayList<>();
        temporizador = new Temporizador(60000);
    }

    public void siguienteFase(){
        if (jugadorActual>=0){
            temporizador = temporizador.generarNuevoTemporizador();
            aniadirRespuestasJugador();
        }
        if (quedanJugadoresPorJugar()){
            siguienteTurno();
        }
        else{
            finDeRonda();
            avanzarDeRonda();
        }
    }

    private boolean quedanJugadoresPorJugar(){
        return jugadorActual<jugadores.size()-1;
    }

    private void finDeRonda(){
        aumentarPuntajesJugadores();
        KahootApp.mostrarPuntajes(jugadores, rondaActual);
        respuestasJugadores.clear();
    }

    private void aumentarPuntajesJugadores(){
        ArrayList<Integer> puntajesRonda = preguntaActual.definirPuntajesDeJugadores(respuestasJugadores);
        for (int i=0; i<jugadores.size(); i++){
            jugadores.get(i).aumentarPuntaje(puntajesRonda.get(i));
        }
        for (Jugador jugador: jugadores){
            jugador.borrarRespuestas();
        }
    }

    private void avanzarDeRonda(){
        jugadorActual=-1;
        rondaActual++;
        if (rondaActual >= preguntas.size()){
            finDelJuego();
            return;
        }
        preguntaActual = preguntas.get(rondaActual);
    }

    private void siguienteTurno(){
        jugadorActual++;
        KahootApp.cambiarEscena(preguntaActual, jugadores, jugadores.get(jugadorActual), temporizador);
    }

    private void aniadirRespuestasJugador(){
        respuestasJugadores.add(jugadores.get(jugadorActual).responderPregunta());
        temporizador = temporizador.generarNuevoTemporizador();
    }

    private void finDelJuego(){
        temporizador.cancel();
        temporizador.purge();
        KahootApp.definirPuestos(jugadores);
    }

}
