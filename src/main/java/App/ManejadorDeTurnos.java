package App;


import Jugador.Jugador;
import LayoutsUI.PreguntaYRespuesta;
import LayoutsUI.PuntajesActuales;
import Preguntas.*;
import Respuestas.Respuesta;
import java.util.ArrayList;



public class ManejadorDeTurnos {

    private final ArrayList<Jugador> jugadores;
    private final ArrayList<Pregunta> preguntas;
    private int jugadorActual;
    private int rondaActual;
    private Pregunta preguntaActual;
    private ArrayList<ArrayList<Respuesta>> respuestasJugadores;

    public ManejadorDeTurnos(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas){
        this.jugadores=jugadores;
        this.preguntas=preguntas;
        jugadorActual=-1;
        rondaActual=0;
        preguntaActual = preguntas.get(rondaActual);
        respuestasJugadores = new ArrayList<>();
    }

    public void siguienteFase(){
        if (jugadorActual>=0){
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
        mostrarPuntajes();
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

    private void mostrarPuntajes(){
        KahootApp.getStage().getScene().setRoot(PuntajesActuales.getLayout(jugadores, rondaActual));
    }

    private void avanzarDeRonda(){
        jugadorActual=-1;
        rondaActual++;
        if (rondaActual >= preguntas.size()-1){
            finDelJuego();
            return;
        }
            preguntaActual = preguntas.get(rondaActual);
    }

    private void siguienteTurno(){
        jugadorActual++;
        KahootApp.getStage().getScene().setRoot
                (PreguntaYRespuesta.getLayout(preguntaActual, jugadores, jugadores.get(jugadorActual)));
        //KahootApp.getStage().getScene().setRoot(algo mandando la pregunta y el jugador);

    }

    private void aniadirRespuestasJugador(){
        respuestasJugadores.add(jugadores.get(jugadorActual).responderPregunta());

    }

    private void finDelJuego(){
        KahootApp.definirPuestos(jugadores);
    }

}
