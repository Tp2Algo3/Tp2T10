package ClasesPreguntas.Preguntas;

import ClasesPreguntas.Puntajes.Puntaje;
import ClasesPreguntas.Respuestas.Respuesta;
import ClasesPreguntas.Respuestas.RespuestaOrdenada;

import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta{

    public PreguntaOrderedChoice(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasOrdenadas, String pregunta){
        super(tipoPuntaje, respuestasOrdenadas, pregunta);
        if(respuestasPosibles.size() > 5 || respuestasPosibles.size() < 2)
            throw new RuntimeException("Cantidad de respuestas posibles inválida.");
    }


    @Override
    public void calcularPuntajeIndividual(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectasDelUsuario = 0;

        for (int i = 0; i < respuestasDelUsuario.size(); i++) {
            RespuestaOrdenada respuestaOrdenada = (RespuestaOrdenada) respuestasDelUsuario.get(i);
            respuestaOrdenada.setPosicionSegunElUsuario(i);

            if (respuestaOrdenada.esCorrecta()) { cantRespuestasCorrectasDelUsuario++; }
        }

        int cantOpcionesDeLaPregunta = this.respuestasPosibles.size();

        puntajesJugadores.add(this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantOpcionesDeLaPregunta, respuestasDelUsuario.size()));
        jugadoresContestaronCorrectamente.add(!this.tipoPuntaje.usuarioContestoErroneamente(cantRespuestasCorrectasDelUsuario,respuestasDelUsuario.size()));
    }
}
