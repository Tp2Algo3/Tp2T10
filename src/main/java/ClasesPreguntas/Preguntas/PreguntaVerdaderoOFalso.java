package ClasesPreguntas.Preguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.*;
import ClasesPreguntas.Respuestas.Respuesta;

public class PreguntaVerdaderoOFalso extends Pregunta{

    public PreguntaVerdaderoOFalso(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(tipoPuntaje, respuestasPosibles, pregunta);
        if(respuestasPosibles.size() != 2)
            throw new RuntimeException("Cantidad de respuestas posibles inválida.");
    }

}
