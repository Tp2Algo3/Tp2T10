package Modelo.Preguntas;

import Modelo.Puntajes.Puntaje;
import Modelo.Respuestas.Respuesta;
import Modelo.Respuestas.RespuestaOrdenada;

import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta{

    public PreguntaOrderedChoice(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasOrdenadas, String pregunta){
        super(tipoPuntaje, respuestasOrdenadas, pregunta);
        if(respuestasPosibles.size() > 5 || respuestasPosibles.size() < 2)
            throw new IllegalArgumentException("Cantidad de respuestas posibles inválida. Rango Permitido 2-5. Pregunta OrderedChoice.");
    }


    @Override
    protected void calcularPuntajeIndividual(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectasDelUsuario = 0;

        for (int i = 0; i < respuestasDelUsuario.size(); i++) {
            RespuestaOrdenada respuestaOrdenada = (RespuestaOrdenada) respuestasDelUsuario.get(i);
            respuestaOrdenada.setPosicionRespuesta(i);

            if (respuestaOrdenada.esCorrecta()) { cantRespuestasCorrectasDelUsuario++; }
        }

        int cantOpcionesDeLaPregunta = this.respuestasPosibles.size();

        puntajesJugadores.add(this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantOpcionesDeLaPregunta, respuestasDelUsuario.size()));
        jugadoresContestaronCorrectamente.add(!this.tipoPuntaje.usuarioContestoErroneamente(cantOpcionesDeLaPregunta,cantRespuestasCorrectasDelUsuario));
    }
}
