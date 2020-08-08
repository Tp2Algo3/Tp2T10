package Preguntas;

import java.util.ArrayList;
import Puntajes.Puntaje;
import Puntajes.PuntajePenalizacion;
import Respuestas.Respuesta;
import Potenciadores.ExclusividadPuntaje;

public abstract class Pregunta {

    protected Puntaje tipoPuntaje;
    protected ArrayList<Respuesta> respuestasPosibles;
    protected String contenido;
    protected ArrayList <Boolean> jugadoresContestaronCorrectamente;
    protected ArrayList <Integer> puntajesJugadores;
    protected ArrayList <ExclusividadPuntaje> exclusividadesPuntaje;

    public Pregunta(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta) {
        this.tipoPuntaje = tipoPuntaje;
        this.contenido = pregunta;
        this.respuestasPosibles = respuestasPosibles;
        this.jugadoresContestaronCorrectamente = new ArrayList<>();
        this.puntajesJugadores = new ArrayList<>();
        this.exclusividadesPuntaje = new ArrayList<>();
    }

    public void calcularPuntajeIndividual(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta;

        cantRespuestasCorrectasDeLaPregunta =(int) respuestasPosibles
                .stream()
                .filter(respuesta -> respuesta.esCorrecta())
                .count();

        cantRespuestasCorrectasDelUsuario =(int) respuestasDelUsuario
                .stream()
                .filter(respuesta -> respuesta.esCorrecta())
                .count();

        puntajesJugadores.add(this.tipoPuntaje
                .calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta, respuestasDelUsuario.size()));

        jugadoresContestaronCorrectamente.add(!this.tipoPuntaje
                .usuarioContestoErroneamente(respuestasDelUsuario.size(), cantRespuestasCorrectasDelUsuario));
    }

    public ArrayList<Integer> definirPuntajesDeJugadores(){
        for(ExclusividadPuntaje exclusividad: exclusividadesPuntaje){
            exclusividad.multiplicarPuntos(puntajesJugadores,jugadoresContestaronCorrectamente);
        }
        return puntajesJugadores;
    }

    public void recibirExclusividad(){

        if (tipoPuntaje.admiteExclusividad()) {
            exclusividadesPuntaje.add(new ExclusividadPuntaje());
        }
        else{ throw new IllegalArgumentException("Preguntas con penalizacion no pueden tener exclusividad de puntaje."); }

    }

    public String getContenido(){
        return contenido;
    }
}