package Modelo.Preguntas;

import Modelo.Grupo.Grupo;
import Modelo.Puntajes.Puntaje;
import Modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta{

    private ArrayList<Grupo> gruposPosibles;

    public PreguntaGroupChoice(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(tipoPuntaje, respuestasPosibles, pregunta);
        if(respuestasPosibles.size() > 6 || respuestasPosibles.size() < 2)
            throw new IllegalArgumentException("Cantidad de respuestas posibles inválida. Rango permitido 2-6. Pregunta GroupChoice.");
    }

    @Override
    protected void calcularPuntajeIndividual(ArrayList<Respuesta> respuestasUsuario){

        int cantRespuestasCorrectasDelUsuario=(int) respuestasUsuario
                .stream()
                .filter(Respuesta::esCorrecta)
                .count();

        int cantRespuestasCorrectasDeLaPregunta = respuestasPosibles.size();

        puntajesJugadores.add(this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta, respuestasUsuario.size()));

        jugadoresContestaronCorrectamente.add(!this.tipoPuntaje.usuarioContestoErroneamente(respuestasUsuario.size(),cantRespuestasCorrectasDelUsuario));

    }

    public void setGruposPosibles(ArrayList<Grupo> gruposPosibles) {
        this.gruposPosibles = gruposPosibles;
    }

    public ArrayList<Grupo> getGrupos(){return gruposPosibles;}
}
