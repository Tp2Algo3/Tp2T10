package Modelo.Preguntas;

import java.util.ArrayList;

import Modelo.Respuestas.Respuesta;
import Modelo.Puntajes.Puntaje;

public class PreguntaOpcionMultiple extends Pregunta{

    public PreguntaOpcionMultiple(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(tipoPuntaje, respuestasPosibles, pregunta);
        if(respuestasPosibles.size() > 5 || respuestasPosibles.size() < 2)
            throw new IllegalArgumentException("Cantidad de respuestas posibles inválida. Rango permitido 2-5. Pregunta MultipleChoice.");
    }

}
