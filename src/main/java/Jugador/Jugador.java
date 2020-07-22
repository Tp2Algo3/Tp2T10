package Jugador;

import ClasesPreguntas.Respuesta;
import Jugador.Potenciadores.*;
import java.util.ArrayList;

public class Jugador {

    private int puntaje;
    private String nombre;
    private ArrayList<Potenciador> potenciadores;

    public Jugador(String nombre){
        this.puntaje = 0;
        this.nombre = nombre;
        this.potenciadores = new ArrayList<>();
        this.potenciadores.add(new MultiplicadorDefecto());
        this.potenciadores.add(new MultiplicadorPorDos());
        this.potenciadores.add(new MultiplicadorPorTres());
        this.potenciadores.add(new ExclusividadPuntaje());
    }

    public ArrayList<Respuesta> responderPregunta(ArrayList<Respuesta> respuestasPosibles){
        //IMPLEMENTAR LA DEVOLUCIÓN DE LA LISTA DE RESPUESTAS. REQUERIMOS LOS BOTONES DE LA UI
        //SE RESUELVE CON EVENT HANDLER DE LOS BOTONES.
        return new ArrayList<>();
    }

    public void aumentarPuntaje(int puntajeASumar){
        this.puntaje += puntajeASumar;
    }

    public int getPuntos(){
        return this.puntaje;
    }

}
