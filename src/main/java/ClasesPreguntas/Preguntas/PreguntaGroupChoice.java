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
    public int calcularPuntaje(ArrayList<Respuesta> respuestasUsuario){

        int cantRespuestasCorrectasDeLaPregunta =(int) respuestasUsuario.stream().filter(respuesta -> respuesta.esCorrecta()).count();
        return this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDeLaPregunta, respuestasPosibles.size(), respuestasUsuario.size());

    }
}
