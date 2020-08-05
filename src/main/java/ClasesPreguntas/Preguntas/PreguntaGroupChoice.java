package ClasesPreguntas.Preguntas;

import ClasesPreguntas.Puntajes.Puntaje;
import ClasesPreguntas.Respuestas.Respuesta;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta{

    public PreguntaGroupChoice(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){  // Grupo A es verdadero grupo B falso
        super(tipoPuntaje, respuestasPosibles, pregunta);
        if(respuestasPosibles.size() > 6 || respuestasPosibles.size() < 2)
            throw new RuntimeException("Cantidad de respuestas posibles inválida.");
    }

@Override
    public void calcularPuntajeIndividual(ArrayList<Respuesta> respuestasUsuario){

        int cantRespuestasCorrectasDelUsuario=(int) respuestasUsuario.stream().filter(respuesta -> respuesta.esCorrecta()).count();
        int cantRespuestasCorrectasDeLaPregunta =(int) respuestasPosibles.stream().filter(respuesta -> respuesta.esCorrecta()).count();
        puntajesJugadores.add(this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta, respuestasUsuario.size()));
        jugadoresContestaronCorrectamente.add(!this.tipoPuntaje.usuarioContestoErroneamente(cantRespuestasCorrectasDelUsuario,respuestasUsuario.size()));

    }
}
