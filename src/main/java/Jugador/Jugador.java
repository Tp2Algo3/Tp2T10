package Jugador;

import ClasesPreguntas.Preguntas.Pregunta;
import ClasesPreguntas.Respuestas.Respuesta;
import Jugador.Potenciadores.*;
import java.util.ArrayList;

public class Jugador {

    private int puntaje;
    private String nombre;
    private Multiplicador multiplicadorActual;
    private ArrayList<Multiplicador> multiplicadores;
    private int usosRestantesExclusividadPuntajes;
    private ArrayList<Respuesta> respuestasElegidas;

    public Jugador(String nombre){
        this.puntaje = 0;
        this.nombre = nombre;
        this.respuestasElegidas = new ArrayList<>();
        this.multiplicadorActual = new MultiplicadorDefecto();
        this.multiplicadores = new ArrayList<>();
        this.multiplicadores.add(new MultiplicadorPorDos());
        this.multiplicadores.add(new MultiplicadorPorTres());
        this.usosRestantesExclusividadPuntajes = 2;
    }

    public ArrayList<Respuesta> responderPregunta(){
        ArrayList<Respuesta> clonRespuestas = (ArrayList<Respuesta>) respuestasElegidas.clone();
        respuestasElegidas.clear();
        return clonRespuestas;
    }

    public void eliminarRespuesta(Respuesta respuestaARemover){
        respuestasElegidas.remove(respuestaARemover);
    }

    public void aniadirRespuesta(Respuesta respuesta){
        respuestasElegidas.add(respuesta);
    }

    public void aumentarPuntaje(int puntajeASumar){
        this.puntaje += this.multiplicadorActual.multiplicarPuntos(puntajeASumar);
        this.multiplicadorActual = new MultiplicadorDefecto();
    }

    public void utilizarMultiplicador(Class potenciadorAUsar) {
        Multiplicador potenciador = multiplicadores
                .stream()
                .filter(pot -> pot.getClass() == potenciadorAUsar)
                .findFirst()
                .orElse(null);

        if (potenciador != null) {
            multiplicadorActual = potenciador;
            multiplicadores.remove(potenciador);
        }
    }

    public void utilizarExclusividad(Pregunta pregunta){
        if(usosRestantesExclusividadPuntajes>0){
            pregunta.recibirExclusividad();
            usosRestantesExclusividadPuntajes--;
        }
    }

    public int getPuntos(){
        return this.puntaje;
    }
    public String getNombre() { return this.nombre;}

    //SOLO PARA FINALIDAD DE TESTING
    public int getUsosExclusividad() { return this.usosRestantesExclusividadPuntajes;}

}
