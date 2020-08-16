package Modelo.Jugador;

import Modelo.Excepciones.MultiplicadorEnUsoException;
import Modelo.Excepciones.MultiplicadorNoDisponibleException;
import Modelo.Excepciones.NoQuedanExclusividadesException;
import Modelo.Potenciadores.Multiplicador;
import Modelo.Potenciadores.MultiplicadorDefecto;
import Modelo.Potenciadores.MultiplicadorPorDos;
import Modelo.Potenciadores.MultiplicadorPorTres;
import Modelo.Preguntas.Pregunta;
import Modelo.Respuestas.Respuesta;
import Controladores.ErrorHandler;
import PatronObserver.Observado;

import java.util.ArrayList;

public class Jugador extends Observado implements Comparable<Jugador> {

    private int puntaje;
    private final String nombre;
    private Multiplicador multiplicadorActual;
    private final ArrayList<Multiplicador> multiplicadores;
    private int usosRestantesExclusividadPuntajes;
    private final ArrayList<Respuesta> respuestasElegidas;

    public Jugador(String nombre){
        this.puntaje = 0;
        this.nombre = nombre;
        this.respuestasElegidas = new ArrayList<>();
        this.multiplicadorActual = new MultiplicadorDefecto();
        this.multiplicadores = new ArrayList<>();
        this.multiplicadores.add(new MultiplicadorPorDos());
        this.multiplicadores.add(new MultiplicadorPorTres());
        this.usosRestantesExclusividadPuntajes = 2;
        this.observadores = new ArrayList<>();
    }

    public ArrayList<Respuesta> responderPregunta(){
        ArrayList<Respuesta> clonRespuestas = new ArrayList<>();
        for (Respuesta respuesta: respuestasElegidas){
            clonRespuestas.add(respuesta.clone());
        }
        return clonRespuestas;
    }

    public ArrayList<Respuesta> getRespuestasElegidas(){
        return respuestasElegidas;
    }

    public void borrarRespuestas(){
        respuestasElegidas.clear();
    }

    public void eliminarRespuesta(Respuesta respuestaARemover){
        respuestasElegidas.remove(respuestaARemover);
        notificar();
    }

    public void aniadirRespuesta(Respuesta respuesta){
        respuestasElegidas.add(respuesta);
        notificar();
    }

    public void aumentarPuntaje(int puntajeASumar){
        this.puntaje += this.multiplicadorActual.multiplicarPuntos(puntajeASumar);
        this.multiplicadorActual = new MultiplicadorDefecto();
    }

    public void utilizarMultiplicador(Multiplicador multiplicador) {
        if (multiplicadorActual.getOrdenMultiplicidad() == 1) {
            Multiplicador potenciador = multiplicadores
                    .stream()
                    .filter(pot -> pot.equals(multiplicador))
                    .findFirst()
                    .orElse(null);

            if (potenciador != null) {
                multiplicadorActual = potenciador;
                multiplicadores.remove(potenciador);
            } else {
                throw new MultiplicadorNoDisponibleException();
            }
        }
        else{
            throw new MultiplicadorEnUsoException();
        }
        notificar();
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
            throw new NoQuedanExclusividadesException();
        }
    }

    @Override
    public int compareTo(Jugador jugador) {
        if (puntaje < jugador.getPuntos()){
            return 1;
        }
        else if (puntaje > jugador.getPuntos()){
            return -1;
        }
        return 0;
    }

    public int getPuntos(){
        return this.puntaje;
    }

    public Multiplicador getMultiplicadorActual(){return multiplicadorActual;}

    //Para finalidad de UI
    public ArrayList<Multiplicador> getMultiplicadores(){ return this.multiplicadores; }

    //Para finalidad de UI
    public String getNombre() { return this.nombre;}

    //SOLO PARA FINALIDAD DE TESTING Y UI
    public int getUsosExclusividad() { return this.usosRestantesExclusividadPuntajes;}


}
