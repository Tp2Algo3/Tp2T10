package Jugador;

import ClasesPreguntas.Respuesta;
import Jugador.Potenciadores.*;
import java.util.ArrayList;

public class Jugador {

    private int puntaje;
    private String nombre;
    private Potenciador potenciadorActual;
    private ArrayList<Potenciador> potenciadores;
    private ArrayList<Respuesta> respuestasElegidas;

    public Jugador(String nombre){
        this.puntaje = 0;
        this.nombre = nombre;
        this.potenciadorActual = new MultiplicadorDefecto();
        this.potenciadores = new ArrayList<>();
        this.potenciadores.add(new MultiplicadorPorDos());
        this.potenciadores.add(new MultiplicadorPorTres());
        this.potenciadores.add(new ExclusividadPuntaje());
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
        this.puntaje += this.potenciadorActual.multiplicarPuntos(puntajeASumar);
        this.potenciadorActual = new MultiplicadorDefecto();
    }

    public void utilizarPotenciador(Class potenciadorAUsar) {
        Potenciador potenciador = potenciadores
                .stream()
                .filter(pot -> pot.getClass() == potenciadorAUsar)
                .findFirst()
                .orElse(null);

        if (potenciador != null) {
            potenciadorActual = potenciador;
            potenciadores.remove(potenciador);
        }
    }

    public int getPuntos(){
        return this.puntaje;
    }

}
