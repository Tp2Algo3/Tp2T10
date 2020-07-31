package ClasesPreguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.*;

public class PreguntaVerdaderoOFalso extends Pregunta{

    public PreguntaVerdaderoOFalso(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta){
        super(tipoPuntaje, respuestasPosibles, pregunta);
        if(respuestasPosibles.size() != 2)
            throw new RuntimeException("Cantidad de respuestas posibles inválida.");
    }

}
