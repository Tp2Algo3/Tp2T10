package Modelo.Preguntas;

import java.util.ArrayList;

import Modelo.Excepciones.PuntajeInvalidoExcepcion;
import Modelo.Puntajes.Puntaje;
import Modelo.Respuestas.Respuesta;
import Modelo.Potenciadores.ExclusividadPuntaje;

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

    protected void calcularPuntajeIndividual(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta;

        cantRespuestasCorrectasDeLaPregunta =(int) respuestasPosibles
                .stream()
                .filter(Respuesta::esCorrecta)
                .count();

        cantRespuestasCorrectasDelUsuario =(int) respuestasDelUsuario
                .stream()
                .filter(Respuesta::esCorrecta)
                .count();

        puntajesJugadores.add(this.tipoPuntaje
                .calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta, respuestasDelUsuario.size()));

        jugadoresContestaronCorrectamente.add(!this.tipoPuntaje
                .usuarioContestoErroneamente(respuestasDelUsuario.size(), cantRespuestasCorrectasDelUsuario));
    }

    public ArrayList<Integer> definirPuntajesDeJugadores(ArrayList<ArrayList<Respuesta>> respuestasJugadores){
        for (ArrayList<Respuesta> respuestasJugador: respuestasJugadores){
            calcularPuntajeIndividual(respuestasJugador);
        }
        for(ExclusividadPuntaje exclusividad: exclusividadesPuntaje){
            exclusividad.multiplicarPuntos(puntajesJugadores,jugadoresContestaronCorrectamente);
        }
        return puntajesJugadores;
    }

    public void recibirExclusividad(){

        if (tipoPuntaje.admiteExclusividad()) {
            exclusividadesPuntaje.add(new ExclusividadPuntaje());
        }
        else{ throw new PuntajeInvalidoExcepcion("Preguntas con penalizacion no pueden tener exclusividad de puntaje."); }

    }

    public ArrayList<Respuesta> getRespuestas(){
        return respuestasPosibles;
    }

    public String getContenido(){
        return contenido;
    }

    public Puntaje getTipoPuntaje(){return tipoPuntaje;}
}