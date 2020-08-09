package Jugador;

import Potenciadores.Multiplicador;
import Potenciadores.MultiplicadorDefecto;
import Potenciadores.MultiplicadorPorDos;
import Potenciadores.MultiplicadorPorTres;
import Preguntas.Pregunta;
import Respuestas.Respuesta;
import ErrorHandler.ErrorHandler;

import java.util.ArrayList;

public class Jugador implements Comparable<Jugador>{

    private int puntaje;
    private final String nombre;
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
        ArrayList<Respuesta> clonRespuestas = new ArrayList<>();
        for (Respuesta respuesta: respuestasElegidas){
            clonRespuestas.add(respuesta.clone());
        }
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

    public void utilizarMultiplicador(int id) {
        Multiplicador potenciador = multiplicadores
                .stream()
                .filter(pot -> pot.getId() == id)
                .findFirst()
                .orElse(null);

        if (potenciador != null) {
            multiplicadorActual = potenciador;
            multiplicadores.remove(potenciador);
        }
        else{
            throw new RuntimeException("El jugador no posee el multiplicador con el id indicado.");
        }
    }

    public void utilizarExclusividad(Pregunta pregunta){
        if(usosRestantesExclusividadPuntajes>0){
            try{
                pregunta.recibirExclusividad();
            }catch(IllegalArgumentException excepcionArgumento){
                ErrorHandler.cerrarPrograma(excepcionArgumento);
            }
            usosRestantesExclusividadPuntajes--;
        }
        else{
            throw new RuntimeException("No quedan usos de exclusividad en el jugador.");
        }
    }

    @Override
    public int compareTo(Jugador jugador) {
        if (puntaje < jugador.getPuntos()){
            return -1;
        }
        else if (puntaje > jugador.getPuntos()){
            return 1;
        }
        return 0;
    }

    public int getPuntos(){
        return this.puntaje;
    }

    //Para finalidad de UI
    public String getNombre() { return this.nombre;}

    //SOLO PARA FINALIDAD DE TESTING Y UI
    public int getUsosExclusividad() { return this.usosRestantesExclusividadPuntajes;}


}
