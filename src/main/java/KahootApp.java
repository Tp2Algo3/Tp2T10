import ClasesPreguntas.Pregunta;
import Jugador.Jugador;

import java.util.ArrayList;

public class KahootApp {
    private Pregunta preguntaActual;
    private ArrayList<Jugador> jugadores;

    public KahootApp(){
        jugadores = new ArrayList<Jugador>();
        //Pedir nombre 1. NECESITAMOS UI
        jugadores.add(new Jugador("Pedrito"));
        //Pedir nombre 2. NECESITAMOS UI
        jugadores.add(new Jugador("Vendo Papa"));
    }

    public void main (){

    }
}
