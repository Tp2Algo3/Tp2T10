package Preguntas;

import Puntajes.Puntaje;
import Respuestas.Respuesta;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta{

    public PreguntaGroupChoice(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(tipoPuntaje, respuestasPosibles, pregunta);
        if(respuestasPosibles.size() > 6 || respuestasPosibles.size() < 2)
            throw new IllegalArgumentException("Cantidad de respuestas posibles inválida. Rango permitido 2-6. Pregunta GroupChoice.");
    }

    @Override
    public void calcularPuntajeIndividual(ArrayList<Respuesta> respuestasUsuario){

        int cantRespuestasCorrectasDelUsuario=(int) respuestasUsuario
                .stream()
                .filter(respuesta -> respuesta.esCorrecta())
                .count();

        int cantRespuestasCorrectasDeLaPregunta = respuestasPosibles.size();

        puntajesJugadores.add(this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta, respuestasUsuario.size()));

        jugadoresContestaronCorrectamente.add(!this.tipoPuntaje.usuarioContestoErroneamente(respuestasUsuario.size(),cantRespuestasCorrectasDelUsuario));

    }
}
