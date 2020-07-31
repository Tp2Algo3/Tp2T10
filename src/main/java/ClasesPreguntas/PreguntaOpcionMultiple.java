package ClasesPreguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.*;

public class PreguntaOpcionMultiple extends Pregunta{

    public PreguntaOpcionMultiple(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(tipoPuntaje, respuestasPosibles, pregunta);
        if(respuestasPosibles.size() > 5 || respuestasPosibles.size() < 2)
            throw new RuntimeException("Cantidad de respuestas posibles inválida.");
    }

}
