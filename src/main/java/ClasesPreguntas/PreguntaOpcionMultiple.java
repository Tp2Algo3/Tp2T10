package ClasesPreguntas;

import java.util.List;
import ClasesPreguntas.Puntajes.*;

public class PreguntaOpcionMultiple extends Pregunta{

    public PreguntaOpcionMultiple(List<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, List<Respuesta> respuestasPosibles, String pregunta){
        this.respuestasCorrectas = respuestasCorrectas;
        this.tipoPuntaje = tipoPuntaje;
        this.contenido = pregunta;
        this.respuestasPosibles = respuestasPosibles;
    }
    
    public int calcularPuntaje(List<Respuesta> respuestas) {
        int cantRespuestasCorrectas = 0;
        for (Respuesta resp:respuestas){
            if (resp.pertenece(respuestasCorrectas))
                cantRespuestasCorrectas++;
        }
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectas, respuestasCorrectas.size()));
    }
}
