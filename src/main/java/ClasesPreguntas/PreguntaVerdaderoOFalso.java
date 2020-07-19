package ClasesPreguntas;

import java.util.List;
import ClasesPreguntas.Puntajes.*;
import ClasesPreguntas.*;

public class PreguntaVerdaderoOFalso implements Pregunta{

    private List<Respuesta> respuestasCorrectas;
    private Puntaje tipoPuntaje;
    private List<Respuesta> respuestasPosibles;
    private String contenido;

    public PreguntaVerdaderoOFalso(List<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, List<Respuesta> respuestasPosibles, String pregunta){
        this.respuestasCorrectas = respuestasCorrectas;
        this.tipoPuntaje = tipoPuntaje;
        this.contenido = pregunta;
        this.respuestasPosibles = respuestasPosibles;
    }

    @Override
    public int calcularPuntaje(List<Respuesta> respuestas) {
        int cantRespuestasCorrectas = 0;
        for (Respuesta resp:respuestas){
            if (resp.esCorrecta(respuestasCorrectas))
                cantRespuestasCorrectas++;
        }
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectas));
    }
}
